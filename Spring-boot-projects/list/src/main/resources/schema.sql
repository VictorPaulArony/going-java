-- Drop table if exists to start fresh (optional)
DROP TABLE IF EXISTS todo_item;

-- Create the todo_item table
CREATE TABLE todo_item (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Optional: Insert sample data
INSERT INTO todo_item (title, description, completed) VALUES
('Buy groceries', 'Milk, Eggs, Bread', false),
('Finish report', 'Submit before Friday', true),
('Call mom', NULL, false);