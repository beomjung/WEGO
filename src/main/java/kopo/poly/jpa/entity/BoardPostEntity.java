package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "boardPost")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude={"board"})
public class BoardPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardPostSeq;

    @Column(length = 10)
    private Integer fileSeq;

    @Column(length = 10)
    private Integer userSeq;

    @Column(length = 3000)
    private String boardPostContent;

    @Column(length = 30)
    private String boardPostTitle;

    @Column(length = 10)
    private String boardPostStar;

    @Column(length = 10)
    private String boardPostHashtag;

    @Column(length = 100)
    // TODO: 2022/07/29 need to Check Column Name
    private String boardPostPosition;

    @Column(length = 30)
    private String areaCode;

    @Column(length = 30)
    private String detailAreaCode;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TravelBoardEntity board;
}
