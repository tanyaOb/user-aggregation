CREATE DATABASE IF NOT EXISTS database1;

CREATE TABLE IF NOT EXISTS users
(
    user_id    SERIAL PRIMARY KEY,
    login      VARCHAR(50),
    first_name VARCHAR(50),
    last_name  VARCHAR(50)
);

INSERT INTO users (user_id, login, first_name, last_name)
VALUES (1, 'user-1', 'User', 'Userenko')
ON CONFLICT DO NOTHING;