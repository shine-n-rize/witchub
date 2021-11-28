-- ### Table Template ###

-- CREATE TABLE IF NOT EXISTS (
-- 	_id int NOT NULL AUTO_INCREMENT,
--
--     PRIMARY KEY (_id),
--     FOREIGN KEY (_id) REFERENCES (_id) ON DELETE CASCADE ON UPDATE CASCADE
-- );


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
    seller_id int NOT NULL AUTO_INCREMENT,
    wallet int DEFAULT NULL,
    demmand_rate float DEFAULT NULL,
    account_no varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (seller_id),
    FOREIGN KEY (seller_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Staff(
    staff_id int NOT NULL AUTO_INCREMENT,
    gender enum ('Male', 'Female', 'Not Specified') DEFAULT 'Not Specified' NOT NULL,
    dob date NOT NULL,
    join_date date DEFAULT NULL,
    end_date date DEFAULT NULL,
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Product(
    product_id int NOT NULL AUTO_INCREMENT,
    seller_id int NOT NULL,
    title varchar(500) NOT NULL,
    description longtext DEFAULT NULL,
    price int NOT NULL,
    stock int NOT NULL,
    image varchar(500) NOT NULL,
    rating float DEFAULT NULL,
    is_requested boolean DEFAULT false NOT NULL,
    date_added date NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (seller_id) REFERENCES Seller(seller_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Image(
    image_id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    link_to_image varchar(2000) NOT NULL,
    PRIMARY KEY (image_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Category(
    category_id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    title varchar(255) NOT NULL,
    PRIMARY KEY (category_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Cart(
    cart_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    product_id int NOT NULL,
    quantity int DEFAULT NULL,
    PRIMARY KEY (cart_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Wishlist(
    wishlist_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    product_id int NOT NULL,
    PRIMARY KEY (wishlist_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Review(
    review_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    product_id int NOT NULL,
    rating int NOT NULL,
    comment longtext DEFAULT NULL,
    PRIMARY KEY (review_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Request(
    request_id int NOT NULL AUTO_INCREMENT,
    response longtext DEFAULT NULL,
    PRIMARY KEY (request_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Payment(
    payment_id int NOT NULL AUTO_INCREMENT,
    is_success boolean DEFAULT false NOT NULL,
    account_no varchar(255) NOT NULL,
    payment_to varchar(255) NOT NULL,
    amount int NOT NULL,
    method enum ('Online', 'Cash On Delivery') NOT NULL,
    date_placed date NOT NULL,
    time_placed time NOT NULL,
    PRIMARY KEY (payment_id)
);

CREATE TABLE IF NOT EXISTS OOrder(
    order_id int NOT NULL AUTO_INCREMENT,
    payment_id int NOT NULL,
    date_placed date NOT NULL,
    status enum ('Dispatched', 'Arriving', 'Delivered', 'Cancelled') DEFAULT 'Dispatched' NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (payment_id) REFERENCES Payment(payment_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS User_Feedback(
    user_fb_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    fb_date date NOT NULL,
    fb_time time NOT NULL,
    subj varchar(255) NOT NULL,
    message longtext DEFAULT NULL,
    response longtext DEFAULT NULL,
    PRIMARY KEY (user_fb_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Seller_Feedback(
    seller_fb_id int NOT NULL AUTO_INCREMENT,
    fb_date date NOT NULL,
    fb_time time NOT NULL,
    subj varchar(255) NOT NULL,
    message longtext DEFAULT NULL,
    response longtext DEFAULT NULL,
    PRIMARY KEY (seller_fb_id),
    FOREIGN KEY (seller_id) REFERENCES Seller(seller_id) ON DELETE CASCADE ON UPDATE CASCADE
);
