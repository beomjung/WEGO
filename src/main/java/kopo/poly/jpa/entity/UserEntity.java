package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userInfo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude={"file"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSeq; // 사용자 식별 번호

    @Column(unique = true, length = 10)
    @NotNull
    private String userId; // 사용자 아이디


    @Column(length = 500)
    private String userPassword;


    // TODO: 2022/07/21 need to Add Columns


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private FileInformationEntity file;

    @OneToMany(mappedBy = "user")
    private List<FollowEntity> followers;

    @OneToMany(mappedBy = "user")
    private List<UserInterestEntity> userInterests;

    @OneToMany(mappedBy = "user")
    private List<TravelBoardEntity> travelBoards;

}
