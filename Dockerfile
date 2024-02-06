# FROM amazoncorretto:17
# VOLUME /tmp
# COPY build/libs/issueMoa-learning-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM amazoncorretto:17
VOLUME /issuemoa
COPY build/libs/issueMoa-learning-0.0.1-SNAPSHOT.jar app.jar

# 환경 변수를 통해 로그 디렉토리 및 파일명 동적으로 설정
#ENV LOG_DIRECTORY=/issuemoa/logs
#ENV LOG_FILE=learning

ENTRYPOINT ["java", "-Dlogging.file=/issuemoa/logs/learning-$(date + '%Y-%m-%d').log", "-jar" ,"/app.jar"]
