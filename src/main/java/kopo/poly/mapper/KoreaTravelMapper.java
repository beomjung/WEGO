package kopo.poly.mapper;

import kopo.poly.dto.KoreaTravelDto;
import kopo.poly.jpa.entity.KoreaTravelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DtoToEntity or EntityToDto
 * Builder 사용해도 동작
 */

@Mapper
public interface KoreaTravelMapper {
    KoreaTravelMapper INSTANCE = Mappers.getMapper(KoreaTravelMapper.class);

    KoreaTravelDto koreaTravelEntityToKoreaTravelDto(KoreaTravelEntity koreaTravelEntity);

    KoreaTravelEntity koreaTravelDtoToKoreaTravelEntity(KoreaTravelDto koreaTravelDto);
}
