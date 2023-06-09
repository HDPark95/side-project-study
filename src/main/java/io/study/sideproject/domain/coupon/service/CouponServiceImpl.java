package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.common.exception.CustomException;
import io.study.sideproject.common.exception.ErrorCode;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.repository.CouponRepository;
import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;

    @Transactional
    @Override
    public CouponResponse createCoupon(CouponCreateRequest request) {
        log.info("CouponServiceImpl createCoupon() run");

        Coupon coupon = Coupon.mapToEntity(request);
        log.info("request: {}", request);
        log.info("coupon: {}", coupon);

        Coupon saveCoupon = couponRepository.save(coupon);
        log.info("saveCoupon: {}", saveCoupon);

        return CouponResponse.mapToDto(saveCoupon);
    }

    @Transactional
    @Override
    public CouponResponse updateCoupon(Long couponId, CouponUpdateRequest request) {
        log.info("CouponServiceImpl updateCoupon() run");

        Coupon findCoupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPON));

        findCoupon.update(request);

        return CouponResponse.mapToDto(findCoupon);
    }
}
