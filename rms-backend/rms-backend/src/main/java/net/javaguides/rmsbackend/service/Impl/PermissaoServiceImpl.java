package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.PermissaoDto;
import net.javaguides.rmsbackend.entity.Permissao;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.PermissaoMapper;
import net.javaguides.rmsbackend.repository.PermissaoRepository;
import net.javaguides.rmsbackend.service.PermissaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PermissaoServiceImpl implements PermissaoService {

    private PermissaoRepository permissaoRepository;

    @Override
    public PermissaoDto createPermissao(PermissaoDto permissaoDto) {

        Permissao permissao = PermissaoMapper.mapToPermissao(permissaoDto);
        Permissao savedPermissao = permissaoRepository.save(permissao);
        return PermissaoMapper.mapToPermissaoDto(savedPermissao);
    }

    @Override
    public PermissaoDto getPermissaoById(Long permissaoId) {
        Permissao permissao = permissaoRepository.findById(permissaoId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Permissao inexistente pelo ID fornecido: " + permissaoId));
        return PermissaoMapper.mapToPermissaoDto(permissao);
    }

    @Override
    public List<PermissaoDto> getAllPermissao() {
        List<Permissao> permissaos = permissaoRepository.findAll();
        return permissaos.stream().map((permissao) -> PermissaoMapper.mapToPermissaoDto(permissao))
                .collect(Collectors.toList());
    }

    @Override
    public PermissaoDto updatePermissao(Long permissaoId, PermissaoDto updatedPermissao) {

        Permissao permissao = permissaoRepository.findById(permissaoId).orElseThrow(
                () -> new ResourceNotFoundException("Permissao inexistente pelo ID fornecido: " + permissaoId)
        );


        permissao.setDescricao(updatedPermissao.getDescricao());
        permissao.setSigla(updatedPermissao.getSigla());

        Permissao updatedPermissaoObj = permissaoRepository.save(permissao);

        return PermissaoMapper.mapToPermissaoDto(updatedPermissaoObj);
    }

    @Override
    public void deletePermissao(Long permissaoId) {

        Permissao permissao = permissaoRepository.findById(permissaoId).orElseThrow(
                () -> new ResourceNotFoundException("Permissao inexistente pelo ID fornecido: " + permissaoId)
        );

        permissaoRepository.deleteById(permissaoId);
    }
}
