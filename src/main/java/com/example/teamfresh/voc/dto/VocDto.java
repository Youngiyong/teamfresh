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
            @NotEmpty
            private Long deliveryId;

            @NotEmpty
            private String type;

            @NotEmpty
            @NotBlank
            private String name;

            @NotEmpty
            @NotBlank
            private String description;
        }

        @Getter
        public static class RequestVocPenalty {
            private Long vocId;
        }

        @Getter
        public static class RequestVocPenaltyUpdate {
            private int isVerify;
            private int isSign;
            private String answer;
       }

        @Getter
        public static class RequestVocReparation {
            private Long vocId;
            private String name;
            private String reason;
            private int penaltyPrice;
        }

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
