package com.curso.academia.service;

import com.curso.academia.entity.Aluno;
import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AlunoForm;
import com.curso.academia.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {
  /**
   * Cria um Aluno e salva no banco de dados.
   * @param form formulário referente aos dados para criação de um Aluno no banco de dados.
   * @return Aluno recém-criado.
   */
  Aluno create(AlunoForm form);

  /**
   * Retorna um Aluno do banco de dados de acordo com Id informado.
   * @param id id do Aluno que será exibido.
   * @return Aluno de acordo com o Id fornecido.
   */
  Aluno get(Long id);

  /**
   * Retorna os Alunos do banco de dados.
   * @return Uma lista de Alunos salvos no DB.
   */
  List<Aluno> getAll(String dataDeNascimento);

  /**
   * Atualiza o Aluno.
   * @param id 'id' do Aluno que será atualizado.
   * @param formUpdate formulário referente aos dados necessários para atualização do Aluno
   * no banco de dados.
   * @return Aluno recém-atualizado.
   */
  Aluno update(Long id, AlunoUpdateForm formUpdate);

  /**
   * Deleta um Aluno específico.
   * @param id 'id' do Aluno que será removido.
   */
  void delete(Long id);

  /**
   *
   * @param id 'id' do aluno que será recuperada a lista de avaliações
   * @return uma lista com todas as avaliações do aluno
   */
  List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);


}
