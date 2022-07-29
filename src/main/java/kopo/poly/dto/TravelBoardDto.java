package kopo.poly.dto;

import kopo.poly.jpa.entity.BoardCommentEntity;
import kopo.poly.jpa.entity.BoardPostEntity;
import kopo.poly.jpa.entity.UserEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TravelBoardDto {
    private Integer boardSeq;
    private String boardEndDay;
    private String boardStartDay;
    private String notification;
    private int boardViews;
    private int boardLike;
    private String boardRegId;
    private Date boardRegDt;
    private String boardChgId;
    private Date boardChgDt;

    private UserEntity user;

    private List<BoardCommentEntity> comments;
    private List<BoardPostEntity> posts;
}
