package umc7th.spring_study.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.spring_study.study.domain.Member;
import umc7th.spring_study.study.repository.MemberRepository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMemberById(Long memberId) {
//        return memberRepository.findById(memberId);  // ID로 사용자 정보 조회
        Optional<Member> member = memberRepository.findById(memberId);  // ID로 사용자 정보 조회

        // Optional이 값이 있는 경우에 toString()을 사용해 출력
        member.ifPresent(value -> System.out.println("Member info: " + value)); // toString() 자동 호출

        return member;
    }
    @Override
    public Boolean findPhoneVerificationStatus(Long memberId) {
        return memberRepository.findIsPhoneVerifiedById(memberId); // 전화번호 인증 상태 조회
    }
}