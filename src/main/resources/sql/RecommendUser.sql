-- auto Generated on 2018-11-28 09:30:02 
-- DROP TABLE IF EXISTS `recommend_user`; 
CREATE TABLE recommend_user(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `recommend_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '�Ƽ�ID',
    `user_id` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '�û�ID',
    `source` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '�Ƽ���Դ',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    `is_deleted` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'isDeleted',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'recommend_user';