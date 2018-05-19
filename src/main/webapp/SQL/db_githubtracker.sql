DROP DATABASE IF EXISTS `githubtracker`;
CREATE DATABASE `githubtracker` DEFAULT CHARACTER SET utf8;

USE `githubtracker`;

#------------------------------------------------------------
# Table: githuber
#------------------------------------------------------------

DROP TABLE IF EXISTS `githuber`;

CREATE TABLE `githuber`(
        id_githuber INTEGER (11) Auto_increment  NOT NULL ,
        github_id   INTEGER DEFAULT NULL,
        name        Varchar (50) DEFAULT NULL,
        login       Varchar (50) DEFAULT NULL,
        url         Varchar (70) DEFAULT NULL,
        email       Varchar (70) DEFAULT NULL,
        bio         Text DEFAULT NULL,
        location    Varchar (70) DEFAULT NULL,
        avatar_url  Varchar (70) DEFAULT NULL,
        PRIMARY KEY (id_githuber )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
