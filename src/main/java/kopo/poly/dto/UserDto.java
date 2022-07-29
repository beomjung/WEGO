package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import kopo.poly.jpa.entity.FileInformationEntity;
import kopo.poly.jpa.entity.FollowEntity;
import kopo.poly.jpa.entity.TravelBoardEntity;
import kopo.poly.jpa.entity.UserInterestEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
public class UserDto {
    private Integer userSeq; // 사용자 식별 번호
    private String userId; // 사용자 아이디
    private String userPassword;
    private String userEmail;
    private String userName;
    private String userNickname;
    private int userAge;
    private String userAddress;
    private String userGender;
    private String userIntroduction;
    private Date memberSince;
    private String roomKey;

    private FileInformationEntity file;

    private List<FollowEntity> followers;
    private List<UserInterestEntity> userInterests;
    private List<TravelBoardEntity> travelBoards;
}
