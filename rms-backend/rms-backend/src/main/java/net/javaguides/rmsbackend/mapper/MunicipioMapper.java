package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.MunicipioDto;
import net.javaguides.rmsbackend.entity.Municipio;

public class MunicipioMapper {

    public static MunicipioDto mapToMunicipioDto(Municipio municipio){
        return new MunicipioDto(
                municipio.getId(),
                municipio.getDescricao()
        );
    }

    public static Municipio mapToMunicipio(MunicipioDto municipioDto){
        return new Municipio(
                municipioDto.getId(),
                municipioDto.getDescricao()
        );
    }
}
