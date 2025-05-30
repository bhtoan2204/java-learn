MVN=./mvnw
JAR_FILE=target/java-projects-0.0.1-SNAPSHOT.jar

build:
	$(MVN) clean package -DskipTests

run: build
	java -jar $(JAR_FILE)

test:
	$(MVN) test

clean:
	$(MVN) clean

rebuild: clean build

up:
	docker compose up -d --build

down:
	docker compose down

protos:
	protoc \
  --proto_path=./proto \
  --java_out=./src/main/java \
  --grpc-java_out=./src/main/java \
  ./proto/product/product_service.proto


dev:
	$(MVN) spring-boot:run