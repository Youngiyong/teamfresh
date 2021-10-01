package com.example.teamfresh.voc.domain.entity;


import com.example.teamfresh.voc.common.VocStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "voc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "delivery_id", nullable = false)
    private Long deliveryId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "status", insertable = false)
    private String status;

    @Column(name = "reason", nullable = false, length = 255)
    private String reason;

    @Column(name = "is_claim", insertable = false)
    private Short isClaim;

    @CreatedDate
    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "vocId")
    private List<VocClaimEntity> vocClam = new ArrayList<>();

    @OneToMany(mappedBy = "vocId")
    private List<VocReparationEntity> vocReparation = new ArrayList<>();

//    @Builder
//    public VocEntity(Long deliveryId, String reason, String type) {
//        this.deliveryId = deliveryId;
//        this.reason = reason;
//        this.type = type;
//    }
//
//    private void setStatus(final VocStatus status) {
//        switch (status) {
//            case RECEIVE:
//                receive();
//                break;
//            case APPROVE:
//                approve();
//                break;
//            case PROCEED:
//                proceed();
//                break;
//            case CANCEL:
//                cancel();
//                break;
//            case COMPLETE:
//                complete();
//                break;
//            case HOLD:
//                hold();
//                break;
//            default:
//                throw new IllegalArgumentException(status.name() + " is not found");
//        }
//    }
//
//    private void approve() {
//        this.status = VocStatus.APPROVE;
//    }
//
//    private void proceed() {
//        this.status = VocStatus.PROCEED;
//    }
//
//    private void cancel() {
//        this.status = VocStatus.CANCEL;
//    }
//
//    private void receive() {
//        this.status = VocStatus.RECEIVE;
//    }
//
//    private void complete() {
//        this.status = VocStatus.COMPLETE;
//    }
//
//    private void hold() {
//        this.status = VocStatus.HOLD;
//    }
}
