package com.curso.academia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id", foreignKey = @ForeignKey(name = "fk_matricula_aluno"))
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
