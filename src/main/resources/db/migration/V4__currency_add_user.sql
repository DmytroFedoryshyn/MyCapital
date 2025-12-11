ALTER TABLE currency
    ADD COLUMN user_id UUID,
    ADD CONSTRAINT fk_currency_user FOREIGN KEY (user_id) REFERENCES users (id);





