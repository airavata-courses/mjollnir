var express = require('express');
var config = require('../config');
const apiAdapter = require('./apiAdapter');

var router = express.Router();

const { routeURLS: {DataRetrival}} = config;

const api = apiAdapter(DataRetrival);


router.get('/getImage/:year/:date/:startHour/:endHour/:radarId', (req, res) => {
    
    api.get(req.path,{Headers:{'Access-Control-Allow-Origin': '*',}}).then(resp => {
        res.send(resp.data);
    });
});

// router.post('/getImage', (req, res) => {
//     let dat = req.selectedDate;

//     console.log(dat)
//      const goal=dat.split(" ");
//      const time=goal[4].split(":");
    
//     api.get(req.path+/{goal[3]+/goal[2]+/time[0]+/time[0]+/})
// })

module.exports = router;