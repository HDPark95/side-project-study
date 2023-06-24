package io.study.sideproject.domain.review.entity;

import io.study.sideproject.domain.common.BaseEntity;
import io.study.sideproject.domain.common.Status;
import io.study.sideproject.domain.coupon.request.CouponUpdateRequest;
import io.study.sideproject.domain.review.request.ReviewCreateRequest;
import io.study.sideproject.domain.review.request.ReviewUpdateRequest;
import io.study.sideproject.domain.review.response.ReviewResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reviews")
@ToString
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name ="content", nullable = false)
    private String content;

    @Column(name ="rating", nullable = false)
    private Integer rating;

    @Enumerated(EnumType.STRING)
    private Status status;

    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn("good_id")
    private Good good;
    */

    @Builder
    public Review(Long id, String content, Integer rating, Status status) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.status = status;
    }

    static public Review mapToEntity(ReviewCreateRequest request) {
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .status(Status.ACTIVE)
                .build();
    }

    public void update(ReviewUpdateRequest request) {
        this.content = request.getContent();
        this.rating = request.getRating();
    }
}
