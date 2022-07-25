package kopo.poly.jpa.entity;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "nlpTravel")
@AllArgsConstructor
@NoArgsConstructor
public class NlpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nlpSeq;

    @Column(length = 30)
    @NotNull
    private String nlpResult;

    @Column(length = 30)
    @NotNull
    private String nlpGender;

    @Column(length = 30)
    @NotNull
    private String nlpAge;

    @Column(length = 4000)
    @NotNull
    private String nlpContent;

    @Column(length = 100)
    @NotNull
    private String nlpAddress;


    @Column(length = 30)
    @NotNull
    private String detailAreaCode;

    @Column(length = 30)
    private String areaCode;
}
