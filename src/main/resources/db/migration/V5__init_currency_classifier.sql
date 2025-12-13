CREATE TABLE currency_classifier (
    alpha_code VARCHAR(3) PRIMARY KEY,
    numeric_code VARCHAR(3) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    symbol VARCHAR(5),
    flag_emoji VARCHAR(8)
);







