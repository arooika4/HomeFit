FROM openjdk:17

WORKDIR /app

COPY . .

RUN javac src/main/Main.java

CMD ["java", "src.main.Main"]
