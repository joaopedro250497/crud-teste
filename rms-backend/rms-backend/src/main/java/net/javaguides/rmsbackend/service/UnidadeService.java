package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.UnidadeDto;

import java.util.List;

public interface UnidadeService {
    UnidadeDto createUnidade(UnidadeDto unidadeDto);

    UnidadeDto getUnidadeById(Long unidadeId);

    List<UnidadeDto> getAllUnidade();

    UnidadeDto updateUnidade(Long unidadeId, UnidadeDto updatedUnidade);

    void deleteUnidade(Long unidadeId);
}
