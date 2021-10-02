CREATE TABLE `voc`
(
    `id`          int(11) NOT NULL,
    `delivery_id` int(11) NOT NULL,
    `type`        varchar(20) NOT NULL,
    `is_claim`    tinyint(1) NOT NULL DEFAULT 0,
    `status`      varchar(3)  NOT NULL DEFAULT '310',
    `name`        varchar(50)          DEFAULT NULL,
    `description` varchar(255)         DEFAULT NULL,
    `created_at`  datetime    NOT NULL DEFAULT current_timestamp(),
    `updated_at`  datetime             DEFAULT NULL,
    `deleted_at`  datetime             DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_penalty`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `voc_id`     int(11) NOT NULL ,
    `is_verify`  tinyint(1) NOT NULL DEFAULT 0,
    `is_sign`    tinyint(1) NOT NULL DEFAULT 0,
    `answer`     varchar(255)      DEFAULT NULL,
    `created_at` datetime NOT NULL DEFAULT current_timestamp(),
    `updated_at` datetime          DEFAULT NULL,
    `deleted_at` datetime          DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_reparation`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `voc_id`        int(11) NOT NULL,
    `name`          varchar(50)       DEFAULT NULL,
    `reason`        varchar(255)      DEFAULT NULL,
    `penalty_price` int(11) NOT NULL,
    `created_at`    datetime NOT NULL DEFAULT current_timestamp() ,
    `updated_at`    datetime          DEFAULT NULL,
    `deleted_at`    datetime          DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;