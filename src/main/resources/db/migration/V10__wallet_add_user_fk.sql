-- Add foreign key constraint for wallet.user_id after users table exists
ALTER TABLE wallet
    ADD CONSTRAINT fk_wallet_user FOREIGN KEY (user_id) REFERENCES users (id);

