package kopo.poly.mapper;

import kopo.poly.dto.FileInformationDetailDto;
import kopo.poly.dto.FileInformationDto;
import kopo.poly.jpa.entity.FileInformationDetailEntity;
import kopo.poly.jpa.entity.FileInformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */

@Mapper
public interface FileInformationDetailMapper {
    FileInformationDetailMapper INSTANCE = Mappers.getMapper(FileInformationDetailMapper.class);

    @Mapping(target = "file", ignore = true)
    FileInformationDetailDto fileInformationDetailEntityToFileInformationDetailDto(FileInformationDetailEntity fileInformationDetailEntity);

    FileInformationDetailEntity fileInformationDetailDtoToFileInformationDetailEntity(FileInformationDto fileInformationDto);
}
