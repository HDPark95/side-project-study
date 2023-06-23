package io.study.sideproject.domain.coupon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.common.Status;
import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupons")
@ToString
public class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", nullable = false)
    private CouponType couponType;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", nullable = false)
    private CouponStatus couponStatus;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;

    @Builder
    public Coupon(Long id, String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus, Status status, LocalDateTime startAt, LocalDateTime endAt) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    static public Coupon mapToEntity(CouponCreateRequest request) {
        return Coupon.builder()
                .couponCode(request.getCouponCode())
                .couponName(request.getCouponName())
                .couponType(request.getCouponType())
                .couponStatus(CouponStatus.UNUSED)
                .status(Status.ACTIVE)
                .startAt(request.getStartAt())
                .endAt(request.getEndAt())
                .build();
    }

    public void update(CouponUpdateRequest request) {
        this.couponCode = request.getCouponCode();
        this.couponName = request.getCouponName();
        this.couponType = request.getCouponType();
        this.couponStatus = request.getCouponStatus();
        this.startAt = request.getStartAt();
        this.endAt = request.getEndAt();
    }

    public void delete() {
        this.status = Status.REMOVE;
    }

    // 쿠폰사용기한이 만료되면 CouponStatus를 EXPIRED로 변경
    public void updateCouponStatus() {
        if(this.endAt.isBefore(LocalDateTime.now())) {
            this.couponStatus = CouponStatus.EXPIRED;
        }
    }
}
