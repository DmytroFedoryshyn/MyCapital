CREATE TABLE currency (
    code VARCHAR(3) PRIMARY KEY,
    symbol VARCHAR(5) NOT NULL,
    decimals INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    flag_emoji VARCHAR(8)
);





