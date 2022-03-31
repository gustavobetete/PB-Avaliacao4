package br.com.sprint.Avaliacao4.repository;
import br.com.sprint.Avaliacao4.constants.Ideologia;
import br.com.sprint.Avaliacao4.modelo.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    Page<Partido> findByIdeologia(Ideologia ideologia, Pageable paginacao);
}
