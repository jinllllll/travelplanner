import React, { Component } from "react";
import axios from "axios";
export default class Predict1 extends Component {
  state = {
    selectedFile: null
  };
  fileSelectedHandler = event => {
    this.setState({
      selectedFile: event.target.files[0]
    });
  };

  fileUploadHandler = event => {};

  render() {
    return (
      <div>
        <input type="file" onChange={this.fileSelectedHandler} />
        <button onClick={this.fileUploadHandler}>Upload</button>
      </div>
    );
  }
}
