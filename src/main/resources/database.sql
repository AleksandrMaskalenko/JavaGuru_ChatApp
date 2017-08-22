-- noinspection SqlNoDataSourceInspectionForFile

-- Table : users
CREATE TABLE users (
  user_id INT                 NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(255)      NOT NULL,
  password VARCHAR(255)       NOT NULL,
  phone INT                   NOT NULL,
  email VARCHAR(255)          NOT NULL
  )
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id INT                      NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(255)      NOT NULL
)
  ENGINE = InnoDB;



-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_id INT                 NOT NULL,

  FOREIGN KEY (user_id)       REFERENCES users(user_id),
  FOREIGN KEY (role_id)       REFERENCES roles(id)
)
  ENGINE = InnoDB;


CREATE TABLE friendList (
  user_id INT                 NOT NULL,
  friend_id INT               NOT NULL,

  FOREIGN KEY (user_id)       REFERENCES user(user_id),
  FOREIGN KEY (friend_id)     REFERENCES user(user_id)
)
  ENGINE = InnoDB;

CREATE TABLE conversation (
  conv_id INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255)          NOT NULL,
  creationDate INT            NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE convMessage (
  message_id INT              NOT NULL AUTO_INCREMENT PRIMARY KEY,
  conv_id INT                 NOT NULL,
  user_id INT                 NOT NULL,
  text VARCHAR(255)           NOT NULL,
  date INT                    NOT NULL,

  FOREIGN KEY (conv_id)       REFERENCES conversation(conv_id),
  FOREIGN KEY (user_id)       REFERENCES user(user_id)
)
  ENGINE = InnoDB;

CREATE TABLE participants (
  particip_id INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
  conv_id INT                 NOT NULL,
  user_id INT                 NOT NULL,
  status BOOLEAN              NOT NULL,

  FOREIGN KEY (conv_id)       REFERENCES conversation(conv_id),
  FOREIGN KEY (user_id)       REFERENCES user(user_id)
)
  ENGINE = InnoDB;
