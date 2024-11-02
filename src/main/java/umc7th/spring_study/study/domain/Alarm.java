package umc7th.spring_study.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc7th.spring_study.study.domain.common.BaseEntity;
import umc7th.spring_study.study.domain.enums.DataType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 30)
    private String title;

    private String body;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private DataType DType;
}
