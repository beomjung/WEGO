package kopo.poly.mapper;

import kopo.poly.dto.TravelBoardDto;
import kopo.poly.dto.UserEventDTO;
import kopo.poly.jpa.entity.TravelBoardEntity;
import kopo.poly.jpa.entity.UserEventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEventMapper {
    UserEventMapper INSTANCE = Mappers.getMapper(UserEventMapper.class);

    @Mapping(target = "user", ignore = true)
    UserEventDTO userEventEntityToUserEventDTO(UserEventEntity userEventEntity);

    UserEventEntity userEventDTOToUserEventEntity(UserEventDTO userEventDTO);
}
