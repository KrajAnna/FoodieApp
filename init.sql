CREATE DATABASE IF NOT EXISTS foodieApp
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE foodieApp;

CREATE TABLE IF NOT EXISTS roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Roles needed for the application to work
INSERT IGNORE INTO roles (name) VALUES ('USER'), ('ADMIN');
