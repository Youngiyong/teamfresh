# teamfresh-voc-api

## Backend Stack
```
SpringBoot 2.4.2, MariaDB, JPA 
```

## Swagger
```
http://localhost:8088/swagger-ui/index.html
```

## Basic installation
```bash
java 8, docker, docker-compose
```

## Run local docker-composer and share workspace with local filesystem
```bash
docker-compose up
```
## DB Schema
```
CREATE TABLE `voc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
  `delivery_id` int(11) NOT NULL COMMENT '배송 아이디',
  `type` varchar(20) NOT NULL COMMENT 'DRIVER, CUSTOMER',
  `is_claim` tinyint(1) NOT NULL DEFAULT 0 COMMENT '클레임 여부',
  `status` varchar(3) NOT NULL DEFAULT '310' COMMENT '310:RECEIVE / 320:HOLD / 330: PROCEED / 340: CANCEL / 350: COMPLETE  ',
  `name` varchar(50) DEFAULT NULL COMMENT '귀책 작성자',
  `description` varchar(255) DEFAULT NULL COMMENT '귀책 내용',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
  `updated_at` datetime DEFAULT NULL COMMENT '업데이트 일자',
  `deleted_at` datetime DEFAULT NULL COMMENT '삭제 일자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_penalty` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
  `voc_id` int(11) NOT NULL COMMENT 'voc id',
  `is_verify` tinyint(1) NOT NULL DEFAULT 0 COMMENT '확인 여부',
  `is_sign` tinyint(1) NOT NULL DEFAULT 0 COMMENT '승인 여부',
  `answer` varchar(255) DEFAULT NULL COMMENT '승인 거절 이유',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
  `updated_at` datetime DEFAULT NULL COMMENT '업데이트 일자',
  `deleted_at` datetime DEFAULT NULL COMMENT '삭제 일자', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `voc_reparation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
  `voc_id` int(11) NOT NULL COMMENT 'voc_id',
  `name` varchar(50) DEFAULT NULL COMMENT '배상 책임자',
  `reason` varchar(255) DEFAULT NULL COMMENT '배상 사유',
  `penalty_price` int(11) NOT NULL COMMENT '배상 금액',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일자',
  `updated_at` datetime DEFAULT NULL COMMENT '업데이트 일자',
  `deleted_at` datetime DEFAULT NULL COMMENT '삭제 일자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
```
## Requirement

VOC 목록 API
GET http://localhost:8088/vocs

배상 목록 API
GET http://localhost:8088/vocs/reparations

VOC 등록
POST http://localhost:8088/vocs
status : 310(voc 접수 상태)

배상정보 등록
POST http://localhost:8088/vocs/reparations
type : CUSTOMER
배상정보 등록시 CUSTOMER -> (배상 시스템 자동 등록) voc status = 350 완료 상태로 변경

패널티 등록
POST http://localhost:8088/vocs/penalties
status : 330(voc 진행 상태)

배송기사의 패널티 확인 여부 등록
PUT http://localhost:8088/{vocId}/penalties/{id}

확인여부, 승인여부, 승인 거절 사유 업데이트 

승인 거절
status : 320(voc 홀드 상태)

is_verify=1, is_sign=1 승인시 voc 완료
```

