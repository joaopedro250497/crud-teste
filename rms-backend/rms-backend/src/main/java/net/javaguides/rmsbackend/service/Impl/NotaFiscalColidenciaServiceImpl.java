package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaDto;
import net.javaguides.rmsbackend.entity.NotaFiscalColidencia;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.NotaFiscalColidenciaMapper;
import net.javaguides.rmsbackend.repository.NotaFiscalColidenciaRepository;
import net.javaguides.rmsbackend.service.NotaFiscalColidenciaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotaFiscalColidenciaServiceImpl implements NotaFiscalColidenciaService {

    private NotaFiscalColidenciaRepository notaFiscalColidenciaRepository;

    @Override
    public NotaFiscalColidenciaDto createNotaFiscalColidencia(NotaFiscalColidenciaDto notaFiscalColidenciaDto) {

        NotaFiscalColidencia notaFiscalColidencia = NotaFiscalColidenciaMapper.mapToNotaFiscalColidencia(notaFiscalColidenciaDto);
        NotaFiscalColidencia savedNotaFiscalColidencia = notaFiscalColidenciaRepository.save(notaFiscalColidencia);
        return NotaFiscalColidenciaMapper.mapToNotaFiscalColidenciaDto(savedNotaFiscalColidencia);
    }

    @Override
    public NotaFiscalColidenciaDto getNotaFiscalColidenciaById(Long notaFiscalColidenciaId) {
        NotaFiscalColidencia notaFiscalColidencia = notaFiscalColidenciaRepository.findById(notaFiscalColidenciaId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Nota Fiscal Colidência inexistente pelo ID fornecido: " + notaFiscalColidenciaId));
        return NotaFiscalColidenciaMapper.mapToNotaFiscalColidenciaDto(notaFiscalColidencia);
    }

    @Override
    public List<NotaFiscalColidenciaDto> getAllNotaFiscalColidencia() {
        List<NotaFiscalColidencia> notaFiscalColidencias = notaFiscalColidenciaRepository.findAll();
        return notaFiscalColidencias.stream().map((notaFiscalColidencia) -> NotaFiscalColidenciaMapper.mapToNotaFiscalColidenciaDto(notaFiscalColidencia))
                .collect(Collectors.toList());
    }

    @Override
    public NotaFiscalColidenciaDto updateNotaFiscalColidencia(Long notaFiscalColidenciaId, NotaFiscalColidenciaDto updatedNotaFiscalColidencia) {

        NotaFiscalColidencia notaFiscalColidencia = notaFiscalColidenciaRepository.findById(notaFiscalColidenciaId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal Colidência inexistente pelo ID fornecido: " + notaFiscalColidenciaId)
        );


        notaFiscalColidencia.setSituacao(updatedNotaFiscalColidencia.getSituacao());
        notaFiscalColidencia.setDataOcorrencia(updatedNotaFiscalColidencia.getDataOcorrencia());
        notaFiscalColidencia.setDataResolucao(updatedNotaFiscalColidencia.getDataResolucao());
        notaFiscalColidencia.setObservacao(updatedNotaFiscalColidencia.getObservacao());

        NotaFiscalColidencia updatedNotaFiscalColidenciaObj = notaFiscalColidenciaRepository.save(notaFiscalColidencia);

        return NotaFiscalColidenciaMapper.mapToNotaFiscalColidenciaDto(updatedNotaFiscalColidenciaObj);
    }

    @Override
    public void deleteNotaFiscalColidencia(Long notaFiscalColidenciaId) {

        NotaFiscalColidencia notaFiscalColidencia = notaFiscalColidenciaRepository.findById(notaFiscalColidenciaId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal Colidência inexistente pelo ID fornecido: " + notaFiscalColidenciaId)
        );

        notaFiscalColidenciaRepository.deleteById(notaFiscalColidenciaId);
    }
}
