package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalColidenciaComunicacaoDto;
import net.javaguides.rmsbackend.entity.NotaFiscalColidenciaComunicacao;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.NotaFiscalColidenciaComunicacaoMapper;
import net.javaguides.rmsbackend.repository.NotaFiscalColidenciaComunicacaoRepository;
import net.javaguides.rmsbackend.service.NotaFiscalColidenciaComunicacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotaFiscalColidenciaComunicacaoServiceImpl implements NotaFiscalColidenciaComunicacaoService {

    private NotaFiscalColidenciaComunicacaoRepository notaFiscalColidenciaComunicacaoRepository;

    @Override
    public NotaFiscalColidenciaComunicacaoDto createNotaFiscalColidenciaComunicacao(NotaFiscalColidenciaComunicacaoDto notaFiscalColidenciaComunicacaoDto) {

        NotaFiscalColidenciaComunicacao notaFiscalColidenciaComunicacao = NotaFiscalColidenciaComunicacaoMapper.mapToNotaFiscalColidenciaComunicacao(notaFiscalColidenciaComunicacaoDto);
        NotaFiscalColidenciaComunicacao savedNotaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoRepository.save(notaFiscalColidenciaComunicacao);
        return NotaFiscalColidenciaComunicacaoMapper.mapToNotaFiscalColidenciaComunicacaoDto(savedNotaFiscalColidenciaComunicacao);
    }

    @Override
    public NotaFiscalColidenciaComunicacaoDto getNotaFiscalColidenciaComunicacaoById(Long notaFiscalColidenciaComunicacaoId) {
        NotaFiscalColidenciaComunicacao notaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoRepository.findById(notaFiscalColidenciaComunicacaoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Nota Fiscal Colidência Comunicação inexistente pelo ID fornecido: " + notaFiscalColidenciaComunicacaoId));
        return NotaFiscalColidenciaComunicacaoMapper.mapToNotaFiscalColidenciaComunicacaoDto(notaFiscalColidenciaComunicacao);
    }

    @Override
    public List<NotaFiscalColidenciaComunicacaoDto> getAllNotaFiscalColidenciaComunicacao() {
        List<NotaFiscalColidenciaComunicacao> notaFiscalColidenciaComunicacaos = notaFiscalColidenciaComunicacaoRepository.findAll();
        return notaFiscalColidenciaComunicacaos.stream().map((notaFiscalColidenciaComunicacao) -> NotaFiscalColidenciaComunicacaoMapper.mapToNotaFiscalColidenciaComunicacaoDto(notaFiscalColidenciaComunicacao))
                .collect(Collectors.toList());
    }

    @Override
    public NotaFiscalColidenciaComunicacaoDto updateNotaFiscalColidenciaComunicacao(Long notaFiscalColidenciaComunicacaoId, NotaFiscalColidenciaComunicacaoDto updatedNotaFiscalColidenciaComunicacao) {

        NotaFiscalColidenciaComunicacao notaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoRepository.findById(notaFiscalColidenciaComunicacaoId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal Colidência Comunicação inexistente pelo ID fornecido: " + notaFiscalColidenciaComunicacaoId)
        );


        notaFiscalColidenciaComunicacao.setDataOcorrencia(updatedNotaFiscalColidenciaComunicacao.getDataOcorrencia());
        notaFiscalColidenciaComunicacao.setObservacao(updatedNotaFiscalColidenciaComunicacao.getObservacao());

        NotaFiscalColidenciaComunicacao updatedNotaFiscalColidenciaComunicacaoObj = notaFiscalColidenciaComunicacaoRepository.save(notaFiscalColidenciaComunicacao);

        return NotaFiscalColidenciaComunicacaoMapper.mapToNotaFiscalColidenciaComunicacaoDto(updatedNotaFiscalColidenciaComunicacaoObj);
    }

    @Override
    public void deleteNotaFiscalColidenciaComunicacao(Long notaFiscalColidenciaComunicacaoId) {

        NotaFiscalColidenciaComunicacao notaFiscalColidenciaComunicacao = notaFiscalColidenciaComunicacaoRepository.findById(notaFiscalColidenciaComunicacaoId).orElseThrow(
                () -> new ResourceNotFoundException("Nota Fiscal Colidência Comunicação inexistente pelo ID fornecido: " + notaFiscalColidenciaComunicacaoId)
        );

        notaFiscalColidenciaComunicacaoRepository.deleteById(notaFiscalColidenciaComunicacaoId);
    }
}
