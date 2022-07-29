package kopo.poly.mapper;

import kopo.poly.dto.NlpDto;
import kopo.poly.jpa.entity.NlpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NlpMapper {
    NlpMapper INSTANCE = Mappers.getMapper(NlpMapper.class);

    NlpDto nlpEntityToNlpDto(NlpEntity nlpEntity);

    NlpEntity nlpDtoToNlpEntity(NlpDto nlpDto);
}
