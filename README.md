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


## Requirement
```
1) VOC 목록 API
GET http://localhost:8088/vocs

2) 배상 목록 API
GET http://localhost:8088/vocs/reparations
3) 공통

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
is_verify : 1
확인여부, 승인여부, 이의 이유 업데이트 

승인 거절
status : 320(voc 홀드 상태)

is_verify=1, is_sign=1 승인시 voc 완료
```

