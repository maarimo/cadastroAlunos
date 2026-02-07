package com.example.cadastroAlunos.cadastroAlunos.repository;

import com.example.cadastroAlunos.cadastroAlunos.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    @Override
    Optional<AlunoEntity> findById(Long aLong);
}
