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

    return axios.post('http://localhost:5500/getImage', sen).then(res => {
    console.log(res,sen) ; 
    return res.data.image
    })
}
export function sendMerraData()
{
  var date=localStorage.getItem("selectedDate")
   var dat=[]
    dat=date.split(" ");
   var tim=[]
       tim=dat[4].split(":");
 
  var dict={Jan:"01",Feb:"02",Mar:"03",Apr:"04",May:"05",Jun:"06",Jul:"07",Aug:"08",Sep:"09",Oct:"10",Nov:"11",Dec:"12"}

  var sen={ "date": dat[2]+"/"+dict[dat[1]]+"/"+dat[3]+" "+tim[0]+":"+tim[1]} 
  console.log(sen)
    return axios.post('http://localhost:5500/getMerraImage', sen).then(res => { 
    return res.data.image
    })
}

export function getRadarStations()
{
  return axios.get('http://localhost:5500/radarcontroller/radarlocations').then(resp=> resp.data);
}

