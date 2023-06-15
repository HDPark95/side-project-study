package io.study.sideproject.domain.coupon.repository;

import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.request.CouponSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponRepositoryCustom {

    Page<Coupon> getCouponList(Pageable pageable, CouponSearchRequest searchRequest);
}
