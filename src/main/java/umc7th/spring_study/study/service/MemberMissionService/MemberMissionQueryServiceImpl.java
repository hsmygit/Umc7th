package umc7th.spring_study.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.mapping.MemberMission;
import umc7th.spring_study.study.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> getInProgressMissions(Long memberId, String cursorValue) {
        return memberMissionRepository.findInProgressMissions(memberId, cursorValue);
    }

    @Override
    public List<MemberMission> getCompletedMissions(Long memberId, String cursorValue) {
        return memberMissionRepository.findCompletedMissions(memberId, cursorValue);
    }

    @Override
    public List<Mission> findAvailableMissionsByRegion(Long memberId, Long regionId, Long cursorValue) {
        return memberMissionRepository.findAvailableMissionsByRegion(memberId, regionId, cursorValue);
    }
}
