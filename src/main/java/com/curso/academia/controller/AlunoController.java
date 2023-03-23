package com.curso.academia.controller;

import com.curso.academia.entity.Aluno;
import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AlunoForm;
import com.curso.academia.entity.form.AlunoUpdateForm;
import com.curso.academia.service.impl.AlunoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

  private final AlunoServiceImpl service;

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  @PutMapping("/{id}")
  public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm form) {
    return service.update(id, form);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

  @GetMapping("/{id}")
  public Aluno get(@PathVariable Long id) {
    return service.get(id);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }

}
