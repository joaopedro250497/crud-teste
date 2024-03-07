package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.MunicipioDto;

import java.util.List;

public interface MunicipioService {
    MunicipioDto createMunicipio(MunicipioDto municipioDto);

    MunicipioDto getMunicipioById(Long municipioId);

    List<MunicipioDto> getAllMunicipio();

    MunicipioDto updateMunicipio(Long municipioId, MunicipioDto updatedMunicipio);

    void deleteMunicipio(Long municipioId);
}
