-- Create the database (if not already created)
CREATE
DATABASE IF NOT EXISTS workpulse;
USE
workpulse;

-- Users table
CREATE TABLE users
(
    user_id         INT AUTO_INCREMENT PRIMARY KEY,
    username        VARCHAR(50) UNIQUE  NOT NULL,
    email           VARCHAR(100) UNIQUE NOT NULL,
    password_hash   VARCHAR(255)        NOT NULL,
    user_type       ENUM('buyer', 'seller', 'admin') NOT NULL,
    seller_level    ENUM('new', 'level1', 'level2', 'top_rated') DEFAULT 'new',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    profile_picture VARCHAR(255),
    description     TEXT
);

-- Gigs table
CREATE TABLE gigs
(
    gig_id        INT AUTO_INCREMENT PRIMARY KEY,
    seller_id     INT          NOT NULL,
    title         VARCHAR(100) NOT NULL,
    description   TEXT         NOT NULL,
    delivery_time INT          NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (seller_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- Gig prices table
CREATE TABLE gig_prices
(
    price_id    INT AUTO_INCREMENT PRIMARY KEY,
    gig_id      INT            NOT NULL,
    tier_name   ENUM('basic', 'standard', 'premium') NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    description TEXT,
    FOREIGN KEY (gig_id) REFERENCES gigs (gig_id) ON DELETE CASCADE
);

-- Gig categories table
CREATE TABLE gig_categories
(
    category_id        INT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(50) NOT NULL,
    parent_category_id INT,
    FOREIGN KEY (parent_category_id) REFERENCES gig_categories (category_id) ON DELETE SET NULL
);

-- Tags table
CREATE TABLE tags
(
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(50) UNIQUE NOT NULL
);

-- Gig tags junction table
CREATE TABLE gig_tags
(
    gig_id INT,
    tag_id INT,
    PRIMARY KEY (gig_id, tag_id),
    FOREIGN KEY (gig_id) REFERENCES gigs (gig_id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id) ON DELETE CASCADE
);

-- Orders table
CREATE TABLE orders
(
    order_id     INT AUTO_INCREMENT PRIMARY KEY,
    gig_id       INT NOT NULL,
    buyer_id     INT NOT NULL,
    seller_id    INT NOT NULL,
    price_id     INT NOT NULL,
    status       ENUM('pending', 'in_progress', 'completed', 'cancelled') NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP,
    FOREIGN KEY (gig_id) REFERENCES gigs (gig_id) ON DELETE RESTRICT,
    FOREIGN KEY (buyer_id) REFERENCES users (user_id) ON DELETE RESTRICT,
    FOREIGN KEY (seller_id) REFERENCES users (user_id) ON DELETE RESTRICT,
    FOREIGN KEY (price_id) REFERENCES gig_prices (price_id) ON DELETE RESTRICT
);

-- Reviews table
CREATE TABLE reviews
(
    review_id   INT AUTO_INCREMENT PRIMARY KEY,
    order_id    INT NOT NULL,
    reviewer_id INT NOT NULL,
    rating      INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment     TEXT,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
    FOREIGN KEY (reviewer_id) REFERENCES users (user_id) ON DELETE RESTRICT
);

-- Messages table
CREATE TABLE messages
(
    message_id  INT AUTO_INCREMENT PRIMARY KEY,
    sender_id   INT  NOT NULL,
    receiver_id INT  NOT NULL,
    content     TEXT NOT NULL,
    sent_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read     BOOLEAN   DEFAULT FALSE,
    FOREIGN KEY (sender_id) REFERENCES users (user_id) ON DELETE RESTRICT,
    FOREIGN KEY (receiver_id) REFERENCES users (user_id) ON DELETE RESTRICT
);

-- Notifications table
CREATE TABLE notifications
(
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id         INT         NOT NULL,
    type            VARCHAR(50) NOT NULL,
    content         TEXT        NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read         BOOLEAN   DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- Buyer requests table
CREATE TABLE buyer_requests
(
    request_id  INT AUTO_INCREMENT PRIMARY KEY,
    buyer_id    INT          NOT NULL,
    title       VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL,
    budget      DECIMAL(10, 2),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at  TIMESTAMP    NOT NULL,
    FOREIGN KEY (buyer_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- Files table
CREATE TABLE files
(
    file_id     INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT,
    gig_id      INT,
    file_type   VARCHAR(50)  NOT NULL,
    file_path   VARCHAR(255) NOT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE SET NULL,
    FOREIGN KEY (gig_id) REFERENCES gigs (gig_id) ON DELETE SET NULL
);