package kopo.poly.mapper;

import kopo.poly.dto.UserInterestDto;
import kopo.poly.jpa.entity.UserInterestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInterestMapper {
    UserInterestMapper INSTANCE = Mappers.getMapper(UserInterestMapper.class);

    @Mapping(target = "user", ignore = true)
    UserInterestDto userInterestEntityToUserDto(UserInterestEntity userInterestEntity);

    UserInterestEntity userInterestDtoToUserInterestEntity(UserInterestDto userInterestDto);
}
