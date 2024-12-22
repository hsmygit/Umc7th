package umc7th.spring_study.study.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc7th.spring_study.study.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 기본 CRUD 메서드(findById 등)를 활용해 Member 정보 조회 가능

    @Query("SELECT m.is_phone_verified FROM Member m WHERE m.id = :memberId")
    Boolean findIsPhoneVerifiedById(@Param("memberId") Long memberId);
    // 전화번호 인증 상태 조회

}
