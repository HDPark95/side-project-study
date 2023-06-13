package io.study.sideproject.domain.review.service;

import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;

public interface ReviewService {

    // Review 생성
    ReviewResponse createReview(ReviewCreateRequest request);

    // Review 전체조회(페이징, 검색)

    // Review 단건조회

    // Review 수정

    // Review 삭제
}
