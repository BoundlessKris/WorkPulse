USE workpulse;

-- Users table indexes
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_user_type ON users(user_type);
CREATE INDEX idx_users_seller_level ON users(seller_level);

-- Gigs table indexes
CREATE INDEX idx_gigs_seller_id ON gigs(seller_id);
CREATE INDEX idx_gigs_created_at ON gigs(created_at);

-- Gig prices table indexes
CREATE INDEX idx_gig_prices_gig_id ON gig_prices(gig_id);
CREATE INDEX idx_gig_prices_tier_name ON gig_prices(tier_name);

-- Gig categories table indexes
CREATE INDEX idx_gig_categories_parent_id ON gig_categories(parent_category_id);

-- Tags table index
CREATE INDEX idx_tags_name ON tags(name);

-- Gig tags junction table indexes
CREATE INDEX idx_gig_tags_gig_id ON gig_tags(gig_id);
CREATE INDEX idx_gig_tags_tag_id ON gig_tags(tag_id);

-- Orders table indexes
CREATE INDEX idx_orders_buyer_id ON orders(buyer_id);
CREATE INDEX idx_orders_seller_id ON orders(seller_id);
CREATE INDEX idx_orders_status ON orders(status);
CREATE INDEX idx_orders_created_at ON orders(created_at);

-- Reviews table indexes
CREATE INDEX idx_reviews_order_id ON reviews(order_id);
CREATE INDEX idx_reviews_reviewer_id ON reviews(reviewer_id);
CREATE INDEX idx_reviews_rating ON reviews(rating);

-- Messages table indexes
CREATE INDEX idx_messages_sender_id ON messages(sender_id);
CREATE INDEX idx_messages_receiver_id ON messages(receiver_id);
CREATE INDEX idx_messages_sent_at ON messages(sent_at);

-- Notifications table indexes
CREATE INDEX idx_notifications_user_id ON notifications(user_id);
CREATE INDEX idx_notifications_type ON notifications(type);
CREATE INDEX idx_notifications_created_at ON notifications(created_at);

-- Buyer requests table indexes
CREATE INDEX idx_buyer_requests_buyer_id ON buyer_requests(buyer_id);
CREATE INDEX idx_buyer_requests_created_at ON buyer_requests(created_at);
CREATE INDEX idx_buyer_requests_expires_at ON buyer_requests(expires_at);

-- Files table indexes
CREATE INDEX idx_files_user_id ON files(user_id);
CREATE INDEX idx_files_gig_id ON files(gig_id);
CREATE INDEX idx_files_file_type ON files(file_type);


-- Indexes for optimization
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_gigs_seller_id ON gigs(seller_id);
CREATE INDEX idx_gig_prices_gig_id ON gig_prices(gig_id);
CREATE INDEX idx_orders_buyer_id ON orders(buyer_id);
CREATE INDEX idx_orders_seller_id ON orders(seller_id);
CREATE INDEX idx_reviews_order_id ON reviews(order_id);
CREATE INDEX idx_messages_sender_id ON messages(sender_id);
CREATE INDEX idx_messages_receiver_id ON messages(receiver_id);
CREATE INDEX idx_notifications_user_id ON notifications(user_id);
CREATE INDEX idx_buyer_requests_buyer_id ON buyer_requests(buyer_id);
CREATE INDEX idx_files_user_id ON files(user_id);
CREATE INDEX idx_files_gig_id ON files(gig_id);


CREATE INDEX idx_total_amount ON orders (total_amount);
