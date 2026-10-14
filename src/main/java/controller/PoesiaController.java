package com.gotico.diario.controller;

import com.gotico.diario.model.Poesia;
import com.gotico.diario.repository.PoesiaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/poesias")
@CrossOrigin(origins = "*")
public class PoesiaController {

    private final PoesiaRepository repository;

    public PoesiaController(PoesiaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sortear/{tipo}")
    public Poesia sortearPorTipo(@PathVariable String tipo) {
        return repository.buscarAleatoriaPorTipo(tipo.toUpperCase());
    }

    @PostMapping
    public Poesia adicionar(@RequestBody Poesia poesia) {
        return repository.save(poesia);
    }
}