package io.study.sideproject.domain.review.controller;

import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.request.ReviewSearchRequest;
import io.study.sideproject.domain.review.request.ReviewUpdateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
import io.study.sideproject.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Review 생성
    @PostMapping("/api/reviews")
    public ResponseEntity<ReviewResponse> createReview(@Valid @RequestBody ReviewCreateRequest request) {
        log.info("ReviewController createReview() run");

        ReviewResponse createReview = reviewService.createReview(request);
        log.info("createReview: {}", createReview);

        return new ResponseEntity<>(createReview, HttpStatus.CREATED);
    }

    // Review 전체조회(페이징, 검색)
    @GetMapping("/api/reviews")
    public ResponseEntity<Page<ReviewResponse>> getReviewList(
                                                              @PageableDefault(page = 0, size = 10) Pageable pageable,
                                                              @Valid ReviewSearchRequest request
                                                              ) {
        log.info("ReviewController getReviewList() run");

        Page<ReviewResponse> reviewList = reviewService.getReviewList(pageable, request);

        return ResponseEntity.ok(reviewList);
    }

    // Review 단건조회
    @GetMapping("/api/reviews/{reviewId}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable Long reviewId) {
        log.info("ReviewController getReview() run");

        ReviewResponse review = reviewService.getReview(reviewId);

        return ResponseEntity.ok(review);
    }

    // Review 수정
    @PatchMapping("/api/reviews/{reviewId}")
    public ResponseEntity<ReviewResponse> updateReview(
                                                        @PathVariable Long reviewId,
                                                        @RequestBody ReviewUpdateRequest request
                                                      ) {
        log.info("ReviewController updateReview() run");

        ReviewResponse reviewResponse = reviewService.updateReview(reviewId, request);

        return new ResponseEntity<>(reviewResponse, HttpStatus.OK);
    }

    // Review 삭제
    @DeleteMapping("/api/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        log.info("ReviewController deleteReview() run");

        reviewService.deleteReview(reviewId);
    }
}
