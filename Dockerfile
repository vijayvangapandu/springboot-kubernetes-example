FROM gcr.io/google_appengine/jetty9
ADD target/ops-inventory-graph-1.0-SNAPSHOT.war /var/lib/jetty/webapps/
EXPOSE 8080
CMD java -jar "$JETTY_HOME/start.jar"
