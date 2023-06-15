package io.study.sideproject.domain.coupon.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.study.sideproject.domain.coupon.entity.Coupon;
import io.study.sideproject.domain.coupon.entity.CouponStatus;
import io.study.sideproject.domain.coupon.entity.CouponType;
import io.study.sideproject.domain.coupon.request.CouponSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import java.time.LocalDateTime;
import java.util.List;
import static io.study.sideproject.domain.coupon.entity.QCoupon.*;

@RequiredArgsConstructor
public class CouponRepositoryCustomImpl implements CouponRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Coupon> getCouponList(Pageable pageable, CouponSearchRequest searchRequest) {

        List<Coupon> couponList = queryFactory
                .selectFrom(coupon)
                .where(eqCouponCode(searchRequest.getCouponCode()),
                       eqCouponName(searchRequest.getCouponName()),
                       eqCouponType(searchRequest.getCouponType()),
                       eqCouponStatus(searchRequest.getCouponStatus()),
                       dateBetween(searchRequest.getStartAt(), searchRequest.getEndAt()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(coupon.couponCode.asc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(coupon.count())
                .from(coupon)
                .where(eqCouponCode(searchRequest.getCouponCode()),
                       eqCouponName(searchRequest.getCouponName()),
                       eqCouponType(searchRequest.getCouponType()),
                       eqCouponStatus(searchRequest.getCouponStatus()));

        return PageableExecutionUtils.getPage(couponList, pageable, countQuery::fetchOne);
    }

    private BooleanExpression eqCouponCode(String couponCode) {
        if (couponCode == null || couponCode.isEmpty()) {
            return null;
        }
        return coupon.couponCode.like("%"+couponCode+"%");
    }

    private BooleanExpression eqCouponName(String couponName) {
        if (couponName == null || couponName.isEmpty()) {
            return null;
        }
        return coupon.couponName.like("%"+couponName+"%");
    }

    private BooleanExpression eqCouponType(CouponType couponType) {
        if (couponType == null) {
            return null;
        }
        return coupon.couponType.eq(couponType);
    }

    private BooleanExpression eqCouponStatus(CouponStatus couponStatus) {
        if (couponStatus == null) {
            return null;
        }
        return coupon.couponStatus.eq(couponStatus);
    }

    /*
    private BooleanExpression eqStartAt(LocalDateTime startAt) {
        if (startAt == null) {
            return null;
        }
        return coupon.startAt.eq(startAt);
    }

    private BooleanExpression eqEndAt(LocalDateTime endAt) {
        if (endAt == null) {
            return null;
        }
        return coupon.endAt.eq(endAt);
    }
    */

    private BooleanExpression dateBetween(LocalDateTime startAt, LocalDateTime endAt) {
        if (endAt == null || startAt == null) {
            return null;
        }
        return coupon.startAt.between(startAt, endAt)
                .and(coupon.endAt.between(startAt, endAt));
    }
}
