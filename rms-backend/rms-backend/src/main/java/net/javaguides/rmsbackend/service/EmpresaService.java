package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.EmpresaDto;

import java.util.List;

public interface EmpresaService {
    EmpresaDto createEmpresa(EmpresaDto empresaDto);

    EmpresaDto getEmpresaById(Long empresaId);

    List<EmpresaDto> getAllEmpresas();

    EmpresaDto updateEmpresa(Long empresaId, EmpresaDto updatedEmpresa);

    void deleteEmpresa(Long empresaId);
}
