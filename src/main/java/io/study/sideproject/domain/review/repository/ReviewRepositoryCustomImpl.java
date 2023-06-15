package io.study.sideproject.domain.review.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.study.sideproject.domain.review.entity.Review;
import io.study.sideproject.domain.review.request.ReviewSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import java.util.List;
import static io.study.sideproject.domain.review.entity.QReview.*;

@RequiredArgsConstructor
public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Review> getReviewList(Pageable pageable, ReviewSearchRequest request) {

        List<Review> reviewList = queryFactory
                .selectFrom(review)
                .where(eqContent(request.getContent()),
                       eqRating(request.getRating()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(review.id.desc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(review.count())
                .from(review)
                .where(eqContent(request.getContent()),
                       eqRating(request.getRating()));

        return PageableExecutionUtils.getPage(reviewList, pageable, countQuery::fetchOne);
    }

    private BooleanExpression eqContent(String content) {
        if (content == null || content.isEmpty()) {
            return null;
        }
        return review.content.like("%"+content+"%");
    }

    private BooleanExpression eqRating(Integer rating) {
        if (rating == null) {
            return null;
        }
        return review.rating.eq(rating);
    }
}
