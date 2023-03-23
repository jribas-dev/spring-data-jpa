package com.curso.academia.service.impl;

import com.curso.academia.entity.Aluno;
import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AvaliacaoFisicaForm;
import com.curso.academia.entity.form.AvaliacaoFisicaUpdateForm;
import com.curso.academia.repository.AlunoRepository;
import com.curso.academia.repository.AvaliacaoFisicaRepository;
import com.curso.academia.service.IAvaliacaoFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  private final AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).orElseThrow(NoSuchElementException::new);

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return avaliacaoFisicaRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public List<AvaliacaoFisica> getAll() {
    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    AvaliacaoFisica avaliacaoUpd = avaliacaoFisicaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    if (formUpdate.getPeso() > 0) {
      avaliacaoUpd.setPeso(formUpdate.getPeso());
    }
    if (formUpdate.getAltura() > 0) {
      avaliacaoUpd.setAltura(formUpdate.getAltura());
    }
    avaliacaoFisicaRepository.save(avaliacaoUpd);
    return avaliacaoUpd;
  }

  @Override
  public void delete(Long id) {
    avaliacaoFisicaRepository.deleteById(id);
  }
}
