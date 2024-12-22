package umc7th.spring_study.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.spring_study.study.domain.Review;
import umc7th.spring_study.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);  // 특정 리뷰 조회
    }

    @Override
    public List<Review> findReviewsByUserWithPagination(Long userId, Long cursorValue) {
        List<Review> reviews = reviewRepository.findReviewsByUserWithPagination(userId, cursorValue); // 페이징된 리뷰 조회

        reviews.forEach(review -> System.out.println("Review: " + review)); // 각 리뷰 출력

        return reviews;
    }
    @Override
    @Transactional  // 저장 작업을 위해 @Transactional 활성화
    public Review saveReview(Review review) {
        return reviewRepository.save(review);  // 리뷰 저장
    }
}
