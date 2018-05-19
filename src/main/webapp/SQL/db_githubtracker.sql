DROP DATABASE IF EXISTS `githubtracker`;
CREATE DATABASE `githubtracker` DEFAULT CHARACTER SET utf8;

USE `githubtracker`;

#------------------------------------------------------------
# Table: githuber
#------------------------------------------------------------

DROP TABLE IF EXISTS `githuber`;

CREATE TABLE `githuber`(
        id_githuber int (11) Auto_increment  NOT NULL ,
        github_id   Int NOT NULL ,
        name        Varchar (50) ,
        login       Varchar (50) ,
        url         Varchar (70) ,
        email       Varchar (70) ,
        bio         Text ,
        locatoin    Varchar (70) ,
        avatar_url  Varchar (70) ,
        PRIMARY KEY (id_githuber )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;