package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NotaFiscalVerificacaoDto;
import net.javaguides.rmsbackend.entity.NotaFiscalVerificacao;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.NotaFiscalVerificacaoMapper;
import net.javaguides.rmsbackend.repository.NotaFiscalVerificacaoRepository;
import net.javaguides.rmsbackend.service.NotaFiscalVerificacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotaFiscalVerificacaoServiceImpl implements NotaFiscalVerificacaoService {

    private NotaFiscalVerificacaoRepository notaFiscalVerificacaoRepository;

    @Override
    public NotaFiscalVerificacaoDto createNotaFiscalVerificacao(NotaFiscalVerificacaoDto notaFiscalVerificacaoDto) {

        NotaFiscalVerificacao notaFiscalVerificacao = NotaFiscalVerificacaoMapper.mapToNotaFiscalVerificacao(notaFiscalVerificacaoDto);
        NotaFiscalVerificacao savedNotaFiscalVerificacao = notaFiscalVerificacaoRepository.save(notaFiscalVerificacao);
        return NotaFiscalVerificacaoMapper.mapToNotaFiscalVerificacaoDto(savedNotaFiscalVerificacao);
    }

    @Override
    public NotaFiscalVerificacaoDto getNotaFiscalVerificacaoById(Long notaFiscalVerificacaoId) {
        NotaFiscalVerificacao notaFiscalVerificacao = notaFiscalVerificacaoRepository.findById(notaFiscalVerificacaoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("NotaFiscalVerificacao inexistente pelo ID fornecido: " + notaFiscalVerificacaoId));
        return NotaFiscalVerificacaoMapper.mapToNotaFiscalVerificacaoDto(notaFiscalVerificacao);
    }

    @Override
    public List<NotaFiscalVerificacaoDto> getAllNotaFiscalVerificacao() {
        List<NotaFiscalVerificacao> notaFiscalVerificacaos = notaFiscalVerificacaoRepository.findAll();
        return notaFiscalVerificacaos.stream().map((notaFiscalVerificacao) -> NotaFiscalVerificacaoMapper.mapToNotaFiscalVerificacaoDto(notaFiscalVerificacao))
                .collect(Collectors.toList());
    }

    @Override
    public NotaFiscalVerificacaoDto updateNotaFiscalVerificacao(Long notaFiscalVerificacaoId, NotaFiscalVerificacaoDto updatedNotaFiscalVerificacao) {

        NotaFiscalVerificacao notaFiscalVerificacao = notaFiscalVerificacaoRepository.findById(notaFiscalVerificacaoId).orElseThrow(
                () -> new ResourceNotFoundException("NotaFiscalVerificacao inexistente pelo ID fornecido: " + notaFiscalVerificacaoId)
        );


        notaFiscalVerificacao.setDataVerificacao(updatedNotaFiscalVerificacao.getDataVerificacao());
        notaFiscalVerificacao.setXml(updatedNotaFiscalVerificacao.getXml());

        NotaFiscalVerificacao updatedNotaFiscalVerificacaoObj = notaFiscalVerificacaoRepository.save(notaFiscalVerificacao);

        return NotaFiscalVerificacaoMapper.mapToNotaFiscalVerificacaoDto(updatedNotaFiscalVerificacaoObj);
    }

    @Override
    public void deleteNotaFiscalVerificacao(Long notaFiscalVerificacaoId) {

        NotaFiscalVerificacao notaFiscalVerificacao = notaFiscalVerificacaoRepository.findById(notaFiscalVerificacaoId).orElseThrow(
                () -> new ResourceNotFoundException("NotaFiscalVerificacao inexistente pelo ID fornecido: " + notaFiscalVerificacaoId)
        );

        notaFiscalVerificacaoRepository.deleteById(notaFiscalVerificacaoId);
    }
}
