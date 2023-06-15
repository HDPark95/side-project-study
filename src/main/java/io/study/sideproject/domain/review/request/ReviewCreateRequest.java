package io.study.sideproject.domain.review.request;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewCreateRequest {

    @NotBlank(message = "리뷰 내용은 필수로 입력해야합니다.")
    private String content;

    @NotBlank(message = "평점은 필수로 입력해야합니다.")
    private Integer rating;

    @Builder
    public ReviewCreateRequest(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
    }
}
