package kopo.poly.jpa;

import kopo.poly.jpa.entity.FileInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FileInformationRepository extends JpaRepository<FileInformationEntity, Integer> {
}
