package com.curso.academia.service.impl;

import com.curso.academia.entity.Aluno;
import com.curso.academia.entity.Matricula;
import com.curso.academia.entity.form.MatriculaForm;
import com.curso.academia.repository.AlunoRepository;
import com.curso.academia.repository.MatriculaRepository;
import com.curso.academia.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;

    private final AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).orElseThrow(NoSuchElementException::new);

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
      matriculaRepository.deleteById(id);
    }

}
