package kopo.poly.mapper;

import kopo.poly.dto.FollowDto;
import kopo.poly.jpa.entity.FollowEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FollowMapper {
    FollowMapper INSTANCE = Mappers.getMapper(FollowMapper.class);

    @Mapping(target = "user", ignore = true)
    FollowDto followEntityToFollowDto(FollowEntity followEntity);

    FollowEntity followDtoToFollowEntity(FollowDto followDto);

}
