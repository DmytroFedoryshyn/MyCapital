CREATE TABLE currency_classifier (
    alpha_code VARCHAR(3) PRIMARY KEY,
    numeric_code INTEGER NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    flag_emoji VARCHAR(8)
);





