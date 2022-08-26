package kopo.poly.mapper;

import kopo.poly.dto.FileInformationDto;
import kopo.poly.jpa.entity.FileInformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */

@Mapper
public interface FileInformationMapper {
    FileInformationMapper INSTANCE = Mappers.getMapper(FileInformationMapper.class);

    FileInformationDto fileInformationEntityToFileInformationDto(FileInformationEntity fileInformationEntity);

    FileInformationEntity fileInformationDtoToFileInformationEntity(FileInformationDto fileInformationDto);
}
