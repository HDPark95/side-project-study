package io.study.sideproject.domain.review.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewUpdateRequest {

    private String content;
    private Integer rating;

    @Builder
    public ReviewUpdateRequest(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
    }
}
