package net.javaguides.rmsbackend.repository;

import net.javaguides.rmsbackend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
