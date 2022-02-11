var express = require('express');
var bodyParser = require('body-parser');

const cors=require('cors');
var router = require('./routers/router');
var config = require('./config');

const corsOpts = {
    origin: '*',
  
    methods: [
      'GET',
      'POST',
    ],
  
    allowedHeaders: [
      'Content-Type',
    ],
  };
var app = express();

app.use(cors(corsOpts));

const { app: {port}} = config;

app.use(bodyParser.json());

app.use(bodyParser.urlencoded({extended: true}));

app.get('/', (req, res) => {
    console.log("API UP");
    res.send('API gateway');
});

app.use(router);

console.log('API gateway is running on port 5500');

app.listen(port);