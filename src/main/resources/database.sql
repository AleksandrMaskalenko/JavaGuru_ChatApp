# DROP TABLE IF EXISTS friend_list;
# DROP TABLE IF EXISTS conv_message;
# DROP TABLE IF EXISTS participants;
# DROP TABLE IF EXISTS conversation;
# DROP TABLE IF EXISTS users;
# DROP TABLE IF EXISTS role;
#
# CREATE TABLE role (
#   role_id INT                 NOT NULL  AUTO_INCREMENT PRIMARY KEY,
#   role_name VARCHAR(255)      NOT NULL
# )
#   ENGINE = InnoDB;
#
# CREATE TABLE users (
#   user_id INT                 NOT NULL  AUTO_INCREMENT PRIMARY KEY,
#   username VARCHAR(255)       NOT NULL,
#   password VARCHAR(255)       NOT NULL,
#   phone VARCHAR(255)          ,
#   email VARCHAR(255)          NOT NULL,
#   role_id INT                 NOT NULL,
#
#   FOREIGN KEY (role_id)       REFERENCES role(role_id)
# )
#   ENGINE = InnoDB;
#
# CREATE TABLE friend_list (
#   id INT                      NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   main_user_id INT            NOT NULL,
#   user_id INT                 NOT NULL,
#
#   FOREIGN KEY (user_id)       REFERENCES users(user_id)
# )
#   ENGINE = InnoDB;
#
#
# CREATE TABLE conversation (
#   conv_id INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   title VARCHAR(255)          NOT NULL,
#   creation_date VARCHAR(255)  NOT NULL,
#   user_id INT                 NOT NULL,
#   conv_type VARCHAR(255)      NOT NULL,
#
#   FOREIGN KEY (user_id)       REFERENCES users(user_id)
# )
#   ENGINE = InnoDB;
#
# CREATE TABLE participants (
#   part_id INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   conv_id INT                 NOT NULL,
#   user_id INT                 NOT NULL,
#
#   FOREIGN KEY (conv_id)       REFERENCES conversation(conv_id),
#   FOREIGN KEY (user_id)       REFERENCES users(user_id)
# )
#   ENGINE = InnoDB;
#
# CREATE TABLE conv_message (
#   message_id INT              NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   conv_id INT                 NOT NULL,
#   user_id INT                 NOT NULL,
#   text VARCHAR(255)           NOT NULL,
#   date VARCHAR(255)           NOT NULL,
#
#
#   FOREIGN KEY (conv_id)       REFERENCES conversation(conv_id),
#   FOREIGN KEY (user_id)       REFERENCES users(user_id)
# )
#   ENGINE = InnoDB;
#
#
# INSERT INTO role VALUES (1, 'ADMIN');
# INSERT INTO role VALUES (2, 'USER');
#
# INSERT INTO users VALUES (1, 'Alex', '00001', 100001, 'email@emai1.com', 1);
# INSERT INTO users VALUES (2, 'Arthur', '00002', 100002, 'email@emai2.com', 2);
# INSERT INTO users VALUES (3, 'Nitish', '00003', 100003, 'email@emai3.com', 1);
# INSERT INTO users VALUES (4, 'Max', '00004', 100004, 'email@emai4.com', 2);
# INSERT INTO users VALUES (5, 'Dmitrij', '00005', 100005, 'email@emai5.com', 2);
# INSERT INTO users VALUES (6, 'Andrej', '00006', 100006, 'email@emai6.com', 2);
#
# INSERT INTO friend_list VALUES (1, 1, 2);
# INSERT INTO friend_list VALUES (2, 1, 4);
# INSERT INTO friend_list VALUES (3, 1, 6);
# INSERT INTO friend_list VALUES (4, 1, 3);
# INSERT INTO friend_list VALUES (5, 3, 2);
# INSERT INTO friend_list VALUES (6, 3, 6);
# INSERT INTO friend_list VALUES (7, 2, 4);
#
# INSERT INTO conversation VALUES (1,'Weather', 1001, 1, 'group');
# INSERT INTO conversation VALUES (2,'Andrej', 1002, 1, 'pair');
# INSERT INTO conversation VALUES (3, 'Quadcopter', 1003, 2, 'group');
#
# INSERT INTO participants VALUES (1, 1, 1);
# INSERT INTO participants VALUES (2, 1, 2);
# INSERT INTO participants VALUES (3, 2, 6);
# INSERT INTO participants VALUES (4, 3, 6);
# INSERT INTO participants VALUES (5, 3, 5);
# INSERT INTO participants VALUES (6, 3, 4);
#
# INSERT INTO conv_message VALUES (1, 1, 1, 'Hi it is my text bla, bla, bla', 1201);
# INSERT INTO conv_message VALUES (2, 1, 2, 'It prepare is ye nothing blushes up brought.', 1202);
# INSERT INTO conv_message VALUES (3, 1, 1, 'Or as gravity pasture limited evening on.', 1203);
# INSERT INTO conv_message VALUES (4, 2, 1, 'Too him himself engaged husband pursuit musical. Man age but him determine consisted therefore.', 1204);
# INSERT INTO conv_message VALUES (5, 3, 4, 'Or as gravity pasture limited evening on.', 1203);
# INSERT INTO conv_message VALUES (6, 3, 4, 'Call park out she wife face mean.', 1203);
# INSERT INTO conv_message VALUES (7, 3, 5, 'Invitation excellence imprudence understood it continuing to.', 1203);
# INSERT INTO conv_message VALUES (8, 3, 6, 'County suffer twenty or marked no moment in he.', 1203);
