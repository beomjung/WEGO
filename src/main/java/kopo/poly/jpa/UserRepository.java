package kopo.poly.jpa;

import kopo.poly.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserId(final String userId);

    Optional<UserEntity> findByUserNickname(final String userNickName);
}
