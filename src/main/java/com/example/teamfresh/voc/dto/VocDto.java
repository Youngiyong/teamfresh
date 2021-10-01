package com.example.teamfresh.voc.dto;

import com.example.teamfresh.voc.domain.entity.VocEntity;
import com.example.teamfresh.voc.domain.entity.VocReparationEntity;
import io.swagger.annotations.ApiParam;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


public class VocDto {

        @Getter
        public static class RequestVoc {
            @ApiParam(value = "배송 아이디", required = true, example = "501234")
            @NotEmpty
            private Long deliveryId;

            @ApiParam(value = "배송사", required = true, example = "DRIVER/CUSTOMER")
            @NotEmpty
            private String type;

            @ApiParam(value = "귀책 작성자", required = true, example = "윤기용")
            @NotEmpty
            @NotBlank
            private String name;

            @ApiParam(value = "귀책 내용", required = true, example = "귀책 내용입니다.")
            @NotEmpty
            @NotBlank
            private String description;
        }

        @Getter
        public static class RequestVocPenalty {
            @ApiParam(value = "voc id", required = true, example = "501234")
            private Long vocId;
        }

        @Getter
        public static class RequestVocPenaltyUpdate {
            @ApiParam(value = "확인 여부", required = true, example = "1")
            private int isVerify;
            @ApiParam(value = "이의 여부", required = true, example = "1")
            private int isSign;
       }

        @Getter
        public static class RequestVocReparation {
            @ApiParam(value = "voc id", required = true, example = "501234")
            @NotEmpty
            @NotBlank
            private Long vocId;

            @ApiParam(value = "배상 책임자", required = true, example = "DRIVER/CUSTOMER")
            @NotEmpty
            @NotBlank
            private String name;

            @ApiParam(value = "배상 이유", required = true, example = "배상 이유입니다.")
            @NotEmpty
            @NotBlank
            private String reason;

            @ApiParam(value = "배상 금액", required = true, example = "5000")
            @NotEmpty
            @NotBlank
            private int penaltyPrice;
        }

//        @Getter
//        public static class RequestUpdateVocPenalties {
//            @ApiParam(value = "할인 여부", required = false, example = "1")
//            private int isVerify;
//
//            @ApiParam(value = "승인 여부", required = false, example = "1")
//            private int isSign;
//        }

        @Getter
        @AllArgsConstructor
        public static class ResponseUpdate {
            private Long id;
            private int returnCode;
            private String returnMessage;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseCreate {
            private Long id;
            private int returnCode;
            private String returnMessage;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseListVoc {
            private List<VocEntity> data;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseListVocReparation {
            private List<VocReparationEntity> data;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseVoc {
            private VocEntity data;
        }

        @Getter
        @AllArgsConstructor
        public static class ResponseVocReparation {
            private VocReparationEntity data;
        }
}
