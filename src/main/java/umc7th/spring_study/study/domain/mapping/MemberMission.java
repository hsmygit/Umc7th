package umc7th.spring_study.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc7th.spring_study.study.domain.Member;
import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.common.BaseEntity;
import umc7th.spring_study.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)DEFAULT 'ACTIVE'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
