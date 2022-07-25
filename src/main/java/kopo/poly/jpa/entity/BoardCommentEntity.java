package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude={"board"})
@Table(name = "boardComment")
public class BoardCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentSeq;

    @Column
    private Integer userSeq;

    @Column
    private String commentContents;

    @Column
    private String commentRegId;

    @Column
    private Date commentRegDt;

    @Column
    private String commentChgId;

    @Column
    private Date commentChgDt;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TravelBoardEntity board;
}


