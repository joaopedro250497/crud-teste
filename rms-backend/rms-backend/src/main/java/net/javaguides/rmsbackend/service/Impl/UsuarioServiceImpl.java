package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.UsuarioDto;
import net.javaguides.rmsbackend.entity.Usuario;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.UsuarioMapper;
import net.javaguides.rmsbackend.repository.UsuarioRepository;
import net.javaguides.rmsbackend.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDto);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(savedUsuario);
    }

    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuario inexistente pelo ID fornecido: " + usuarioId));
        return UsuarioMapper.mapToUsuarioDto(usuario);
    }

    @Override
    public List<UsuarioDto> getAllUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map((usuario) -> UsuarioMapper.mapToUsuarioDto(usuario))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto updateUsuario(Long usuarioId, UsuarioDto updatedUsuario) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResourceNotFoundException("Usuario inexistente pelo ID fornecido: " + usuarioId)
        );


        usuario.setEmail(updatedUsuario.getEmail());
        usuario.setNome(updatedUsuario.getNome());
        usuario.setCpf(updatedUsuario.getCpf());
        usuario.setAtivo(updatedUsuario.getAtivo());
        usuario.setAdministrador(updatedUsuario.getAdministrador());
        usuario.setDataRegistro(updatedUsuario.getDataRegistro());
        usuario.setDataBloqueio(updatedUsuario.getDataBloqueio());

        Usuario updatedUsuarioObj = usuarioRepository.save(usuario);

        return UsuarioMapper.mapToUsuarioDto(updatedUsuarioObj);
    }

    @Override
    public void deleteUsuario(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(
                () -> new ResourceNotFoundException("Usuario inexistente pelo ID fornecido: " + usuarioId)
        );

        usuarioRepository.deleteById(usuarioId);
    }
}
