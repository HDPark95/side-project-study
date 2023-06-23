package io.study.sideproject.domain.coupon.entity;

import io.study.sideproject.domain.account.model.Account;
import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.common.Status;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupons_history")
public class CouponHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_history_id")
    private Long id;

    @Column(name = "coupon_status", nullable = false)
    private CouponStatus couponStatus;

    @Column(name = "used_date")
    private LocalDateTime usedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("order_good_id")
    private OrderGood orderGood;
    */

    @Builder
    public CouponHistory(Long id, CouponStatus couponStatus, LocalDateTime usedDate, LocalDateTime deletedDate, Coupon coupon, Account account) {
        this.id = id;
        this.couponStatus = couponStatus;
        this.usedDate = usedDate;
        this.deletedDate = deletedDate;
        this.coupon = coupon;
        this.account = account;
    }

    static public CouponHistory mapToEntity(Coupon coupon, Account account) {
        return CouponHistory.builder()
                .couponStatus(coupon.getCouponStatus())
                .coupon(coupon)
                .account(account)
                .build();
    }

    public void delete() {
        this.deletedDate = LocalDateTime.now();
    }
}
