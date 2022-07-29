package kopo.poly.dto;

import lombok.Data;

@Data
public class BookMarkDto {
    private Integer bookmarkSeq;
    private Integer userSeq;
    private Integer boardSeq;
    private Integer boardUserSeq;
}
