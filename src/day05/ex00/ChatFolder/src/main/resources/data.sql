

-- Insert users
INSERT INTO users (name, login, password) VALUES
('Alice', 'alice1', 'pass123'),
('Bob', 'bob99', 'bob pass'),
('Charlie', 'charlie', '1234');

-- Insert chat rooms (with owner_id referencing users)
INSERT INTO chat_rooms (name, owner_id) VALUES
('General', 1),
('Gaming', 2),
('Tech Talk', 3);

-- Insert messages (with sender_id and room_id)
INSERT INTO messages (content, sender_id, room_id) VALUES
('Hello everyone!', 1, 1),
('Hey Alice!', 2, 1),
('Welcome to the tech chat.', 3, 3),
('Who is up for a game?', 2, 2),
('Lets discuss PostgresSQL.', 1, 3);
