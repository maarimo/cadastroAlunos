package com.example.cadastroAlunos.cadastroAlunos.controller;

import com.example.cadastroAlunos.cadastroAlunos.dto.AlunoDTO;
import com.example.cadastroAlunos.cadastroAlunos.dto.AlunoUpdateDTO;
import com.example.cadastroAlunos.cadastroAlunos.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    //BUSCARporID
    @GetMapping({"/id"})
    public AlunoDTO buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    //DELETE
    @DeleteMapping({"/id"})
    public void deletar(@PathVariable Long id){
        alunoService.deletar(id);
    }

    //ATUALIZAR
    @PutMapping({"/id"})
    public AlunoDTO atualizar(@PathVariable Long id,
                              @RequestBody AlunoUpdateDTO dto){
        return alunoService.atualizar(id, dto);
    }

}
