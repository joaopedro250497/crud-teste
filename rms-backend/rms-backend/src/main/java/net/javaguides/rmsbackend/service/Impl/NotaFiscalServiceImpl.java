package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalDto;
import net.javaguides.rmsbackend.entity.NotaFiscal;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.NotaFiscalMapper;
import net.javaguides.rmsbackend.repository.NotaFiscalRepository;
import net.javaguides.rmsbackend.service.NotaFiscalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotaFiscalServiceImpl implements NotaFiscalService {

    private NotaFiscalRepository notaFiscalRepository;

    @Override
    public NotaFiscalDto createNotaFiscal(NotaFiscalDto notaFiscalDto) {

        NotaFiscal notaFiscal = NotaFiscalMapper.mapToNotaFiscal(notaFiscalDto);
        NotaFiscal savedNotaFiscal = notaFiscalRepository.save(notaFiscal);
        return NotaFiscalMapper.mapToNotaFiscalDto(savedNotaFiscal);
    }

    @Override
    public NotaFiscalDto getNotaFiscalById(Long notaFiscalId) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(notaFiscalId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Nota Fiscal inexistente pelo ID fornecido: " + notaFiscalId));
        return NotaFiscalMapper.mapToNotaFiscalDto(notaFiscal);
    }

    @Override
    public List<NotaFiscalDto> getAllNotaFiscal() {
        List<NotaFiscal> notaFiscals = notaFiscalRepository.findAll();
        return notaFiscals.stream().map((notaFiscal) -> NotaFiscalMapper.mapToNotaFiscalDto(notaFiscal))
                .collect(Collectors.toList());
    }

    @Override
    public NotaFiscalDto updateNotaFiscal(Long notaFiscalId, NotaFiscalDto updatedNotaFiscal) {

        NotaFiscal notaFiscal = notaFiscalRepository.findById(notaFiscalId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal inexistente pelo ID fornecido: " + notaFiscalId)
        );


        notaFiscal.setSituacao(updatedNotaFiscal.getSituacao());
        notaFiscal.setDataLancamento(updatedNotaFiscal.getDataLancamento());
        notaFiscal.setDataEmissao(updatedNotaFiscal.getDataEmissao());
        notaFiscal.setDataCancelamento(updatedNotaFiscal.getDataCancelamento());
        notaFiscal.setChave(updatedNotaFiscal.getChave());
        notaFiscal.setNumero(updatedNotaFiscal.getNumero());
        notaFiscal.setValorTotal(updatedNotaFiscal.getValorTotal());
        notaFiscal.setQuantidadeTotal(updatedNotaFiscal.getQuantidadeTotal());
        notaFiscal.setNaturezaOperacao(updatedNotaFiscal.getNaturezaOperacao());
        notaFiscal.setTipoOperacao(updatedNotaFiscal.getTipoOperacao());
        notaFiscal.setModelo(updatedNotaFiscal.getModelo());
        notaFiscal.setSerie(updatedNotaFiscal.getSerie());
        notaFiscal.setVerificadorCentralId(updatedNotaFiscal.getVerificadorCentralId());
        notaFiscal.setSituacaoVerificadorCentral(updatedNotaFiscal.getSituacaoVerificadorCentral());
        notaFiscal.setDataEnvioVerificadorCentral(updatedNotaFiscal.getDataEnvioVerificadorCentral());

        NotaFiscal updatedNotaFiscalObj = notaFiscalRepository.save(notaFiscal);

        return NotaFiscalMapper.mapToNotaFiscalDto(updatedNotaFiscalObj);
    }

    @Override
    public void deleteNotaFiscal(Long notaFiscalId) {

        NotaFiscal notaFiscal = notaFiscalRepository.findById(notaFiscalId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal inexistente pelo ID fornecido: " + notaFiscalId)
        );

        notaFiscalRepository.deleteById(notaFiscalId);
    }
}
