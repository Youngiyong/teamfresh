package com.example.teamfresh.voc.dto;

import com.example.teamfresh.voc.common.VocStatus;
import com.example.teamfresh.voc.domain.entity.VocClaimEntity;
import com.example.teamfresh.voc.domain.entity.VocEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


public class VocDto {

        @Getter
        @AllArgsConstructor
        @Builder
        public static class Voc {
            private Long id;
            private String reason;
        }
        @Getter
        @Setter
        public static class RequestVoc {
            @ApiParam(value = "배송 아이디", required = true, example = "501234")
            private Long deliveryId;

            @ApiParam(value = "배송사", required = true, example = "DRIVER/CUSTOMER")
            private String type;

            @ApiParam(value = "귀책 사유", required = true, example = "귀책 사유 예시")
            private String reason;

            @ApiParam(value = "이름", required = false, example = "윤기용")
            private String name;

            @ApiParam(value = "전화번호", required = false, example = "01092069357")
            private String phone;
        }

        @Getter
        @AllArgsConstructor
        public static class Response {
            private VocEntity voc;
            private int returnCode;
            private String returnMessage;
        }

}
