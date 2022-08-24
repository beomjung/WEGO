package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userInfo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude={"file"})
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSeq; // 사용자 식별 번호

    @Column(unique = true, length = 10)
    @NotNull
    private String userId; // 사용자 아이디


    @Column(length = 500)
    private String userPassword;

    @Column(length = 128)
    private String userEmail;

    @Column(length = 10)
    private String userName;

    @Column(length = 10)
    private String userNickname;

    @Column(length = 3)
    private int userAge;

    @Column(length = 100)
    private String userAddress;

    @Column(length = 4)
    private String userGender;


    @Column(length = 100)
    private String userIntroduction;

    @Column
    private Date memberSince;

    @Column(length = 30)
    private String roomKey;


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
