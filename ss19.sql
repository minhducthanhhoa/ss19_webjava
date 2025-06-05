create database ss19_db;
use ss19_db;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(100),
    phoneNumber VARCHAR(20),
    is_active BOOLEAN
);

INSERT INTO users (username, password, email, phoneNumber, is_active) VALUES
                ('admin1', 'pass1', 'admin1@gmail.com', '0123456789', true),
                ('admin2', 'pass2', 'admin2@gmail.com', '0123456788', false),
                ('user1', 'pass3', 'user1@gmail.com', '0123456787', true),
                ('user2', 'pass4', 'user2@gmail.com', '0123456786', true),
                ('user3', 'pass5', 'user3@gmail.com', '0123456785', false),
                ('user4', 'pass6', 'user4@gmail.com', '0123456784', true),
                ('user5', 'pass7', 'user5@gmail.com', '0123456783', true),
                ('user6', 'pass8', 'user6@gmail.com', '0123456782', false),
                ('user7', 'pass9', 'user7@gmail.com', '0123456781', true),
                ('user8', 'pass10', 'user8@gmail.com', '0123456780', true);

ALTER TABLE users MODIFY is_active BOOLEAN DEFAULT TRUE;

CREATE TABLE movie (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    release_year INT,
    genre VARCHAR(100),
    duration INT,
    language VARCHAR(50),
    poster VARCHAR(500),
    status BOOLEAN
);

CREATE TABLE theater (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    theater_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    number_screen_room INT NOT NULL,
    status BOOLEAN DEFAULT TRUE
);

