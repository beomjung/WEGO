package kopo.poly.mapper;

import kopo.poly.dto.BookMarkDto;
import kopo.poly.jpa.entity.BookMarkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMarkMapper {
    BookMarkMapper INSTANCE = Mappers.getMapper(BookMarkMapper.class);

    BookMarkDto bookMarkEntityToBookMarkDto(BookMarkEntity bookMarkEntity);

    BookMarkEntity bookMarkDtoToBookMarkEntity(BookMarkDto bookMarkDto);
}
