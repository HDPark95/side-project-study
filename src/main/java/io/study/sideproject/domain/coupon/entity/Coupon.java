package io.study.sideproject.domain.coupon.entity;

import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    */

    @Builder
    public Coupon(Long id, String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
    }

    static public Coupon mapToEntity(CouponCreateRequest request) {
        return Coupon.builder()
                .couponCode(request.getCouponCode())
                .couponName(request.getCouponName())
                .couponType(request.getCouponType())
                .couponStatus(CouponStatus.UNUSED)
                .build();
    }

    public void update(CouponUpdateRequest request) {
        this.couponCode = request.getCouponCode();
        this.couponName = request.getCouponName();
        this.couponType = request.getCouponType();
        this.couponStatus = request.getCouponStatus();
    }
}
