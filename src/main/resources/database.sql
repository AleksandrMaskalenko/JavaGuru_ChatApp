# -- noinspection SqlNoDataSourceInspectionForFile
#
# -- Table: roles
# CREATE TABLE role (
#   role_id INT                 NOT NULL  AUTO_INCREMENT PRIMARY KEY,
#   roleName VARCHAR(255)      NOT NULL
# )
#   ENGINE = InnoDB;
#
# CREATE TABLE friendList (
#   user_id INT           NOT NULL,
#   friends_id INT        NOT NULL
#
# )
#   ENGINE = InnoDB;
#
# -- Table : users
# CREATE TABLE user (
#   user_id INT                 NOT NULL  AUTO_INCREMENT PRIMARY KEY,
#   userName VARCHAR(255)      NOT NULL,
#   password VARCHAR(255)       NOT NULL,
#   phone INT                   NOT NULL,
#   email VARCHAR(255)          NOT NULL,
#   role_id INT                 NOT NULL,
#
#   FOREIGN KEY (role_id)       REFERENCES role(role_id)
#   )
#   ENGINE = InnoDB;
# # #
# # # CREATE TABLE conversation (
# # #   conv_id INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
# # #   title VARCHAR(255)          NOT NULL,
# # #   creationDate INT            NOT NULL,
# # #   admin_id INT                NOT NULL,
# # #
# # #   FOREIGN KEY (admin_id) REFERENCES users(user_id)
# # # )
# # #   ENGINE = InnoDB;
# # #
# # # CREATE TABLE convMessage (
# # #   message_id INT              NOT NULL AUTO_INCREMENT PRIMARY KEY,
# # #   conv_id INT                 NOT NULL,
# # #   user_id INT                 NOT NULL,
# # #   text VARCHAR(255)           NOT NULL,
# # #   date INT                    NOT NULL,
# # #
# # #   FOREIGN KEY (conv_id)       REFERENCES conversation(conv_id),
# # #   FOREIGN KEY (user_id)       REFERENCES users(user_id)
# # # )
# # #   ENGINE = InnoDB;
# #
