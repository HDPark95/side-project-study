package io.study.sideproject.domain.review.controller;

import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
import io.study.sideproject.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Review 생성
    @PostMapping("/api/reviews")
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewCreateRequest request) {
        log.info("ReviewController createReview() run");

        ReviewResponse createReview = reviewService.createReview(request);
        log.info("createReview: {}", createReview);

        return new ResponseEntity<>(createReview, HttpStatus.CREATED);
    }
}
