package umc7th.spring_study.study.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.spring_study.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}

