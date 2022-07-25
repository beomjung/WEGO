package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "fileInformation")
@Getter
public class FileInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileSeq;

    @Column(length = 100)
    private String fileCode;

    @OneToMany(mappedBy = "file")
    private List<UserEntity> users;

    @OneToMany(mappedBy = "file")
    private List<FileInformationDetailEntity> FileInformationDetails;
}
