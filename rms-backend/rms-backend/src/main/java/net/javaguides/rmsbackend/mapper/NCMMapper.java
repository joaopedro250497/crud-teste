package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.NCMDto;
import net.javaguides.rmsbackend.entity.NCM;

public class NCMMapper {

    public static NCMDto mapToNCMDto(NCM ncm){
        return new NCMDto(
                ncm.getId(),
                ncm.getDescricao(),
                ncm.getClassificacao()
        );
    }

    public static NCM mapToNCM(NCMDto ncmDto){
        return new NCM(
                ncmDto.getId(),
                ncmDto.getDescricao(),
                ncmDto.getClassificacao()
        );
    }
}
