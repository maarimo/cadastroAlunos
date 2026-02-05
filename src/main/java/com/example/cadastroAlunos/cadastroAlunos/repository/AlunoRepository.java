package com.example.cadastroAlunos.cadastroAlunos.repository;

import com.example.cadastroAlunos.cadastroAlunos.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
