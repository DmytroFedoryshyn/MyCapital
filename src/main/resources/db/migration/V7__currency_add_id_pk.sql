CREATE EXTENSION IF NOT EXISTS "pgcrypto";

ALTER TABLE currency
    ADD COLUMN id UUID;

UPDATE currency
SET id = gen_random_uuid();

ALTER TABLE currency
    ALTER COLUMN id SET NOT NULL,
    ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE currency
    DROP CONSTRAINT currency_pkey;

ALTER TABLE currency
    ADD PRIMARY KEY (id);





