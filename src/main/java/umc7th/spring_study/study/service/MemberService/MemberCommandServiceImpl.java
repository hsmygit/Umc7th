package umc7th.spring_study.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc7th.spring_study.study.apiPayload.code.status.ErrorStatus;
import umc7th.spring_study.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc7th.spring_study.study.converter.MemberConverter;
import umc7th.spring_study.study.converter.MemberPreferConverter;
import umc7th.spring_study.study.domain.FoodCategory;
import umc7th.spring_study.study.domain.Member;
import umc7th.spring_study.study.domain.mapping.MemberPrefer;
import umc7th.spring_study.study.repository.FoodCategoryRepository;
import umc7th.spring_study.study.repository.MemberRepository.MemberRepository;
import umc7th.spring_study.study.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}

