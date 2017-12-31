## MongoDB File Server
A file server system based on MongoDB, which is committed to the storage of small files, such as pictures in the blog, ordinary documents and so on.
<br />
the techniques we used here including: 
* MongoDB 3.6.1
* Spring Boot 1.5.9
* Thymeleaf 3.0.3
* Thymeleaf Layout Dialect 2.2.0
* Embedded MongoDB 2.0.0
* Gradle 3.5

### APIs
* GET /files/{pageIndex}/{pageSize} : Paging query file list.
* GET /files/{id} : Download file.
* GET /view/{id} : View file online.
* POST /upload : Upload file.
* DELETE /{id} : Delete file.

### How to
#### 1. configure with embed database
keep the following dependency in the "build.gradle" file.
```bash
compile('de.flapdoodle.embed:de.flapdoodle.embed.mongo')
```
and the remove the configures in the "application.properties" file.
```bash
// spring.data.mongodb.uri=mongodb://localhost:27017/test
```
#### 2. configure with independent database
remove the following dependency in the "build.gradle" file.
```bash
// compile('de.flapdoodle.embed:de.flapdoodle.embed.mongo')
```
and the keep the configures in the "application.properties" file.
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/test
```
install the mongodb locally, and start the db server before the project.
```bash
C:\>cd Program Files\MongoDB\Server\3.6\bin\
C:\Program Files\MongoDB\Server\3.6\bin>mongod --logpath d:\mongoDB_Data\log\mongod.log --dbpath d:\mongoDB_Data\db --storageEngine=mmapv1
```
use "MongoDB Compass" to monitor the database detail, after the establish the db connection. or simply use another terminal to check the status.
```bash
C:\Program Files\MongoDB\Server\3.6\bin>mongo
MongoDB shell version v3.6.1
connecting to: mongodb://127.0.0.1:27017
MongoDB server version: 3.6.1
Server has startup warnings:
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten]
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] ** WARNING: Access control is not enabled for the database.
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          Read and write access to data and configuration is unrestricted.
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten]
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] ** WARNING: This server is bound to localhost.
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          Remote systems will be unable to connect to this server.
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          Start the server with --bind_ip <address> to specify which IP
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          addresses it should serve responses from, or with --bind_ip_all to
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          bind to all interfaces. If this behavior is desired, start the
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten] **          server with --bind_ip 127.0.0.1 to disable this warning.
2017-12-31T14:24:05.377-0800 I CONTROL  [initandlisten]
> show dbs
admin   0.078GB
config  0.078GB
local   0.078GB
test    0.078GB
> use test
switched to db test
> show collections
file
system.indexes
> db.file.find().pretty()
{
        "_id" : ObjectId("5a4962567123503b80e0c3ed"),
        "_class" : "com.jw.mongodbfileserver.domain.File",
        "name" : "favicon.png",
        "contentType" : "image/png",
        "size" : NumberLong(24461),
        "uploadDate" : ISODate("2017-12-31T22:19:02.523Z"),
        "md5" : "4e33218bc6377881f8ca4e46b0d866fc",
        "content" : BinData(0,"iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAYAAABccqhmAAAACXBIWXMAAAsTAAALEwEAmpw...YII=")
}
```
#### 3. run the project 
use gradle
```bash
gradlew bootRun
```
or just run the "MongodbFileServerApplication.java" as java application in IDE. <br />
then visit the application at[http://localhost:8081](http://localhost:8081).

 #### 4. build the project executable jar file
 use gradle
 ```bash
 gradlew build
 ```
