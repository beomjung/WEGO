package kopo.poly.mapper;

import kopo.poly.dto.BoardCommentDto;
import kopo.poly.jpa.entity.BoardCommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */
@Mapper
public interface BoardCommentMapper {
    BoardCommentMapper INSTANCE = Mappers.getMapper(BoardCommentMapper.class);

    @Mapping(target = "board", ignore = true)
    BoardCommentDto boardCommentEntityToBoardCommentDto(BoardCommentEntity boardCommentEntity);

    BoardCommentEntity boardCommentDtoToBoardCommentEntity(BoardCommentDto boardCommentDto);
}
