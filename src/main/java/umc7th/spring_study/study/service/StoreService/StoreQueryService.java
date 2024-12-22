package umc7th.spring_study.study.service.StoreService;

import umc7th.spring_study.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
