package umc7th.spring_study.study.service.MemberMissionService;

import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getInProgressMissions(Long memberId, String cursorValue);
    List<MemberMission> getCompletedMissions(Long memberId, String cursorValue);
    List<Mission> findAvailableMissionsByRegion(Long memberId, Long regionId, Long cursorValue);
}
