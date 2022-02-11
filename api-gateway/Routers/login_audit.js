var express = require('express');
var config = require('../config');
const apiAdapter = require('./apiAdapter');

var router = express.Router();

const { routeURLS: {login_audit}} = config;

const api = apiAdapter(login_audit);

router.get('/getData/:userName/:page', (req, res) => {
    
    api.get(req.path,{Headers:{'Access-Control-Allow-Origin': '*',}}).then(resp => {
        res.send(resp.data);
    });
});

router.post('/saveRadar', (req, res) => {
    api.post(req.path, req.body).then(resp => {
        res.send(resp.data);
    });
});

router.get('/root', (req, res) => {
    api.get(req.path,{Headers:{'Access-Control-Allow-Origin': '*',}}).then(resp => {
        res.send(resp.data);
    });
});

router.post('/root/save', (req, res) => {
    console.log("rootmsave ");
    api.post(req.path, req.body,{Headers:{'Access-Control-Allow-Origin': '*',}}).then(resp => {
        res.send(resp.data);
    });
});
router.post('/root/delete', (req, res) => {
    api.post(req.path, req.body).then(resp => {
        res.send(resp.data);
    });
});
router.post('/root/auth', (req, res) => {
    api.post(req.path, req.body).then(resp => {
        res.send(resp.data);
    });
});

module.exports = router;