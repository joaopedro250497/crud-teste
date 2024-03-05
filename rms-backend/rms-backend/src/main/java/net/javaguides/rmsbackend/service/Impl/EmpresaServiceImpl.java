package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.EmpresaDto;
import net.javaguides.rmsbackend.entity.Empresa;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.EmpresaMapper;
import net.javaguides.rmsbackend.repository.EmpresaRepository;
import net.javaguides.rmsbackend.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaDto createEmpresa(EmpresaDto empresaDto) {

        Empresa empresa = EmpresaMapper.mapToEmpresa(empresaDto);
        Empresa savedEmpresa = empresaRepository.save(empresa);
        return EmpresaMapper.mapToEmpresaDto(savedEmpresa);
    }

    @Override
    public EmpresaDto getEmpresaById(Long empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Empresa inexistente pelo ID fornecido: " + empresaId));
        return EmpresaMapper.mapToEmpresaDto(empresa);
    }

    @Override
    public List<EmpresaDto> getAllEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream().map((empresa) -> EmpresaMapper.mapToEmpresaDto(empresa))
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaDto updateEmpresa(Long empresaId, EmpresaDto updatedEmpresa) {

         Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(
                () -> new ResourceNotFoundException("Empresa inexistente pelo ID fornecido: " + empresaId)
        );


        empresa.setCnpj(updatedEmpresa.getCnpj());
        empresa.setRazaoSocial(updatedEmpresa.getRazaoSocial());
        empresa.setNomeFantasia(updatedEmpresa.getNomeFantasia());
        empresa.setInscricaoEstadual(updatedEmpresa.getInscricaoEstadual());

        Empresa updatedEmpresaObj = empresaRepository.save(empresa);

        return EmpresaMapper.mapToEmpresaDto(updatedEmpresaObj);
    }

    @Override
    public void deleteEmpresa(Long empresaId) {

        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(
                () -> new ResourceNotFoundException("Empresa inexistente pelo ID fornecido: " + empresaId)
        );

        empresaRepository.deleteById(empresaId);
    }
}
