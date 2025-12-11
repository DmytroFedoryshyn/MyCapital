-- Add numeric_code to currency without uniqueness
ALTER TABLE currency
    ADD COLUMN numeric_code VARCHAR(3);

-- If data already exists, set a temporary placeholder to satisfy NOT NULL
UPDATE currency
SET numeric_code = COALESCE(numeric_code, '000');

ALTER TABLE currency
    ALTER COLUMN numeric_code SET NOT NULL;





