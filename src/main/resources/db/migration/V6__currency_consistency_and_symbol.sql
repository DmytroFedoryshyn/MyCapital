-- Rename code column to alpha_code to align naming with classifier
ALTER TABLE currency
    RENAME COLUMN code TO alpha_code;

-- Add symbol to classifier to mirror currency metadata
ALTER TABLE currency_classifier
    ADD COLUMN symbol VARCHAR(5) NOT NULL DEFAULT '?';

-- Optional: drop default if you want to enforce explicit values only
ALTER TABLE currency_classifier
    ALTER COLUMN symbol DROP DEFAULT;





