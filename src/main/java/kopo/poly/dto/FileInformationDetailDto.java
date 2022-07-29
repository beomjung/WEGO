package kopo.poly.dto;

import kopo.poly.jpa.entity.FileInformationEntity;
import lombok.Data;

import java.util.Date;
@Data
public class FileInformationDetailDto {
    private Integer fileDetailSeq;
    private String fileDetailName;
    private String fileDetailPath;
    private String fileDetailOrgName;
    private String fileDetailExt;
    private String fileDetailPosition;
    private String fileDetailRegId;
    private Date fileDetailRegDt;
    private String fileDetailChgId;
    private Date fileDetailChgDt;

    private FileInformationEntity file;
}
