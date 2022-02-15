var express = require('express');
var config = require('../config');
const apiAdapter = require('./apiAdapter');

var router = express.Router();

const { routeURLS: {DataRetrival}} = config;

const api = apiAdapter(DataRetrival);


router.post('/getImage', (req, res) => {
    
    api.post(req.path,req.body).then(resp => {
        res.send(resp.data);
    }).catch(err => res.send(err));
});

// router.post('/getImage', (req, res) => {
//     let dat = req.selectedDate;

//     console.log(dat)
//      const goal=dat.split(" ");
//      const time=goal[4].split(":");
    
//     api.get(req.path+/{goal[3]+/goal[2]+/time[0]+/time[0]+/})
// })

module.exports = router;