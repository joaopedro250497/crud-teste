package net.javaguides.rmsbackend.repository;

import net.javaguides.rmsbackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
