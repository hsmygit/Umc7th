package umc7th.spring_study.study.repository.StoreRepository;

import umc7th.spring_study.study.domain.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
