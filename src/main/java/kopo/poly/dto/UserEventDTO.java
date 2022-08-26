package kopo.poly.dto;

import kopo.poly.jpa.entity.UserEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UserEventDTO {
    private Integer eventSeq; //이벤트 고유번호
    private String eventStartDate; //일정 시작일
    private String eventEndDate; //일정 종료일
    private String eventName; //일정 제목

    private UserEntity user;
}
