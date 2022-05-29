const { Client } = require('pg')

const client = new Client(process.env.postgresql://sahana:hY8lCZ_mz4Gk8cW5gOLrpg@free-tier12.aws-ap-south-1.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full&options=--cluster%3Dshaped-ermine-619)

client.connect()
