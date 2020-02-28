import React from 'react';
import { Link } from "react-router-dom";

export default () => {
  return (
    <div className="search">
      <div className="search-inner">
        <h3 className="search-title text-dark font-weight-bold">Plan Your Trip</h3>
        <div class="form-group">
          <input className="form-control" placeholder="Destination"></input>
        </div>
        <div class="form-group">
          <input className="form-control" placeholder="Duration"></input>
        </div>
        <div class="form-group">
          <input className="form-control" placeholder="Traveler"></input>
        </div>
        <Link to="/register" className="btn btn-secondary btn-lg btn-block">
          Plan it!
        </Link>
      </div>
    </div>
  );
};