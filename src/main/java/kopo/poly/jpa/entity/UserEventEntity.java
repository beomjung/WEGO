package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "userEvent")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude={"user"})
@Builder
public class UserEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String eventSeq; //이벤트 식별 번호(자동생성)

    @Column(length = 10)
    private String eventStartDate; //이벤트 시작일

    @Column(length = 10)
    private String eventEndDate; //이벤트 종료일

    @Column(length = 20)
    private String eventName; //이벤트 제목

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private UserEntity user; //user Table과 1:N 매핑
}
