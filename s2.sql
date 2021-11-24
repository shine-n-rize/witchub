CREATE TABLE IF NOT EXISTS User (
    user_id int NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL UNIQUE,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) DEFAULT NULL,
    email varchar(255) NOT NULL UNIQUE,
    phone_no varchar(13) DEFAULT NULL,
    status boolean DEFAULT false NOT NULL,
    role enum ('ADMIN','STAFF', 'BUYER', 'SELLER') NOT NULL,
    password varchar(500) DEFAULT NULL,
    date_created date NOT NULL,
    house_no varchar(200) DEFAULT NULL,
    street varchar(100) DEFAULT NULL,
    city varchar(100) DEFAULT NULL,
    PRIMARY KEY (user_id)
    );

CREATE TABLE IF NOT EXISTS Verification_Token(
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    token varchar(1000) NOT NULL,
    created_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS Seller(
    seller_id int NOT NULL,
    wallet int DEFAULT NULL,
    demmand_rate float DEFAULT NULL,
    account_no varchar(255) UNIQUE,
    PRIMARY KEY (seller_id),
    FOREIGN KEY (seller_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
    );