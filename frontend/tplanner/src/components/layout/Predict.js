import React, { Component } from "react";
import axios from "axios";

export default class Predict extends Component {
  constructor() {
    super();
    this.state = {
      prediction: null,
      path: null,
      last: null
    };
  }

  getBase64(file, cb) {
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function() {
      cb(reader.result);
    };
    reader.onerror = function(error) {
      console.log("Error: ", error);
    };
  }

  fileSelectedHandler = event => {
    if (event.target.files[0].name !== this.state.last) {
      const fname = event.target.files[0].name;
      this.getBase64(event.target.files[0], result => {
        const enc64 = result;
        axios
          .post("/api/upload", {
            pic: enc64,
            name: fname
          })
          .then(res => {
            console.log("Path is " + res.data.path);
            this.setState({
              prediction: null,
              path: res.data.path,
              last: fname
            });
          })

          .catch(err => {
            console.log(err);
          });
      });
    }
  };

  predict = () => {
    if (this.state.path && !this.state.prediction) {
      console.log("predict...");
      axios
        .post("/api/predict", { path: this.state.path })
        .then(res => {
          console.log(res.data.out);
          this.setState({
            prediction: res.data.out,
            path: this.state.path,
            last: this.state.last
          });
        })
        .catch(err => {
          console.log(err);
        });
    }
  };

  render() {
    return (
      <div>
        <input
          type="file"
          align="middle"
          accept="image/jpg"
          onChange={this.fileSelectedHandler}
        />
        <div onClick={this.predict()} />
        <h1 align="middle">Your result is {this.state.prediction}</h1>
      </div>
    );
  }
}
