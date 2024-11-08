package umc7th.spring_study.study.service.MemberService;

import umc7th.spring_study.study.domain.Member;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMemberById(Long memberId); // 사용자 ID로 사용자 조회

    Boolean findPhoneVerificationStatus(Long memberId); // 전화번호 인증 상태 조회
}
