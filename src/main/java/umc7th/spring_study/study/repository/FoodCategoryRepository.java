package umc7th.spring_study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.spring_study.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
