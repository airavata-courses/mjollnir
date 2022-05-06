const { clear } = require("console");
const { Module } = require("module");

const config = {

	app: {

	host: "127.0.0.1",

	port: 5500

	},
	

	routeURLS: {

	login_audit: "http://0.0.0.0:8080/",

	DataRetrival: "http://0.0.0.0:5000/",

	MerraRetrival :"http://0.0.0.0:7500/",
	
	}
};

module.exports = config;