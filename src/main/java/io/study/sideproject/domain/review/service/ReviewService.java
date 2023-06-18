package io.study.sideproject.domain.review.service;

import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.request.ReviewSearchRequest;
import io.study.sideproject.domain.review.request.ReviewUpdateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    // Review 생성
    ReviewResponse createReview(ReviewCreateRequest request);

    // Review 전체조회(페이징, 검색)
    Page<ReviewResponse> getReviewList(Pageable pageable, ReviewSearchRequest request);

    // Review 단건조회
    ReviewResponse getReview(Long reviewId);

    // Review 수정
    ReviewResponse updateReview(Long reviewId, ReviewUpdateRequest request);

    // Review 삭제
    void deleteReview(Long reviewId);
}
