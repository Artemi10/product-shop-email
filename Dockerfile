FROM devanmejia/jdk-11-smpt
EXPOSE 8082
ARG JAR_FILE
RUN mkdir -p /apps
RUN  cp -a ./target/product-shop-email-0.0.1-SNAPSHOT.jar /apps/app.jar
COPY ./entrypoint.sh /apps/entrypoint.sh
RUN chmod +x /apps/entrypoint.sh
CMD ["/apps/entrypoint.sh"]
