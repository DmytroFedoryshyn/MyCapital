CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE currency (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    alpha_code VARCHAR(3) NOT NULL,
    symbol VARCHAR(5) NOT NULL,
    decimals INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    flag_emoji VARCHAR(8),
    user_id UUID NOT NULL REFERENCES users (id)
);







