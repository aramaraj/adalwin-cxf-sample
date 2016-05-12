# adalwin-cxf-sample
adalwin cxf sample with jetty 


Mongo path:

L-SNV5EDJDF8-M:Library aramar1$ cd /usr/local/opt/mongodb
Command to Run MONGO : ./mongod --config /usr/local/etc/mongod.conf 

Mongo Conf:

systemLog:
  destination: file
  path: /usr/local/var/log/mongodb/mongo.log
  logAppend: true
storage:
  dbPath: /usr/local/var/mongodb
net:
  bindIp: 127.0.0.1
