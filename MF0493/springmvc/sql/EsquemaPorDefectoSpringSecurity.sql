CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
  
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);
  
-- User user/pass
INSERT INTO users (username, password, enabled)
  values ('admin',
    '$2a$10$bdBXRibVaj/DTXZ58JGTUOtBVdzDC.T0duOSN.LDAUUSlU.fKvxoC',
    1);

INSERT INTO authorities (username, authority)
  values ('admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled)
  values ('pepe',
    '$2a$10$b2ynSxXRLQPUN3atFyg9UeJ9Hzt.fRX0CJA/HTRZfMN8lv34lwmyO',
    1);
    
INSERT INTO authorities (username, authority)
  values ('pepe', 'ROLE_USER');