-- -----------------------------------------------------
-- Schema Bingo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS bingo DEFAULT CHARACTER SET utf8 ;
USE bingo ;

-- -----------------------------------------------------
-- Table 'bingo'.'game'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bingo.game (
  id_game INT NOT NULL AUTO_INCREMENT,
  winner VARCHAR(80) NULL,
  created_at DATE not NULL DEFAULT CURRENT_TIMESTAMP,
  deleted_at DATE NULL,
  PRIMARY KEY (id_game))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table 'Bingo'.'game_has_idp'
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bingo.game_has_idp (
  id_game INT NOT NULL,
  id_gamer VARCHAR(80) not NULL,
  PRIMARY KEY (id_game),
  CONSTRAINT id_game
    FOREIGN KEY (id_game)
    REFERENCES bingo.game (id_game)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
