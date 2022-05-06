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



module.exports = router;