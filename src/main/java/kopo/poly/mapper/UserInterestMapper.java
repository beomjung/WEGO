package kopo.poly.mapper;

import kopo.poly.dto.UserInterestDto;
import kopo.poly.jpa.entity.UserInterestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */

@Mapper
public interface UserInterestMapper {
    UserInterestMapper INSTANCE = Mappers.getMapper(UserInterestMapper.class);

    @Mapping(target = "user", ignore = true)
    UserInterestDto userInterestEntityToUserDto(UserInterestEntity userInterestEntity);

    UserInterestEntity userInterestDtoToUserInterestEntity(UserInterestDto userInterestDto);
}
