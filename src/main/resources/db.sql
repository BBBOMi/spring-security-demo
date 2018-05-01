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

DROP TABLE IF EXISTS security.Privilege;
CREATE TABLE security.Privilege (
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

DROP TABLE IF EXISTS security.roles_privileges;
CREATE TABLE security.roles_privileges (
	`role_id` BIGINT NOT NULL,
    `privilege_id` BIGINT NOT NULL,
    FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`),
    FOREIGN KEY (`privilege_id`) REFERENCES `Privilege`(`id`),
    CONSTRAINT roles_privileges_unique_key UNIQUE(`role_id`,`privilege_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;