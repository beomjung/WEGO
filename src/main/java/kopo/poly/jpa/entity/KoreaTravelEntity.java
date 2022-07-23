package kopo.poly.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "koreaTravel")
@AllArgsConstructor
@NoArgsConstructor
public class KoreaTravelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelSeq;

    @Column(length = 10)
    private int travelCost;

    @Column(length = 10)
    private String travelName;

    @Column(length = 1000)
    private String travelContent;

    @Column(length = 7)
    private String travelAddress;

    @Column(length = 50)
    private String travelAddress2;
}

