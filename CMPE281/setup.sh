# Setup file to upload data to MongoDB 
mongosh qkart --eval "db.dropDatabase()" 
mongoimport -d qkart -c users --file data/export_qkart_users.json
