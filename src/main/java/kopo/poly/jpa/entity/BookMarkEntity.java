package kopo.poly.jpa.entity;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookMark")
public class BookMarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookmarkSeq;

    @Column(length = 10)
    @NotNull
    private Integer userSeq;

    @Column(length = 10)
    @NotNull
    private Integer boardSeq;

    @Column(length = 10)
    @NotNull
    private Integer boardUserSeq;
}
