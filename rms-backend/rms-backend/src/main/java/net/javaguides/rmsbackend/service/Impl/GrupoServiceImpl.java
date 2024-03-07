package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.GrupoDto;
import net.javaguides.rmsbackend.entity.Grupo;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.GrupoMapper;
import net.javaguides.rmsbackend.repository.GrupoRepository;
import net.javaguides.rmsbackend.service.GrupoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GrupoServiceImpl implements GrupoService {

    private GrupoRepository grupoRepository;

    @Override
    public GrupoDto createGrupo(GrupoDto grupoDto) {

        Grupo grupo = GrupoMapper.mapToGrupo(grupoDto);
        Grupo savedGrupo = grupoRepository.save(grupo);
        return GrupoMapper.mapToGrupoDto(savedGrupo);
    }

    @Override
    public GrupoDto getGrupoById(Long grupoId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Grupo inexistente pelo ID fornecido: " + grupoId));
        return GrupoMapper.mapToGrupoDto(grupo);
    }

    @Override
    public List<GrupoDto> getAllGrupo() {
        List<Grupo> grupos = grupoRepository.findAll();
        return grupos.stream().map((grupo) -> GrupoMapper.mapToGrupoDto(grupo))
                .collect(Collectors.toList());
    }

    @Override
    public GrupoDto updateGrupo(Long grupoId, GrupoDto updatedGrupo) {

        Grupo grupo = grupoRepository.findById(grupoId).orElseThrow(
                () -> new ResourceNotFoundException("Grupo inexistente pelo ID fornecido: " + grupoId)
        );


        grupo.setDescricao(updatedGrupo.getDescricao());

        Grupo updatedGrupoObj = grupoRepository.save(grupo);

        return GrupoMapper.mapToGrupoDto(updatedGrupoObj);
    }

    @Override
    public void deleteGrupo(Long grupoId) {

        Grupo grupo = grupoRepository.findById(grupoId).orElseThrow(
                () -> new ResourceNotFoundException("Grupo inexistente pelo ID fornecido: " + grupoId)
        );

        grupoRepository.deleteById(grupoId);
    }
}
