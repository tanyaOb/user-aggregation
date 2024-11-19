CREATE DATABASE IF NOT EXISTS database2;

CREATE TABLE IF NOT EXISTS user_table
(
    ldap_login VARCHAR(50) PRIMARY KEY,
    name       VARCHAR(50),
    surname    VARCHAR(50)
);

INSERT INTO user_table (ldap_login, name, surname)
VALUES ('example-user-id-2', 'Testuser', 'Testov')
ON CONFLICT DO NOTHING;