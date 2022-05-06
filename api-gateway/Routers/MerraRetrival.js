var express = require('express');
var config = require('../config');
const apiAdapter = require('./apiAdapter');

var router = express.Router();

const { routeURLS: {MerraRetrival}} = config;

const api = apiAdapter(MerraRetrival);


router.post('/getMerraImage', (req, res) => {
    console.log(req);
    api.post(req.path,req.body).then(resp => {
        
        res.send(resp.data);
        
    }).catch(err => res.send(err));
});


module.exports = router;