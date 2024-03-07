package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.EstadoDto;
import net.javaguides.rmsbackend.entity.Estado;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.EstadoMapper;
import net.javaguides.rmsbackend.repository.EstadoRepository;
import net.javaguides.rmsbackend.service.EstadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstadoServiceImpl implements EstadoService {

    private EstadoRepository estadoRepository;

    @Override
    public EstadoDto createEstado(EstadoDto estadoDto) {

        Estado estado = EstadoMapper.mapToEstado(estadoDto);
        Estado savedEstado = estadoRepository.save(estado);
        return EstadoMapper.mapToEstadoDto(savedEstado);
    }

    @Override
    public EstadoDto getEstadoById(Long estadoId) {
        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estado inexistente pelo ID fornecido: " + estadoId));
        return EstadoMapper.mapToEstadoDto(estado);
    }

    @Override
    public List<EstadoDto> getAllEstado() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream().map((estado) -> EstadoMapper.mapToEstadoDto(estado))
                .collect(Collectors.toList());
    }

    @Override
    public EstadoDto updateEstado(Long estadoId, EstadoDto updatedEstado) {

        Estado estado = estadoRepository.findById(estadoId).orElseThrow(
                () -> new ResourceNotFoundException("Estado inexistente pelo ID fornecido: " + estadoId)
        );


        estado.setDescricao(updatedEstado.getDescricao());

        Estado updatedEstadoObj = estadoRepository.save(estado);

        return EstadoMapper.mapToEstadoDto(updatedEstadoObj);
    }

    @Override
    public void deleteEstado(Long estadoId) {

        Estado estado = estadoRepository.findById(estadoId).orElseThrow(
                () -> new ResourceNotFoundException("Estado inexistente pelo ID fornecido: " + estadoId)
        );

        estadoRepository.deleteById(estadoId);
    }
}
