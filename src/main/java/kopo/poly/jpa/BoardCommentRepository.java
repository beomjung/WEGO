package kopo.poly.jpa;

import kopo.poly.jpa.entity.BoardCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BoardCommentRepository extends JpaRepository<BoardCommentEntity, Integer> {
}
