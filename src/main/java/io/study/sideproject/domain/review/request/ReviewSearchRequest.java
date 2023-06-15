package io.study.sideproject.domain.review.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewSearchRequest {

    private String content;
    private Integer rating;

    @Builder
    public ReviewSearchRequest(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
    }
}
