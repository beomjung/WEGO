package kopo.poly.dto;

import kopo.poly.jpa.entity.UserEntity;
import lombok.Data;

import java.util.Date;
@Data
public class FollowDto {
    private Integer follower;
    private Integer followee;
    private Date chgDt = new Date();

    private UserEntity user;
}
