import React, { Component } from 'react';

// import {sendData,getRadarStations} from '../api_calls.js';

export default (props) =>(
    <div>
        {props.image ? <center><img src={props.image} ></img></center> : <div/>}
    </div>
);



