CREATE TYPE task_status AS ENUM ('ACTIVE','COMPLETED');

ALTER TABLE task ADD COLUMN status task_status default 'ACTIVE';