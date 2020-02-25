import React, { Component } from "react";
import { Link } from "react-router-dom";
import { PropTypes } from "prop-types";
import { connect } from "react-redux";
import Navbar from "./Navbar";
import Search from "./Search";

class Landing extends Component {
  componentDidMount() {
    if (this.props.auth.isAuthenticated) {
      this.props.history.push("/dashboard");
    }
  }

  render() {
    return (
      <div className="landing">
        <Navbar />
        <div className="dark-overlay landing-inner text-light">
          <div className="container intro-search">
            <div className="row">
              <div className="col-md-12 text-right">
                <div className="intro">
                  <h1 className="display-4 mb-4 font-weight-bold">Smart Trip Planner</h1>
                  <hr />
                  <p className="mx-auto lead">
                    {" "}
                    Plan your perfect trip with a single click
                  </p>
                </div>
                <Search />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Landing.propTypes = {
  auth: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  auth: state.auth
});

export default connect(mapStateToProps)(Landing);
