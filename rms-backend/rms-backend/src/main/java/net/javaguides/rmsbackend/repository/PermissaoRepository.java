package net.javaguides.rmsbackend.repository;

import net.javaguides.rmsbackend.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
