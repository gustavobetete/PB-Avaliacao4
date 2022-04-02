package br.com.sprint.Avaliacao4.repository;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.modelo.Associado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
   Page<Associado> findByCargo(Cargo cargo, Pageable paginacao);

   List<Associado> findByPartidoId(Long id);
}
