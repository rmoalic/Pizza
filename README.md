Pizza !
========

Commande docker
---------------
docker run --rm --name helloworldservice-tomcat -v $(pwd)/target/ws.war:/usr/local/tomcat/webapps/ws.war -it -p 8080:8080 tomcat:9.0.12-jre11-slim

Url des l'api
-------------

http://localhost:8080/ws/orderservice?wsdl
http://localhost:8080/ws/userservice?wsdl
http://localhost:8080/ws/payementservice?wsdl