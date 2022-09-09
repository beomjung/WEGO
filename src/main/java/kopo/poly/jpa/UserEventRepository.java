package kopo.poly.jpa;

import kopo.poly.jpa.entity.UserEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface UserEventRepository extends JpaRepository<UserEventEntity, Integer> {

    Optional<List<UserEventEntity>> findByUserId(final String userId);

    Optional<UserEventEntity> findByEventSeq(final Integer eventSeq);


}
