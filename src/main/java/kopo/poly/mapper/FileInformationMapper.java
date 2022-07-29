package kopo.poly.mapper;

import kopo.poly.dto.FileInformationDto;
import kopo.poly.jpa.entity.FileInformationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileInformationMapper {
    FileInformationMapper INSTANCE = Mappers.getMapper(FileInformationMapper.class);

    FileInformationDto fileInformationEntityToFileInformationDto(FileInformationEntity fileInformationEntity);

    FileInformationEntity fileInformationDtoToFileInformationEntity(FileInformationDto fileInformationDto);
}
