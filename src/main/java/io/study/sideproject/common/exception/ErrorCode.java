package io.study.sideproject.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // coupon
    NOT_FOUND_COUPON(HttpStatus.NOT_FOUND, "쿠폰을 찾을 수 없습니다."),

    // couponHistory
    NOT_FOUND_COUPONHISTORY(HttpStatus.NOT_FOUND, "쿠폰이력을 찾을 수 없습니다."),

    // review
    NOT_FOUND_REVIEW(HttpStatus.NOT_FOUND, "리뷰를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;
}
