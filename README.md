Sample-User-Management
======================

Before run: 
      #export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m"

1. Build project: mvn clean install

2. Start integration tests: mvn -Pintegration-tests clean install

3. Start web-app: 
      #cd ./app-web
      #mvn jetty:run
      #open in browser: localhost:8080
