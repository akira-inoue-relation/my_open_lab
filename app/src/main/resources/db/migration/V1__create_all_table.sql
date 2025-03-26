CREATE TABLE IF NOT EXISTS account_master (
  id INT not null auto_increment
  , person_name VARCHAR(80) not null
  , person_name_kana VARCHAR(80) not null
  , store_id INT not null
  , login_id VARCHAR(32) not null
  , password VARCHAR(256) not null
  , authority INT not null
  , PRIMARY KEY (id))
ENGINE = InnoDB;
