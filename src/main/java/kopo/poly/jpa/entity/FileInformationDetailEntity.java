package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table(name = "fileInformationDetail")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@ToString(exclude={"file"})
@Builder
public class FileInformationDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileDetailSeq;

    @Column(length = 30)
    private String fileDetailName;

    @Column(length = 200)
    private String fileDetailPath;

    @Column(length = 100)
    private String fileDetailOrgName;

    @Column(length = 5)
    private String fileDetailExt;

    @Column(length = 50)
    private String fileDetailPosition;

    @Column(length = 10)
    private String fileDetailRegId;

    @Column
    private Date fileDetailRegDt;

    @Column(length = 10)
    private String fileDetailChgId;

    @Column
    private Date fileDetailChgDt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private FileInformationEntity file;
}


