package io.study.sideproject.domain.review.repository;

import io.study.sideproject.domain.review.entity.Review;
import io.study.sideproject.domain.review.request.ReviewSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {

    Page<Review> getReviewList(Pageable pageable, ReviewSearchRequest request);
}
