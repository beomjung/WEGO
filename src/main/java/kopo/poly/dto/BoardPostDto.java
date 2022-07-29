package kopo.poly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kopo.poly.jpa.entity.TravelBoardEntity;
import lombok.Data;


@Data
public class BoardPostDto {
    private Integer boardPostSeq;
    private Integer fileSeq;
    private Integer userSeq;
    private String boardPostContent;
    private String boardPostTitle;
    private String boardPostStar;
    private String boardPostHashtag;
    private String boardPostPosition;
    private String areaCode;
    private String detailAreaCode;

    private TravelBoardEntity board;
}
