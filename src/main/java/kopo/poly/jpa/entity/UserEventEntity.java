package kopo.poly.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Table(name = "userEvent")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude={"user"})
@Builder
public class UserEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String eventSeq;

    @Column(length = 10)
    private String eventStartDate;

    @Column(length = 10)
    private String eventEndDate;

    @Column(length = 20)
    private String eventName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private UserEntity user;
}
