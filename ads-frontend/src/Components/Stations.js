import React, { Component } from 'react';
import { Dropdown } from 'reactjs-dropdown-component';

import {getRadarStations} from '../api_calls.js';

class Stations extends Component {
  constructor() {
    super();
    this.state = {
      locations: [],
    };
  }

  componentDidMount() {
    window.addEventListener('keydown', this.tabKeyPressed);
    window.addEventListener('mousedown', this.mouseClicked);
    var stats=getRadarStations();
    this.setState({locations:stats});
    
    console.log(stats);
  }



  onChange = (item, name) => { console.log(item, name); }

  render() {
    const { locations } = this.state;

    return (
      <div className="App">


        <div className="wrapper">
    
          <Dropdown
            name="location"
            title="Select location"
            list={locations}
            onChange={this.onChange}
          />
        </div>


      </div>
    );
  }
}

export default Stations;
