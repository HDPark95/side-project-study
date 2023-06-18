package io.study.sideproject.domain.review.response;

import io.study.sideproject.domain.review.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ReviewResponse {

    private final Long id;
    private final String content;
    private final Integer rating;

    @Builder
    public ReviewResponse(Long id, String content, Integer rating) {
        this.id = id;
        this.content = content;
        this.rating = rating;
    }

    static public ReviewResponse mapToDto(Review review) {

        return ReviewResponse.builder()
                .id(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .build();
    }
}
