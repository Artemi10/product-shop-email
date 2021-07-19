FROM devanmejia/jdk-11-smpt
EXPOSE 8082
ADD target/product-shop-email-0.0.1-SNAPSHOT.jar product-shop-email-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "product-shop-email-0.0.1-SNAPSHOT.jar"]
