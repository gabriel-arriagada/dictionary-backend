DROP SCHEMA IF EXISTS words_dictionary;

CREATE DATABASE words_dictionary CHARACTER SET utf8;

USE words_dictionary;

CREATE TABLE IF NOT EXISTS User (
    userId INT UNSIGNED NOT NULL auto_increment,
    username VARCHAR(128) NOT NULL,
    password VARCHAR(256) NOT NULL,
    enabled BOOL NOT NULL,
    constraint pk_user primary key (userId),
	constraint u_user UNIQUE (username)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Role (
	roleId INT UNSIGNED NOT NULL auto_increment,
	userId INT UNSIGNED NOT NULL,
	roleName VARCHAR(128) NOT NULL,
	constraint pk_role primary key (roleId),
	constraint fk_role foreign key (userId) references User (userId)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Language (
	languageId INT UNSIGNED NOT NULL auto_increment,	
	language VARCHAR(128) NOT NULL,
	constraint pk_language primary key (languageId)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Word(
	id INT UNSIGNED NOT NULL auto_increment,
	word VARCHAR(200) NOT NULL,
	meaning VARCHAR(250) NOT NULL,
	userId INT UNSIGNED NOT NULL,
	languageId INT UNSIGNED NOT NULL,
	constraint pk_word primary key (id),
	constraint u_word UNIQUE (word),
	constraint fk_user foreign key (userId) references User (userId),
	constraint fk_language foreign key (languageId) references Language (languageId)
) ENGINE = InnoDB;
