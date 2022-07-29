package kopo.poly.dto;

import kopo.poly.jpa.entity.UserEntity;
import lombok.Data;

@Data
public class UserInterestDto {
    private Integer userInterestSeq;
    private String userInterestContent;

    private UserEntity user;
}
