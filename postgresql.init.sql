ALTER SYSTEM SET wal_level = logical;

ALTER ROLE root WITH REPLICATION;

SELECT pg_reload_conf();

SHOW hba_file;

CREATE PUBLICATION publication FOR ALL TABLES;

SELECT * FROM pg_create_logical_replication_slot('products_slot', 'pgoutput');

SHOW wal_level;
