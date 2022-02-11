// const axios = require('axios');
import axios from 'axios';

export function sendDate_Time(selectedDate)
{
    axios.post('https://localhost:5500/getImage/', {selectedDate}).then(res => {
    console.log(res);
    console.log(res.data);
  })
}

export function getRadarStations()
{
    axios.get('https://localhost:5500/radarLocations').then(res=>{
    console.log(res.data);
    return res.data;
    }
    )
    ;
    
}


// export default {
//     sendDate_Time,getRadarStations
// }