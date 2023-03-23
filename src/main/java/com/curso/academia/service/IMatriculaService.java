package com.curso.academia.service;

import com.curso.academia.entity.Matricula;
import com.curso.academia.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {
  /**
   * Cria uma Matrícula e salva no banco de dados.
   * @param form formulário referente aos dados para criação da Matrícula no banco de dados.
   * @return Matrícula recém-criada.
   */
  Matricula create(MatriculaForm form);

  /**
   * Retorna uma Matrícula do banco de dados de acordo com Id.
   * @param id - id da Matrícula que será exibida.
   * @return - Matrícula de acordo com o Id fornecido.
   */
  Matricula get(Long id);

  /**
   * Retorna todas as Matrículas do banco de dados.
   * @return uma lista com todas as Matrículas salvas no DB.
   */
  List<Matricula> getAll(String bairro);

  /**
   * Deleta uma Matrícula específica.
   * @param id - id da Matrícula que será removida.
   */
  void delete(Long id);

}
