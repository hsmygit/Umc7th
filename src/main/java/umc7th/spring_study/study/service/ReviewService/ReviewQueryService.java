package umc7th.spring_study.study.service.ReviewService;

import umc7th.spring_study.study.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {

    Optional<Review> findReview(Long id); // 특정 리뷰 조회
    List<Review> findReviewsByUserWithPagination(Long userId, Long cursorValue); // 페이징된 작성한 리뷰 조회
    Review saveReview(Review review);  // 리뷰 작성 메서드 추가
}