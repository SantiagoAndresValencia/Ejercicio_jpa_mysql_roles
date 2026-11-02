INSERT IGNORE INTO roles (role_id, name) VALUES
(1, 'USER'),
(2, 'CREATOR'),
(3, 'EDITOR'),
(4, 'ADMIN');

INSERT IGNORE INTO users (user_id, username, password, enabled) VALUES
(1, 'usuario', '$2a$10$xcXlWfy3YBucM3Vahz7fOO9hCOd/yVgXne7H7weoSmTrHDkeurH12', 1),
(2, 'creador', '$2a$10$xcXlWfy3YBucM3Vahz7fOO9hCOd/yVgXne7H7weoSmTrHDkeurH12', 1),
(3, 'editor', '$2a$10$xcXlWfy3YBucM3Vahz7fOO9hCOd/yVgXne7H7weoSmTrHDkeurH12', 1),
(4, 'admin', '$2a$10$xcXlWfy3YBucM3Vahz7fOO9hCOd/yVgXne7H7weoSmTrHDkeurH12', 1);

INSERT IGNORE INTO users_roles (user_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);
