package br.com.sprint.Avaliacao4.controller;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.controller.dto.AssociadoDto;
import br.com.sprint.Avaliacao4.controller.form.AssociadoForm;
import br.com.sprint.Avaliacao4.modelo.Associado;
import br.com.sprint.Avaliacao4.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public Page<AssociadoDto> lista(@RequestParam(required = false) Cargo cargo,
                                    @PageableDefault(sort="id", direction = Sort.Direction.ASC) Pageable paginacao){
        if (cargo == null) {
            Page<Associado> associado = associadoRepository.findAll(paginacao);
            return AssociadoDto.converter(associado);
        }else {
            Page<Associado> associado = associadoRepository.findByCargo(cargo, paginacao);
            return AssociadoDto.converter(associado);
        }

    }

    @PostMapping
    @Transactional
    public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form, UriComponentsBuilder uriBuilder){

        Associado associado = form.converter(associadoRepository);
        associadoRepository.save(associado);

        URI uri = uriBuilder.path("/associados").buildAndExpand(associado.getId()).toUri();
        return ResponseEntity.created(uri).body( new AssociadoDto(associado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Associado> detalhar(@PathVariable Long id){

        Optional<Associado> associado = associadoRepository.findById(id);
        if(associado.isPresent()){
            return ResponseEntity.ok(associado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AssociadoForm form ){
        Optional<Associado> optional = associadoRepository.findById(id);
        if(optional.isPresent()){
            Associado associado = form.atualizar(id, associadoRepository);
            return ResponseEntity.ok(new AssociadoDto(associado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Associado> optional = associadoRepository.findById(id);
        if(optional.isPresent()) {
            associadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
