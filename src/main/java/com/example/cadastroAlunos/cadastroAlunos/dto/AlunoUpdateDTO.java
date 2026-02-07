package com.example.cadastroAlunos.cadastroAlunos.dto;

public class AlunoUpdateDTO {
    public String nome;
    public String email;
    public Integer idade;

    public AlunoUpdateDTO() {
    }

    public AlunoUpdateDTO(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
