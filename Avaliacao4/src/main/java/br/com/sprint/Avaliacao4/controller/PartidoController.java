package br.com.sprint.Avaliacao4.controller;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Ideologia;
import br.com.sprint.Avaliacao4.controller.dto.AssociadoDto;
import br.com.sprint.Avaliacao4.controller.dto.PartidoDto;
import br.com.sprint.Avaliacao4.controller.form.AssociadoForm;
import br.com.sprint.Avaliacao4.controller.form.PartidoForm;
import br.com.sprint.Avaliacao4.modelo.Associado;
import br.com.sprint.Avaliacao4.modelo.Partido;
import br.com.sprint.Avaliacao4.repository.AssociadoRepository;
import br.com.sprint.Avaliacao4.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/partidos")
public class PartidoController {
    @Autowired
    private PartidoRepository partidoRepository;

    @GetMapping
    public Page<PartidoDto> lista(@RequestParam(required = false) Ideologia ideologia,
                                  @PageableDefault(sort="id", direction = Sort.Direction.ASC) Pageable paginacao){
        if (ideologia == null) {
            Page<Partido> partido = partidoRepository.findAll(paginacao);
            return PartidoDto.converter(partido);
        }else {
            Page<Partido> partido = partidoRepository.findByIdeologia(ideologia, paginacao);
            return PartidoDto.converter(partido);
        }

    }

    @PostMapping
    @Transactional
    public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder){

        Partido partido = form.converter(partidoRepository);
        partidoRepository.save(partido);

        URI uri = uriBuilder.path("/partidos").buildAndExpand(partido.getId()).toUri();
        return ResponseEntity.created(uri).body( new PartidoDto(partido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> detalhar(@PathVariable Long id){

        Optional<Partido> partido = partidoRepository.findById(id);
        if(partido.isPresent()){
            return ResponseEntity.ok(partido.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PartidoForm form ){
        Optional<Partido> optional = partidoRepository.findById(id);
        if(optional.isPresent()){
            Partido partido = form.atualizar(id, partidoRepository);
            return ResponseEntity.ok(new PartidoDto(partido));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Partido> optional = partidoRepository.findById(id);
        if(optional.isPresent()) {
            partidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
