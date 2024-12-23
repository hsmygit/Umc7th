package umc7th.spring_study.study.service.MemberService;

import umc7th.spring_study.study.domain.Member;
import umc7th.spring_study.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
