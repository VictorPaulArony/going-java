DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS category CASCADE;

CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE post (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    category_id BIGINT REFERENCES category(id) ON DELETE SET NULL
);