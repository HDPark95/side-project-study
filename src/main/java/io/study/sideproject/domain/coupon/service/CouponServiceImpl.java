package io.study.sideproject.domain.coupon.service;

import io.study.sideproject.common.exception.CustomException;
import io.study.sideproject.common.exception.ErrorCode;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.repository.CouponRepository;
import io.study.sideproject.domain.coupon.request.CouponCreateRequest;
import io.study.sideproject.domain.coupon.request.CouponSearchRequest;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.coupon.response.CouponResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;

    // Coupon 생성
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

    // Coupon 전체조회(페이징, 검색)
    @Override
    public Page<CouponResponse> getCouponList(Pageable pageable, CouponSearchRequest request) {
        log.info("CouponServiceImpl getCouponList() run");

        Page<Coupon> couponList = couponRepository.getCouponList(pageable, request);
//        for(Coupon coupon : couponList) {
//            coupon.updateCouponStatus();
//        }

        return couponList.map(CouponResponse::mapToDto);
    }

    // Coupon 단건조회
    @Override
    public CouponResponse getCoupon(Long couponId) {
        log.info("CouponServiceImpl getCoupon() run");

        Coupon findCoupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPON));

        return CouponResponse.mapToDto(findCoupon);
    }

    // Coupon 수정
    @Transactional
    @Override
    public CouponResponse updateCoupon(Long couponId, CouponUpdateRequest request) {
        log.info("CouponServiceImpl updateCoupon() run");

        Coupon findCoupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPON));

        findCoupon.update(request);

        return CouponResponse.mapToDto(findCoupon);
    }

    // Coupon 삭제 (status ACTIVE -> REMOVE)
    @Transactional
    @Override
    public CouponResponse deleteCoupon(Long couponId) {
        log.info("CouponServiceImpl deleteCoupon() run");

        Coupon findCoupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_COUPON));

        findCoupon.delete();

        return CouponResponse.mapToDto(findCoupon);
    }
}
