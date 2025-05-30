# /bin/bash

curl --location 'http://localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=80A731C14F6A34C8B439582A55F767FA' \
--data '{
  "name": "postgres-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.hostname": "postgres",
    "database.port": "5432",
    "database.user": "root",
    "database.password": "root",
    "database.dbname": "ecom_product",
    "database.server.name": "product_database",
    "table.include.list": "public.*",
    "slot.name": "products_slot",
    "publication.name": "publication",
    "plugin.name": "pgoutput",
    "topic.prefix": "toanhao",
    "snapshot.mode": "initial",
    "include.schema.changes": "false",
    "schema.history.internal.kafka.topic": "schemahistory.products",
    "schema.history.internal.kafka.bootstrap.servers": "kafka:29092"
  }
}
'