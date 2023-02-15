FROM openjdk:17-jdk-oraclelinux8

EXPOSE 8080

ADD /target/isGoodBackEndProducts.jar isGoodBackEndProducts.jar

ENTRYPOINT ["java","-jar", "isGoodBackEndProducts.jar"]
