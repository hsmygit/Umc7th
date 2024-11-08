package umc7th.spring_study.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc7th.spring_study.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
}
