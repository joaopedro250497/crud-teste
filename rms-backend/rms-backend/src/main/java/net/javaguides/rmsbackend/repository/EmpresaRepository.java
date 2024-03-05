package net.javaguides.rmsbackend.repository;

import net.javaguides.rmsbackend.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
