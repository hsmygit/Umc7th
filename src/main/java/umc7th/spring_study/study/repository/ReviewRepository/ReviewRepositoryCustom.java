package umc7th.spring_study.study.repository.ReviewRepository;

import umc7th.spring_study.study.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByUserWithPagination(Long userId, Long cursorValue);
}