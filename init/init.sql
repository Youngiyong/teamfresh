CREATE TABLE `voc`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '' 시퀀스 '',
    `delivery_id` int(11) NOT NULL COMMENT '' 배송 아이디 '',
    `type`        varchar(20) NOT NULL COMMENT '' DRIVER,
    CUSTOMER '',
    `is_claim`    tinyint(1) NOT NULL DEFAULT 0 COMMENT '' 클레임 여부 '',
    `status`      varchar(3)  NOT NULL DEFAULT '' 310 '',
    `name`        varchar(50)          DEFAULT NULL COMMENT '' 귀책 작성자 '',
    `description` varchar(255)         DEFAULT NULL COMMENT '' 귀책 내용 '',
    `created_at`  datetime    NOT NULL DEFAULT current_timestamp() COMMENT '' 생성일자 '',
    `updated_at`  datetime             DEFAULT NULL COMMENT '' 업데이트 일자 '',
    `deleted_at`  datetime             DEFAULT NULL COMMENT '' 삭제 일자 '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_penalty`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT COMMENT '' 시퀀스 '',
    `voc_id`     int(11) NOT NULL COMMENT '' voc id '',
    `is_verify`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '' 확인 여부 '',
    `is_sign`    tinyint(1) NOT NULL DEFAULT 0 COMMENT '' 승인 여부 '',
    `answer`     varchar(255)      DEFAULT NULL COMMENT '' 승인 거절 이유 '',
    `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '' 생성일자 '',
    `updated_at` datetime          DEFAULT NULL COMMENT '' 업데이트 일자 '',
    `deleted_at` datetime          DEFAULT NULL COMMENT '' 삭제 일자 '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_reparation`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT COMMENT '' 시퀀스 '',
    `voc_id`        int(11) NOT NULL COMMENT '' voc_id '',
    `name`          varchar(50)       DEFAULT NULL COMMENT '' 배상 책임자 '',
    `reason`        varchar(255)      DEFAULT NULL COMMENT '' 배상 사유 '',
    `penalty_price` int(11) NOT NULL COMMENT '' 배상 금액 '',
    `created_at`    datetime NOT NULL DEFAULT current_timestamp() COMMENT '' 생성일자 '',
    `updated_at`    datetime          DEFAULT NULL COMMENT '' 업데이트 일자 '',
    `deleted_at`    datetime          DEFAULT NULL COMMENT '' 삭제 일자 '',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;