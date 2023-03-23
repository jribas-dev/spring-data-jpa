package com.curso.academia.controller;

import com.curso.academia.entity.Matricula;
import com.curso.academia.entity.form.MatriculaForm;
import com.curso.academia.service.impl.MatriculaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matriculas")
public class MatriculaController {

  private final MatriculaServiceImpl service;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

  @GetMapping("/{id}")
  public Matricula get(@PathVariable Long id) {
    return service.get(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

}