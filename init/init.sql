SET NAMES utf8 ;

SET character_set_client = utf8mb4 ;

CREATE TABLE `reparation`
(
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `type` varchar(30) NOT NULL COMMENT '배상 타입',
    `reason` varchar(255) NOT NULL COMMENT '베상 사유',
    `created_at` timestamp DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` timestamp DEFAULT null COMMENT '업데이트 일자',
    `deleted_at` timestamp DEFAULT null COMMENT '삭제 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `voc` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `reparation_id` int(11)  NOT NULL COMMENT '배상 아이디',
    `status` varchar(3) NOT NULL DEFAULT 300 COMMENT '300: voc 접수, 310:클레임 접수, 320:배상 승인, 330: 배상 거절, 340 배상 취소, 350: 배상 완료 ',
    `reason` varchar(100) NOT NULL COMMENT '귀책 사유',
    `is_claim` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '클레임 여부',
    `created_at` timestamp DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` timestamp DEFAULT null COMMENT '업데이트 일자',
    `deleted_at` timestamp DEFAULT null COMMENT '삭제 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `voc_claim` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `voc_id` int(11) NOT NULL,
    `claim_price` int NOT NULL COMMENT '청구 금액',
    `created_at` timestamp DEFAULT current_timestamp() COMMENT '생성일자',
    `updated_at` timestamp DEFAULT null COMMENT '업데이트 일자',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;