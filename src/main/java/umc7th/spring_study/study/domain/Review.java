package umc7th.spring_study.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc7th.spring_study.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    private Float score;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> ReviewImageList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", score=" + score +
                ", member=" + (member != null ? member.getName() : "N/A") + // user의 이름 출력
                ", store=" + (store != null ? store.getName() : "N/A") + // store의 이름 출력
                '}';
    }
}
