package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.MunicipioDto;
import net.javaguides.rmsbackend.entity.Municipio;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.MunicipioMapper;
import net.javaguides.rmsbackend.repository.MunicipioRepository;
import net.javaguides.rmsbackend.service.MunicipioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MunicipioServiceImpl implements MunicipioService {

    private MunicipioRepository municipioRepository;

    @Override
    public MunicipioDto createMunicipio(MunicipioDto municipioDto) {

        Municipio municipio = MunicipioMapper.mapToMunicipio(municipioDto);
        Municipio savedMunicipio = municipioRepository.save(municipio);
        return MunicipioMapper.mapToMunicipioDto(savedMunicipio);
    }

    @Override
    public MunicipioDto getMunicipioById(Long municipioId) {
        Municipio municipio = municipioRepository.findById(municipioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Município inexistente pelo ID fornecido: " + municipioId));
        return MunicipioMapper.mapToMunicipioDto(municipio);
    }

    @Override
    public List<MunicipioDto> getAllMunicipio() {
        List<Municipio> municipios = municipioRepository.findAll();
        return municipios.stream().map((municipio) -> MunicipioMapper.mapToMunicipioDto(municipio))
                .collect(Collectors.toList());
    }

    @Override
    public MunicipioDto updateMunicipio(Long municipioId, MunicipioDto updatedMunicipio) {

        Municipio municipio = municipioRepository.findById(municipioId).orElseThrow(
                () -> new ResourceNotFoundException("Município inexistente pelo ID fornecido: " + municipioId)
        );


        municipio.setDescricao(updatedMunicipio.getDescricao());

        Municipio updatedMunicipioObj = municipioRepository.save(municipio);

        return MunicipioMapper.mapToMunicipioDto(updatedMunicipioObj);
    }

    @Override
    public void deleteMunicipio(Long municipioId) {

        Municipio municipio = municipioRepository.findById(municipioId).orElseThrow(
                () -> new ResourceNotFoundException("Município inexistente pelo ID fornecido: " + municipioId)
        );

        municipioRepository.deleteById(municipioId);
    }
}
