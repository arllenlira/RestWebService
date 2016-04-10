# RestWebService
An example of restful + webservice  using jersey

DistanceCity 
-REST WebService developed to measure the distance between two previously registered cities in a database.


Requirements
-Tomcat 7 Java Application Server.
-Mysql 5.5 database server.
-Java 7


How to setup?

1)Configure the database. 
Run the DistanceCity_DUMP_DATABASE.sql on an instance of MySql5 server installed.
(Need admin privileges to create database and tables)

-Default parameters of database connection on webservice.
Default parameters*
jdbc.user=root
jdbc.password=root
jdbc.host=localhost
jdbc.port=3306
jdbc.database=hub

*The app expects these parameters on connection by default, after run the dump of database creation. 
If you need change to your custom parameters, modify the file:
DistanceCity.war\WEB-INF\classes\database.properties  
You can extract and compress again a .war file using 7z (Seven Zip)


2)Deploy the DistanceCity.war. Use the Manager App of Tomcat 7 server to deploy the file into server.
After the deploy, restart the server.


3)Testing the webservice. Examples:

JSON response of distance between MANAUS and RIO DE JANEIRO. 
http://localhost:8080/DistanceCity/city/calculateJSON?city1=MANAUS&city2=RIO%20DE%20JANEIRO
{"city1":"MANAUS","city2":"RIO DE JANEIRO","distanceKM":"2850.954576921833","distanceMiles":"1771.5831740992269"}

XML response of distance between MANAUS and RIO DE JANEIRO.
http://localhost:8080/DistanceCity/city/calculateXML?city1=MANAUS&city2=RIO%20DE%20JANEIRO
<distanceVO>
<city1>MANAUS</city1>
<city2>RIO DE JANEIRO</city2>
<distanceKM>2850.954576921833</distanceKM>
<distanceMiles>1771.5831740992269</distanceMiles>
</distanceVO>

MILES response of distance between MANAUS and RIO DE JANEIRO.
http://localhost:8080/DistanceCity/city/distanceMiles?city1=MANAUS&city2=RIO%20DE%20JANEIRO&unit=MI
1771.5831740992269

KM response of distance between MANAUS and RIO DE JANEIRO.
http://localhost:8080/DistanceCity/city/distanceMiles?city1=MANAUS&city2=RIO%20DE%20JANEIRO&unit=KM
2850.954576921833

A sample to test only the webservice without database.
http://localhost:8080/DistanceCity/city/sample
{"id":"1","latitude:":1.000","longitude":"1.000","name":"Manaus"}

Cities availables*
MANAUS
RIO DE JANEIRO
BRASÍLIA
SÃO PAULO
PORTO ALEGRE 

*Remember of word accents to test another cities on webservice. (latin1 charset)


4)Justifications
-To implement the webservice was used the API Jersey (https://jersey.java.net/). Simple, small and portable.
-To calculate the distance between two points was used the Haversine formula.

Anothers approachs were coonsiderated but discarded
a) Google Maps Directions.
Need an access to internet to work.
As the cities were considerated like two points, the area of cities are inside of uncertainity and the precision of goole maps api would not be necessary.
Because this Haversine formula was used.



5)Problems or questions on configuration, contact:
+55 15 98107 88881 
arllenlira@gmail.com
Arllen Lira
