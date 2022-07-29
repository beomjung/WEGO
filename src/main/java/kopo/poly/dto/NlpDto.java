package kopo.poly.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class NlpDto {
    private Integer nlpSeq;
    private String nlpResult;
    private String nlpGender;
    private String nlpAge;
    private String nlpContent;
    private String nlpAddress;
    private String detailAreaCode;
    private String areaCode;
}
