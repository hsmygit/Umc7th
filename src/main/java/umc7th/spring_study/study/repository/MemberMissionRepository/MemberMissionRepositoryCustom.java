package umc7th.spring_study.study.repository.MemberMissionRepository;

import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findInProgressMissions(Long MemberId, String cursorValue);
    List<MemberMission> findCompletedMissions(Long MemberId, String cursorValue);
    List<Mission> findAvailableMissionsByRegion(Long memberId, Long regionId, Long cursorValue);
}