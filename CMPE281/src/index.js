const mongoose = require("mongoose");
const app = require("./app");
const config = require("./config/config");
const port = parseInt(config.port, 10);

let server;


mongoose.connect(config.mongoose.url, config.mongoose.options).then(() => console.log(" Connected to mongoDB")).catch((e) => console.log("MongoDb Connection Failed"));


app.listen(port, () => {
    console.log(`Server is listening on port ${port}`);
});


