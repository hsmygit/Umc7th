package umc7th.spring_study.study.repository.MemberMissionRepository;

import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.QMission;
import umc7th.spring_study.study.domain.QRegion;
import umc7th.spring_study.study.domain.QStore;
import umc7th.spring_study.study.domain.enums.MissionStatus;
import umc7th.spring_study.study.domain.mapping.MemberMission;
import umc7th.spring_study.study.domain.mapping.QMemberMission;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMission> findInProgressMissions(Long MemberId, String cursorValue) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore restaurant = QStore.store;

        return queryFactory
                .selectFrom(memberMission)
                .join(memberMission.mission, mission).fetchJoin()
                .join(mission.store, restaurant).fetchJoin()
                .where(
                        memberMission.member.id.eq(MemberId),
                        memberMission.status.eq(MissionStatus.CHALLENGING),
                        concatCursorValue(memberMission.createdAt, memberMission.id).lt(cursorValue)
                )
                .orderBy(memberMission.createdAt.desc(), memberMission.id.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<MemberMission> findCompletedMissions(Long userId, String cursorValue) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;
        QStore restaurant = QStore.store;

        return queryFactory
                .selectFrom(memberMission)
                .join(memberMission.mission, mission).fetchJoin()
                .join(mission.store, restaurant).fetchJoin()
                .where(
                        memberMission.member.id.eq(userId),
                        memberMission.status.eq(MissionStatus.COMPLETED),
                        concatCursorValue(memberMission.updatedAt, memberMission.id).lt(cursorValue)
                )
                .orderBy(memberMission.updatedAt.desc(), memberMission.id.desc())
                .limit(10)
                .fetch();
    }

    private StringExpression concatCursorValue(DateTimePath<LocalDateTime> date, NumberPath<Long> id) {
        // LocalDateTime을 String으로 변환
        StringExpression formattedDate = Expressions.stringTemplate(
                "CAST(DATE_FORMAT({0}, '%Y%m%d%H%i%s') AS STRING)", date
        );

        // ID를 String으로 캐스팅하여 LPAD 적용
        StringExpression formattedId = Expressions.stringTemplate(
                "LPAD(CAST({0} AS STRING), 10, '0')", id
        );

        return Expressions.stringTemplate(
                "CONCAT(LPAD({0}, 20, '0'), LPAD({1}, 10, '0'))", formattedDate, formattedId
        );
    }
    @Override
    public List<Mission> findAvailableMissionsByRegion(Long memberId, Long regionId, Long cursorValue) {
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;
        QRegion region = QRegion.region;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin() // Store 엔티티를 즉시 로딩
                .join(store.region, region)
                .leftJoin(memberMission).on(
                        memberMission.mission.eq(mission)
                                .and(memberMission.member.id.eq(memberId))
                )
                .where(
                        region.id.eq(regionId),          // 선택된 지역 필터
                        memberMission.id.isNull(),       // 사용자가 도전하지 않은 미션
                        mission.id.lt(cursorValue)       // 커서 기반 페이징 조건
                )
                .orderBy(mission.id.desc())         // 커서 기준 정렬
                .limit(10)                          // 페이지 크기
                .fetch();
    }
}

