
const axios = require('axios');

module.exports = (baseURL) => {
  console.log(baseURL);
  return axios.create({
    baseURL: baseURL,
  });
}