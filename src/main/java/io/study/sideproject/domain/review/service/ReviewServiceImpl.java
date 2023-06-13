package io.study.sideproject.domain.review.service;

import io.study.sideproject.domain.review.entity.Review;
import io.study.sideproject.domain.review.repository.ReviewRepository;
import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("request: {}", request);

        Review review = Review.mapToEntity(request);
        log.info("review: {}", review);

        Review saveReview = reviewRepository.save(review);
        log.info("saveReview: {}", saveReview);

        return ReviewResponse.mapToDto(saveReview);
    }
}
