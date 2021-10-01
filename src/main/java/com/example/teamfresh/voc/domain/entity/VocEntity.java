package com.example.teamfresh.voc.domain.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @Column(name = "status")
    private String status;

    @Column(name = "is_claim", insertable = false)
    private int isClaim;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @CreatedDate
    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "vocId")
    private List<VocPenaltyEntity> vocClam = new ArrayList<>();

    @OneToMany(mappedBy = "voc")
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
