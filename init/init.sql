SET NAMES utf8 ;

SET character_set_client = utf8mb4 ;



CREATE TABLE `voc` (
                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
                       `delivery_id` int(11) NOT NULL,
                       `type`varchar(20) NOT NULL COMMENT 'DRIVER, CUSTOMER',
                       `is_claim` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '클레임 여부',
                       `status` varchar(3) DEFAULT 310 COMMENT '310:RECEIVE / 320:HOLD / 330: PROCEED / 340: CANCEL / 350: COMPLETE  ',
                       `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
                       `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
                       `deleted_at` datetime DEFAULT null COMMENT '삭제 일자',
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voc_claim` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
                             `voc_id` int(11) NOT NULL,
                             `claim_price` int NOT NULL COMMENT '별도 청구 금액',
                             `is_verify` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '확인 여부',
                             `is_sign` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '승인 여부',
                             `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
                             `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voc_reparation` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
                                  `voc_id` int(11) NOT NULL,
                                  `name` varchar(50) DEFAULT null COMMENT '귀책 당사자',
                                  `reason` varchar(255) DEFAULT null COMMENT '귀책 사유',
                                  `total_price` int NOT NULL DEFAULT 0 COMMENT '전체 청구 금액',
                                  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
                                  `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
                                  `deleted_at` datetime DEFAULT null COMMENT '삭제 일자',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
