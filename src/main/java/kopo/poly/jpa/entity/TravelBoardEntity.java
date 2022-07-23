package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name = "travelBoard")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude={"user"})
public class TravelBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardSeq;

    @Column(length = 10)
    private String boardEndDay;

    @Column(length = 10)
    private String boardStartDay;

    @Column(length = 3)
    private String notification;

    @Column(length = 10)
    private int boardViews;

    @Column(length = 10)
    private int boardLike;

    @Column(length = 10)
    private String boardRegId;

    @Column
    private Date boardRegDt;

    @Column(length = 10)
    private String boardChgId;

    @Column
    private Date boardChgDt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private UserEntity user;

    @OneToMany(mappedBy = "board")
    private List<BoardCommentEntity> comments;


    @OneToMany(mappedBy = "board")
    private List<BoardPostEntity> posts;
}
