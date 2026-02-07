package com.example.cadastroAlunos.cadastroAlunos.service;

import com.example.cadastroAlunos.cadastroAlunos.dto.AlunoCreateDTO;
import com.example.cadastroAlunos.cadastroAlunos.dto.AlunoDTO;
import com.example.cadastroAlunos.cadastroAlunos.dto.AlunoUpdateDTO;
import com.example.cadastroAlunos.cadastroAlunos.entity.AlunoEntity;
import com.example.cadastroAlunos.cadastroAlunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    private AlunoDTO toDTO(AlunoEntity aluno){
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        return dto;
    }

    //CREATE
    public AlunoDTO criar(AlunoCreateDTO dto){
        AlunoEntity aluno = new AlunoEntity();

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setIdade(dto.getIdade());

        AlunoEntity salvo = alunoRepository.save(aluno);
        return toDTO(salvo);
    }

    //LISTAR
    public List<AlunoDTO> listar(){
        return alunoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //BUSCARiD
    public AlunoDTO buscarPorId(Long id){
        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado"));
        return toDTO(aluno);
    }

    //DELETE
    public void deletar(Long id){
        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado"));

        alunoRepository.delete(aluno);
    }

    //UPDATE
    public AlunoDTO atualizar(Long id, AlunoUpdateDTO dto){
        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setIdade(dto.getIdade());

        AlunoEntity atualizado = alunoRepository.save(aluno);
        return toDTO(atualizado);
    }
}
