const httpStatus = require("http-status");
const ApiError = require("../utils/ApiError");
const catchAsync = require("../utils/catchAsync");
const { userService } = require("../services");


/**
 * Get user details
 *  - Use service layer to get User data
 * 
 *  - If query param, "q" equals "address", return only the address field of the user
 *  - Else,
 *  - Return the whole user object fetched from Mongo

 *  - If data exists for the provided "userId", return 200 status code and the object
 *  - If data doesn't exist, throw an error using `ApiError` class
 *    - Status code should be "404 NOT FOUND"
 *    - Error message, "User not found"
 *  - If the user whose token is provided and user whose data to be fetched don't match, throw `ApiError`
 *    - Status code should be "403 FORBIDDEN"
 *    - Error message, "User not found"
 *
 * 
 * Request url - <workspace-ip>:8082/v1/users/6010008e6c3477697e8eaba3
 * Response - 
 * {
 *     "walletMoney": 500,
 *     "address": "ADDRESS_NOT_SET",
 *     "_id": "6010008e6c3477697e8eaba3",
 *     "name": "crio-users",
 *     "email": "crio-user@gmail.com",
 *     "password": "criouser123",
 *     "createdAt": "2021-01-26T11:44:14.544Z",
 *     "updatedAt": "2021-01-26T11:44:14.544Z",
 *     "__v": 0
 * }
 * 
 * Request url - <workspace-ip>:8082/v1/users/6010008e6c3477697e8eaba3?q=address
 * Response - 
 * {
 *   "address": "ADDRESS_NOT_SET"
 * }
 * 
 *
 * Example response status codes:
 * HTTP 200 - If request successfully completes
 * HTTP 403 - If request data doesn't match that of authenticated user
 * HTTP 404 - If user entity not found in DB
 * 
 * @returns {User | {address: String}}
 *
 */


const getUser = catchAsync(async (req, res) => {
  
  try {

    console.log("IN getUserController");
    if (req.user._id != req.params.userId) {
      return res.status(403).json({ message: "User not found" });
    }

    let user;
    if (req.query.q == "address") {
      user = await userService.getUserAddressById(req.params.userId);
      if (!user) throw new ApiError(httpStatus.NOT_FOUND, "User not found")
      return res.status(200).send({ address: user.address });
    }
    user = await userService.getUserById(req.params.userId);
    console.log("Getting user");
    if (!user) throw new ApiError(httpStatus.NOT_FOUND, "User not found")
    else res.status(200).send(user);

  } catch (error) {
    const { statusCode, message } = error;
    if (!statusCode) throw new ApiError(httpStatus.INTERNAL_SERVER_ERROR);
    res.status(statusCode).send({ message });
  }
});


const setAddress = catchAsync(async (req, res) => {
  const user = await userService.getUserById(req.params.userId);

  if (!user) {
    throw new ApiError(httpStatus.NOT_FOUND, "User not found");
  }
  if (user.email != req.user.email) {
    throw new ApiError(
      httpStatus.FORBIDDEN,
      "User not authorized to access this resource"
    );
  }

  const address = await userService.setAddress(user, req.body.address);

  res.send({
    address: address,
  });
});

const getTemp = async (req,res) => {
  user =  await userService.getUserById(req.params.userId);
  console.log("Getting user " + req.params.userId);
  res.status(200).send(user);
}

const getTemp2 = async ()=>{
  // user = `{"_id":{"$oid":"600a695da6e5b6845906e726"},"walletMoney":500,"address":"ADDRESS_NOT_SET","name":"crio-user","email":"crio-user@gmail.com","password":"$2a$08$7vsI5PLZPth9q2/JOvxhv.U.VpYSfcBYuQ1IdcamE76IHKxjy2lgK","createdAt":{"$date":"2021-01-22T05:57:49.999Z"},"updatedAt":{"$date":"2021-01-22T05:57:49.999Z"},"__v":0}`;

   user = await userService.temp();
  console.log("User --> "+user);
}
getTemp2();

module.exports = {
  getUser,
  setAddress,
  getTemp
};
