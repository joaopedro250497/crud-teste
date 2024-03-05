package net.javaguides.rmsbackend.mapper;

import net.javaguides.rmsbackend.dto.EmpresaDto;
import net.javaguides.rmsbackend.entity.Empresa;

public class EmpresaMapper {

    public static EmpresaDto mapToEmpresaDto(Empresa empresa){
        return new EmpresaDto(
                empresa.getId(),
                empresa.getCnpj(),
                empresa.getRazaoSocial(),
                empresa.getNomeFantasia(),
                empresa.getInscricaoEstadual()
        );
    }

    public static Empresa mapToEmpresa(EmpresaDto empresaDto){
        return new Empresa(
                empresaDto.getId(),
                empresaDto.getCnpj(),
                empresaDto.getRazaoSocial(),
                empresaDto.getNomeFantasia(),
                empresaDto.getInscricaoEstadual()
        );
    }
}