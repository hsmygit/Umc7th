package umc7th.spring_study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc7th.spring_study.study.domain.Member;
import umc7th.spring_study.study.domain.Mission;
import umc7th.spring_study.study.domain.Review;
import umc7th.spring_study.study.domain.Store;
import umc7th.spring_study.study.domain.mapping.MemberMission;
import umc7th.spring_study.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc7th.spring_study.study.repository.MemberRepository.MemberRepository;
import umc7th.spring_study.study.repository.StoreRepository.StoreRepository;
import umc7th.spring_study.study.service.MemberMissionService.MemberMissionQueryService;
import umc7th.spring_study.study.service.MemberService.MemberQueryService;
import umc7th.spring_study.study.service.ReviewService.ReviewQueryService;
import umc7th.spring_study.study.service.StoreService.StoreQueryService;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(StoreQueryService storeService
//			, ReviewQueryService reviewService
//			, MemberQueryService memberQueryService
//			, MemberMissionQueryService memberMissionQueryService
//			, MemberRepository memberRepository
//			, StoreRepository storeRepository) {
//		return args -> {
//
//			String name = "요아정"; // 예시 가게 이름
//			Float score = 4.0f; // 예시 가게 점수
//			Long memberId = 1L; // 예시 사용자 ID
//			Long storeId = 1L;  // 사용할 Store의 ID
//			Long regionId = 1L; // 예시 지역 ID
//			Long cursorValue = 9999999999L; // 예시 커서 벨류
//			String missionCursorValue = "9999999999L"; // 예시 커서 벨류
//
//			//리뷰 작성 테스트
//			// 1. Member와 Store 조회
//			Member member = memberRepository.findById(memberId)
//					.orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));
//			Store store = storeRepository.findById(storeId)
//					.orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));
//
//			// 3. Review 생성
//			Review review = Review.builder()
//					.body("This is a sample review")
//					.score(4.5f)
//					.member(member)
//					.store(store)
//					.build();
//
//			// 4. Review 저장
//			Review savedReview = reviewService.saveReview(review);
//
//			// 5. 저장된 Review 출력
//			System.out.println("Saved Review(app): " + savedReview);
//
//			// StoreQueryService 실행 테스트
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name, score)
//					.forEach(stores -> System.out.println("Store: " + stores));
//
//			// ReviewQueryService 실행 테스트
//			System.out.println("Executing findReviewsByUserWithPagination with parameters:");
//			System.out.println("User ID: " + memberId);
//			System.out.println("Cursor Value: " + cursorValue);
//
//			reviewService.findReviewsByUserWithPagination(memberId, cursorValue)
//					.forEach(reviews -> System.out.println("Review: " + reviews));
//
//			// MemberQueryService 실행 - 사용자 ID가 2인 사용자 정보 조회 테스트
//			System.out.println("Executing findMemberById with parameter: Member ID: " + memberId);
//
//			memberQueryService.findMemberById(memberId)
//					.ifPresent(members -> System.out.println("Member: " + members));  // 사용자 정보 출력
//
//			// 전화번호 인증 상태 조회 테스트
//			Boolean isPhoneVerified = memberQueryService.findPhoneVerificationStatus(memberId);
//			System.out.println("Phone verification status for member ID " + memberId + ": " + isPhoneVerified);
//
//			// 진행 중인 미션 조회 테스트
//			List<MemberMission> inProgressMissions = memberMissionQueryService.getInProgressMissions(memberId, missionCursorValue);
//			System.out.println("In-progress Missions:");
//			inProgressMissions.forEach(System.out::println);  // toString으로 출력
//
//			// 완료된 미션 조회 테스트
//			List<MemberMission> completedMissions = memberMissionQueryService.getCompletedMissions(memberId, missionCursorValue);
//			System.out.println("Completed Missions:");
//			completedMissions.forEach(System.out::println);  // toString으로 출력
//
//			//  지역 기반 진행 가능한 미션 조회 테스트
//			List<Mission> missions = memberMissionQueryService.findAvailableMissionsByRegion(memberId, regionId, cursorValue);
//			System.out.println("진행 가능한 Missions:");
//			for (Mission mission : missions) {
//				System.out.println(mission); //Mission의 toString() 출력
//			}
//		};
//	}
}