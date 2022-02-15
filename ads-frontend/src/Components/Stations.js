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
    // window.addEventListener('keydown', this.tabKeyPressed);
    // window.addEventListener('mousedown', this.mouseClicked);
    
    getRadarStations().then(res => {
      var station = [];
      for(var key in res) {
        station.push({'label': res[key], 'value': key});
      }
      this.setState({...this.state, locations: station});
    }).catch(err => {
      console.log(err);
    });

  }
  onChange = (item, name) => { 
   
    localStorage.setItem('rStation',item.value);
    
  }

  render() {
    const { locations } = this.state;

    return (
        <div className="wrapper">
    
          <Dropdown
            name="location"
            title="Select location"
            list={locations}
           
            onChange={this.onChange}
          />
        </div>
    
    );
  }
}

export default Stations;
