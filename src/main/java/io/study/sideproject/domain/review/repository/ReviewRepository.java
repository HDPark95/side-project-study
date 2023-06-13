package io.study.sideproject.domain.review.repository;

import io.study.sideproject.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
