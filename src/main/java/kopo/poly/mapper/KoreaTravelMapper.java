package kopo.poly.mapper;

import kopo.poly.dto.KoreaTravelDto;
import kopo.poly.jpa.entity.KoreaTravelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KoreaTravelMapper {
    KoreaTravelMapper INSTANCE = Mappers.getMapper(KoreaTravelMapper.class);

    KoreaTravelDto koreaTravelEntityToKoreaTravelDto(KoreaTravelEntity koreaTravelEntity);

    KoreaTravelEntity koreaTravelDtoToKoreaTravelEntity(KoreaTravelDto koreaTravelDto);
}
