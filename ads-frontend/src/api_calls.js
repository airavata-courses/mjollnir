// const axios = require('axios');
import axios from 'axios';
import Stations from './Components/Stations';

export function sendData()
{
  var date=localStorage.getItem("selectedDate")
  var rad=localStorage.getItem("rStation")
  
   var dat=[]
    dat=date.split(" ");
   var tim=[]
       tim=dat[4].split(":");

  var sen={
           "radarId": rad,
           "year" : dat[3],
           "month": dat[1],
           "date" : dat[2],
           "startHour": tim[0],
           "endHour" : tim[0]
       }

    axios.post('http://localhost:5500/getImage/', sen).then(res => {
    console.log(res);
    console.log(res.data);
  })
}

export function getRadarStations()
{
  return axios.get('http://localhost:5500/radarcontroller/radarlocations').then(resp=> resp.data);
}

