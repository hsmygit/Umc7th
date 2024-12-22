package umc7th.spring_study.study.repository.StoreRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.spring_study.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
