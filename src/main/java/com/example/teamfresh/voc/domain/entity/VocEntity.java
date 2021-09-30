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
@Table(name = "vocs")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class VocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reparation_id", nullable = false)
    private int reparation_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VocStatus status;

    @Column(name = "reason", nullable = false, length = 100)
    private String reason;

    @Column(name = "is_claim", nullable = false, length = 1)
    private String isClaim;

    @OneToMany(mappedBy = "voc_claim")
    private List<VocClaimEntity> vocClaim = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public VocEntity(int reparation_id, String reason, VocStatus status) {
        this.reparation_id = reparation_id;
        this.reason = reason;
        setStatus(status);
    }

    private void setStatus(final VocStatus status) {
        switch (status) {
            case RECEIVE:
                receive();
                break;
            case APPROVE:
                approve();
                break;
            case PROCEED:
                proceed();
                break;
            case CANCEL:
                cancel();
                break;
            case COMPLETE:
                complete();
                break;
            case HOLD:
                hold();
                break;
            default:
                throw new IllegalArgumentException(status.name() + " is not found");
        }
    }

    private void approve() {
        this.status = VocStatus.APPROVE;
    }

    private void proceed() {
        this.status = VocStatus.PROCEED;
    }

    private void cancel() {
        this.status = VocStatus.CANCEL;
    }

    private void receive() {
        this.status = VocStatus.RECEIVE;
    }

    private void complete() {
        this.status = VocStatus.COMPLETE;
    }

    private void hold() {
        this.status = VocStatus.HOLD;
    }
}
