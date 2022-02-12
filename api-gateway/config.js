const { clear } = require("console");
const { Module } = require("module");

const config = {

	app: {

	host: "127.0.0.1",

	port: 5500

	},
	

	routeURLS: {

	login_audit: "http://127.0.0.1:8080/",

	DataRetrival: "http://127.0.0.1:5000/",
	
	}
};

module.exports = config;