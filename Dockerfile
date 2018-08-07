FROM java:8
ADD target/backend.jar /opt/lemons-backend/backend.jar


#command
CMD java -Xms500m -Xmx500m -Dspring.profiles.active=$PROFILE -jar /opt/lemons-backend/backend.jar