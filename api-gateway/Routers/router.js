var express = require('express');
var router = express.Router();
var login_audit_router = require('./login_audit');
var DataRetrival_router = require('./DataRetrival');
var MerraRetrival_router = require('./MerraRetrival');



router.use((req, res, next) => {
    console.log("Called: ", req.path);
    next();
});

router.use(login_audit_router);

router.use(DataRetrival_router);

router.use(MerraRetrival_router);

module.exports = router;