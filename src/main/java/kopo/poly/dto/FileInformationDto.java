package kopo.poly.dto;

import kopo.poly.jpa.entity.FileInformationDetailEntity;
import kopo.poly.jpa.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class FileInformationDto {
    private Integer fileSeq;
    private String fileCode;

    private List<UserEntity> users;
    private List<FileInformationDetailEntity> FileInformationDetails;
}
