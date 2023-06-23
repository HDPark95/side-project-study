package io.study.sideproject.domain.coupon.repository;

import io.study.sideproject.domain.coupon.entity.CouponHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponHistoryRepository extends JpaRepository<CouponHistory, Long> {
}
