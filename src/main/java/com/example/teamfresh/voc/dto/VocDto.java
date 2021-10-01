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
        public static class RequestVoc {
            @ApiParam(value = "배송 아이디", required = true, example = "501234")
            @NotEmpty
            private Long deliveryId;

            @ApiParam(value = "배송사", required = true, example = "DRIVER/CUSTOMER")
            @NotEmpty
            private String type;

            @ApiParam(value = "귀책 사유", required = true, example = "귀책 사유 예시")
            @NotEmpty
            private String reason;

            @ApiParam(value = "이름", required = false, example = "윤기용")
            private String name;

            @ApiParam(value = "전화번호", required = false, example = "01092069357")
            private String phone;
        }

        @Getter
        public static class RequestVocClaim {
            @ApiParam(value = "voc id", required = true, example = "501234")
            private Long vocId;
            @ApiParam(value = "청구 금액", required = true, example = "5000")
            private int claimPrice;
        }

        @Getter
        @AllArgsConstructor
        public static class CreateResponse {
            @ApiParam(value = "id", example = "01092069357")
            private Long id;
            private int returnCode;
            private String returnMessage;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseVoc {
            @ApiParam(value = "청구 금액", required = true, example = "5000")
            private VocEntity voc;
        }
}
