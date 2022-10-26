const express = require("express");
const validate = require("../../middlewares/validate");
const auth = require("../../middlewares/auth");
const userValidation = require("../../validations/user.validation");
const userController = require("../../controllers/user.controller");
const userService = require("../../services/user.service")

const router = express.Router();


router.get('/u/:userId',userController.getTemp);

router.get('/:userId', auth, validate(userValidation.getUser), userController.getUser);
router.put(
  "/:userId",
  auth,
  validate(userValidation.setAddress),
  userController.setAddress
);





module.exports = router;
