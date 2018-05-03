DROP USER IF EXISTS 'securityDemo';
CREATE USER 'securityDemo'@'localhost' IDENTIFIED BY'securityDemo';

DROP SCHEMA IF EXISTS security;
CREATE SCHEMA security DEFAULT CHARACTER SET UTF8;

GRANT ALL PRIVILEGES ON security.* TO 'securityDemo'@'localhost' IDENTIFIED BY 'securityDemo';
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS security.Member;
CREATE TABLE security.Member(
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    CONSTRAINT name_unique UNIQUE(`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS security.Role;
CREATE TABLE security.Role (
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS security.members_roles;
CREATE TABLE security.members_roles (
	`member_id` BIGINT NOT NULL,
    `role_id` BIGINT NOT NULL,
    FOREIGN KEY (`member_id`) REFERENCES `Member`(`id`),
    FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`),
    CONSTRAINT members_roles_unique_key UNIQUE(`member_id`,`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS security.Resources;
CREATE TABLE security.Resource(
	`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS security.roles_resources;
CREATE TABLE security.roles_resources (
	`role_id` BIGINT NOT NULL,
    `resource_id` BIGINT NOT NULL,
    FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`),
    FOREIGN KEY (`resource_id`) REFERENCES `Resource`(`id`),
    CONSTRAINT roles_resources_unique_key UNIQUE(`role_id`,`resource_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO security.Member(id,name,password) VALUES(1,'admin','$2a$10$zG8mZdb/J65dmgpLQGAXG.cYfg7FsN4SAtU1fGL.NFG9ercVRrlzy');
-- password : admin
INSERT INTO security.Member(id,name,password) VALUES(2,'user','$2a$10$mqrQ49fIOBVn1coAkKJxLeeAneSbk5im19qHJ50GXuTiiMm0K.ykC');
-- password : user
INSERT INTO security.Member(id,name,password) VALUES(3,'empty','$2a$10$d3FM7hqyi5L0q9/5V5YhtOdco7KoqeuXd/O.I5fkPRJYoIpGl9w5.');
-- password : empty

INSERT INTO security.Role(id,name) VALUES(1,'ROLE_ADMIN');
INSERT INTO security.Role(id,name) VALUES(2,'ROLE_USER');

INSERT INTO security.Resource(id,name) VALUES(1,'/api/admin');
INSERT INTO security.Resource(id,name) VALUES(2,'/api/user');
INSERT INTO security.Resource(id,name) VALUES(3,'/api/home');

INSERT INTO security.members_roles(member_id,role_id) VALUES(1,1);
INSERT INTO security.members_roles(member_id,role_id) VALUES(2,2);

INSERT INTO security.roles_resources(role_id,resource_id) VALUES(1,1);
INSERT INTO security.roles_resources(role_id,resource_id) VALUES(1,3);
INSERT INTO security.roles_resources(role_id,resource_id) VALUES(2,2);
INSERT INTO security.roles_resources(role_id,resource_id) VALUES(2,3);