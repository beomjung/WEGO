package kopo.poly.jpa;

import kopo.poly.jpa.entity.UserEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserEventRepository extends JpaRepository<UserEventEntity, Integer> {
}
