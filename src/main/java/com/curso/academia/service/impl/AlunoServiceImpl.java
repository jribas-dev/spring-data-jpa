package com.curso.academia.service.impl;

import com.curso.academia.entity.Aluno;
import com.curso.academia.entity.AvaliacaoFisica;
import com.curso.academia.entity.form.AlunoForm;
import com.curso.academia.entity.form.AlunoUpdateForm;
import com.curso.academia.infra.utils.JavaTimeUtils;
import com.curso.academia.repository.AlunoRepository;
import com.curso.academia.service.IAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements IAlunoService {

    private final AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if (dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        if ((id != null) && (id > 0)) {
            Aluno alunoup = repository.findById(id).orElseThrow(NoSuchElementException::new);
            if (formUpdate.getNome() != null) {
                alunoup.setNome(formUpdate.getNome());
            }
            if (formUpdate.getBairro() != null) {
                alunoup.setBairro(formUpdate.getBairro());
            }
            if (formUpdate.getDataDeNascimento() != null) {
                alunoup.setDataDeNascimento(formUpdate.getDataDeNascimento());
            }
            return repository.save(alunoup);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if ((id != null) && (id > 0)) {
            Aluno alunodel = repository.findById(id).orElseThrow(NoSuchElementException::new);
            repository.delete(alunodel);
        }
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return aluno.getAvaliacoes();
    }

}
