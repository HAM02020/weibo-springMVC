
CREATE TABLE `AccessToken` (
                               `uid` varchar(20) NOT NULL,
                               `expires_in` varchar(50) DEFAULT NULL,
                               `access_token` varchar(50) DEFAULT NULL,
                               PRIMARY KEY (`uid`),
                               UNIQUE KEY `AccessToken_uid_uindex` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Status` (
                          `statusId` bigint(20) NOT NULL,
                          `userId` bigint(20) NOT NULL,
                          `jsonStr` blob,
                          `creatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (`statusId`,`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `User` (
                        `idstr` varchar(20) NOT NULL,
                        `screen_name` varchar(50) DEFAULT NULL,
                        `profile_image_url` varchar(255) DEFAULT NULL,
                        `friends_count` int(20) DEFAULT NULL,
                        `followers_count` int(20) DEFAULT NULL,
                        `statuses_count` int(20) DEFAULT NULL,
                        PRIMARY KEY (`idstr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
