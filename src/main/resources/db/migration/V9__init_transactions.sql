CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Categories for income/expense operations
CREATE TABLE IF NOT EXISTS categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    operation_type VARCHAR(32) NOT NULL,
    user_id UUID REFERENCES users (id),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Projects to group transactions
CREATE TABLE IF NOT EXISTS projects (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users (id),
    project_name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Base transactions table with discriminator column "type"
CREATE TABLE IF NOT EXISTS transactions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    type VARCHAR(32) NOT NULL,
    user_id UUID NOT NULL REFERENCES users (id),
    create_at TIMESTAMP NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    description TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Cash transaction subtype with discriminator column "operation_type"
CREATE TABLE IF NOT EXISTS cash_transactions (
    transaction_id UUID PRIMARY KEY REFERENCES transactions (id),
    operation_type VARCHAR(32) NOT NULL,
    wallet_id UUID NOT NULL REFERENCES wallet (id)
);

-- Income / expense specializations for cash transactions
CREATE TABLE IF NOT EXISTS income_transactions (
    cash_transaction_id UUID PRIMARY KEY REFERENCES cash_transactions (transaction_id)
);

CREATE TABLE IF NOT EXISTS expense_transactions (
    cash_transaction_id UUID PRIMARY KEY REFERENCES cash_transactions (transaction_id)
);

-- Lines for income transactions
CREATE TABLE IF NOT EXISTS income_lines (
    id BIGSERIAL PRIMARY KEY,
    income_transaction_id UUID NOT NULL REFERENCES income_transactions (cash_transaction_id) ON DELETE CASCADE,
    category_id UUID REFERENCES categories (id),
    project_id UUID REFERENCES projects (id),
    amount NUMERIC(19, 2) NOT NULL
);

-- Lines for expense transactions
CREATE TABLE IF NOT EXISTS expense_lines (
    id BIGSERIAL PRIMARY KEY,
    expense_transaction_id UUID NOT NULL REFERENCES expense_transactions (cash_transaction_id) ON DELETE CASCADE,
    category_id UUID REFERENCES categories (id),
    project_id UUID REFERENCES projects (id),
    amount NUMERIC(19, 2) NOT NULL
);




