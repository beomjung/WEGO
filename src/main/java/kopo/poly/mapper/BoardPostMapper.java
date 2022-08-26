package kopo.poly.mapper;

import kopo.poly.dto.BoardPostDto;
import kopo.poly.jpa.entity.BoardPostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */
@Mapper
public interface BoardPostMapper {
    BoardPostMapper INSTANCE = Mappers.getMapper(BoardPostMapper.class);

    @Mapping(target = "board", ignore = true)
    BoardPostDto boardPostEntityToBoardPostDto(BoardPostEntity boardPostEntity);

    BoardPostEntity boardPostDtoToBoardPostEntity(BoardPostDto boardPostDto);
}
