package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.UnidadeDto;
import net.javaguides.rmsbackend.entity.Unidade;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.UnidadeMapper;
import net.javaguides.rmsbackend.repository.UnidadeRepository;
import net.javaguides.rmsbackend.service.UnidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnidadeServiceImpl implements UnidadeService {

    private UnidadeRepository unidadeRepository;

    @Override
    public UnidadeDto createUnidade(UnidadeDto unidadeDto) {

        Unidade unidade = UnidadeMapper.mapToUnidade(unidadeDto);
        Unidade savedUnidade = unidadeRepository.save(unidade);
        return UnidadeMapper.mapToUnidadeDto(savedUnidade);
    }

    @Override
    public UnidadeDto getUnidadeById(Long unidadeId) {
        Unidade unidade = unidadeRepository.findById(unidadeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Unidade inexistente pelo ID fornecido: " + unidadeId));
        return UnidadeMapper.mapToUnidadeDto(unidade);
    }

    @Override
    public List<UnidadeDto> getAllUnidade() {
        List<Unidade> unidades = unidadeRepository.findAll();
        return unidades.stream().map((unidade) -> UnidadeMapper.mapToUnidadeDto(unidade))
                .collect(Collectors.toList());
    }

    @Override
    public UnidadeDto updateUnidade(Long unidadeId, UnidadeDto updatedUnidade) {

        Unidade unidade = unidadeRepository.findById(unidadeId).orElseThrow(
                () -> new ResourceNotFoundException("Unidade inexistente pelo ID fornecido: " + unidadeId)
        );


        unidade.setSigla(updatedUnidade.getSigla());

        Unidade updatedUnidadeObj = unidadeRepository.save(unidade);

        return UnidadeMapper.mapToUnidadeDto(updatedUnidadeObj);
    }

    @Override
    public void deleteUnidade(Long unidadeId) {

        Unidade unidade = unidadeRepository.findById(unidadeId).orElseThrow(
                () -> new ResourceNotFoundException("Unidade inexistente pelo ID fornecido: " + unidadeId)
        );

        unidadeRepository.deleteById(unidadeId);
    }
}
