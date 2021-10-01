package com.example.teamfresh.voc.dto;

import com.example.teamfresh.voc.common.VocStatus;
import com.example.teamfresh.voc.domain.entity.VocClaimEntity;
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
            private Long deliveryId;
            private String type;
            private String reason;
            private String name;
            private String phone;
        }

        @Getter
        @AllArgsConstructor
        public static class Response {
            private Voc voc;
            private int returnCode;
            private String returnMessage;
        }

}
