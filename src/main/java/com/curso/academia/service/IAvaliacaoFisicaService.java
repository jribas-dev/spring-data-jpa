package com.curso.academia.service;

import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AvaliacaoFisicaForm;
import com.curso.academia.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {
  /**
   * Cria uma Avaliação Física e salva no banco de dados.
   * @param form formulário referente aos dados para criação da Avaliação Física no banco de dados.
   * @return Avaliação Física recém-criada.
   */
  AvaliacaoFisica create(AvaliacaoFisicaForm form);

  /**
   * Retorna uma Avaliação Física do banco de dados de acordo com Id.
   * @param id 'id' da Avaliação Física que será exibida.
   * @return Avaliação Física de acordo com Id fornecido.
   */
  AvaliacaoFisica get(Long id);

  /**
   * Retorna todas as Avaliações Física do banco de dados.
   * @return Uma lista com todas as Avaliações Física salvas no DB.
   */
  List<AvaliacaoFisica> getAll();

  /**
   * Atualiza a avaliação física.
   * @param id 'id' da Avaliação Física que será atualizada.
   * @param formUpdate formulário referente aos dados necessários para atualização da Avaliação
   * Física no banco de dados.
   * @return Avaliação Física recém-atualizada.
   */
  AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

  /**
   * Deleta uma Avaliação Física específica.
   * @param id 'id' da Avaliação Física que será removida.
   */
  void delete(Long id);
}
