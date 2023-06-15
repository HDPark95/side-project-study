package io.study.sideproject.domain.review.service;

import io.study.sideproject.common.exception.CustomException;
import io.study.sideproject.common.exception.ErrorCode;
import io.study.sideproject.domain.review.entity.Review;
import io.study.sideproject.domain.review.repository.ReviewRepository;
import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.request.ReviewSearchRequest;
import io.study.sideproject.domain.review.request.ReviewUpdateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
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
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    // Review 생성
    @Transactional
    @Override
    public ReviewResponse createReview(ReviewCreateRequest request) {
        log.info("ReviewServiceImpl createReview() run");

        Review review = Review.mapToEntity(request);
        log.info("review: {}", review);

        Review saveReview = reviewRepository.save(review);
        log.info("saveReview: {}", saveReview);

        return ReviewResponse.mapToDto(saveReview);
    }

    // Review 전체조회(페이징, 검색)
    @Override
    public Page<ReviewResponse> getReviewList(Pageable pageable, ReviewSearchRequest request) {
        log.info("ReviewServiceImpl getReviewList() run");

        Page<Review> reviewList = reviewRepository.getReviewList(pageable, request);
        log.info("request: {}", request);
        log.info("reviewList: {}", reviewList);

        return reviewList.map(ReviewResponse::mapToDto);
    }

    // Review 단건조회
    @Override
    public ReviewResponse getReview(Long reviewId) {
        log.info("ReviewServiceImpl getReview() run");

        Review findReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_REVIEW));

        return ReviewResponse.mapToDto(findReview);
    }

    // Review 수정
    @Transactional
    @Override
    public ReviewResponse updateReview(Long reviewId, ReviewUpdateRequest request) {
        log.info("ReviewServiceImpl updateReview() run");

        Review findReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_REVIEW));

        findReview.update(request);

        return ReviewResponse.mapToDto(findReview);
    }

    @Transactional
    @Override
    public void deleteReview(Long reviewId) {
        log.info("ReviewServiceImpl deleteReview() run");

        Review findReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_REVIEW));

        reviewRepository.delete(findReview);
    }
}
