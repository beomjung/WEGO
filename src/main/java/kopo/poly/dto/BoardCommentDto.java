package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kopo.poly.jpa.entity.TravelBoardEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class BoardCommentDto {
    private Integer commentSeq;
    private Integer userSeq;
    private String commentContents;
    private String commentRegId;
    private Date commentRegDt;
    private String commentChgId;
    private Date commentChgDt;

    private TravelBoardEntity board;
}
