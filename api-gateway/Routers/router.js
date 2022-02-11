var express = require('express');
var router = express.Router();
var login_audit_router = require('./login_audit');
var DataRetrival_router = require('./DataRetrival');
// var cloudRouter = require('./cloudService');


router.use((req, res, next) => {
    console.log("Called: ", req.path);
    next();
});

router.use(login_audit_router);
// router.use(imageRouter);
router.use(DataRetrival_router);

module.exports = router;