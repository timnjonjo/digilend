FROM openjdk:17-jdk-alpine
LABEL maintainer="Timothy Njonjo Mwaura"
RUN apk add --no-cache bash
ENV TZ=Africa/Nairobi
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && apk --update add fontconfig ttf-dejavu
EXPOSE 8080
ADD target/*.jar digilend-app.jar
CMD /bin/sh -c 'touch /digilend-app.jar'
ENTRYPOINT ["java","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/digilend-app.jar"]