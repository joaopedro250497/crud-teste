package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.UnidadeDto;
import net.javaguides.rmsbackend.entity.Unidade;

public class UnidadeMapper {

    public static UnidadeDto mapToUnidadeDto(Unidade unidade){
        return new UnidadeDto(
                unidade.getId(),
                unidade.getSigla()
        );
    }

    public static Unidade mapToUnidade(UnidadeDto unidadeDto){
        return new Unidade(
                unidadeDto.getId(),
                unidadeDto.getSigla()
        );
    }
}
