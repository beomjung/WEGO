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
    // TODO: 2022/07/21 need to Add Columns
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TravelBoardEntity board;
}
