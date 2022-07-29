package kopo.poly.mapper;

import kopo.poly.dto.TravelBoardDto;
import kopo.poly.jpa.entity.TravelBoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TravelBoardMapper {
    TravelBoardMapper INSTANCE = Mappers.getMapper(TravelBoardMapper.class);

    @Mapping(target = "user", ignore = true)
    TravelBoardDto travelBoardEntityToTravelBoardDto(TravelBoardEntity travelBoardEntity);

    TravelBoardEntity travelBoardDtoToTravelBoardEntity(TravelBoardDto travelBoardDto);
}
