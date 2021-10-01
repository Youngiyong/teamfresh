CREATE TABLE `voc` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `delivery_id` int(11) NOT NULL,
    `type`varchar(20) NOT NULL COMMENT 'DRIVER, CUSTOMER',
    `status` varchar(3) NOT NULL DEFAULT 310 COMMENT '310:RECEIVE, 320:APPROVE, 330: PROCEED, 340 HOLD, 350: COMPLETE 360: CANCEL ',
    `reason` varchar(255) NOT NULL COMMENT '귀책 사유',
    `is_claim` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '클레임 여부',
    `created_at` datetime DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
    `deleted_at` datetime DEFAULT null COMMENT '삭제 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voc_reparation` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `voc_id` int(11) NOT NULL,
    `name` varchar(50),
    `phone` varchar(20),
    `reason` varchar(255) COMMENT '배상 사유',
    `created_at` datetime DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
    `deleted_at` datetime DEFAULT null COMMENT '삭제 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voc_claim` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `voc_id` int(11) NOT NULL,
    `claim_price` int NOT NULL COMMENT '청구 금액',
    `is_sign` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '확인 여부',
    `created_at` datetime DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` datetime DEFAULT null COMMENT '업데이트 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


