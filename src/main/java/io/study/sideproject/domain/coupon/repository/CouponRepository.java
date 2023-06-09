package io.study.sideproject.domain.coupon.repository;

import io.study.sideproject.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
