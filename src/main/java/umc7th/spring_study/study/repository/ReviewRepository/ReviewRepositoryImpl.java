package umc7th.spring_study.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7th.spring_study.study.domain.QReview;
import umc7th.spring_study.study.domain.QStore;
import umc7th.spring_study.study.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;

    @Override
    public List<Review> findReviewsByUserWithPagination(Long userId, Long cursorValue) {
        return queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()// Store 정보 포함
                .where(
                        review.member.id.eq(userId),
                        review.id.lt(cursorValue)// 커서 값보다 작은 ID로 제한
                )
                .orderBy(review.id.desc())
                .limit(10) // 최대 10개의 결과만 반환
                .fetch();
    }
}

