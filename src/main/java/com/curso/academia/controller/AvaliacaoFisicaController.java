package com.curso.academia.controller;

import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AvaliacaoFisicaForm;
import com.curso.academia.entity.form.AvaliacaoFisicaUpdateForm;
import com.curso.academia.service.impl.AvaliacaoFisicaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  private final AvaliacaoFisicaServiceImpl service;

  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
    return service.create(form);
  }

  @GetMapping
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }

  @GetMapping("/{id}")
  public AvaliacaoFisica get(@PathVariable Long id) {
    return service.get(id);
  }

  @PutMapping("/{id}")
  public AvaliacaoFisica update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm form) {
    return service.update(id, form);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

}
