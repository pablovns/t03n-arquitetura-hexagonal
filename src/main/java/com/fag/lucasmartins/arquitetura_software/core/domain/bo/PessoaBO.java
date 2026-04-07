package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;

public class PessoaBO {

    private Long id;

    private String nomeCompleto;

    private String cpf;

    private LocalDate dataNascimento;

    private String email;

    private String telefone;

    public void prepararParaCadastro() {
        validarCamposObrigatorios();
        validarMaioridade();
        validarCpf();
        validarEmail();
        validarTelefone();
    }

    private void validarCamposObrigatorios() {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new DomainException("Erro: Nome completo é obrigatório.");
        }
        if (dataNascimento == null) {
            throw new DomainException("Erro: Data de nascimento é obrigatória.");
        }
    }

    private void validarMaioridade() {
        int idade = Period.between(this.dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("Erro: Cliente deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf() {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new DomainException("Erro: CPF é obrigatório.");
        }
        if (!cpf.matches("\\d{11}")) {
            throw new DomainException("Erro: CPF deve possuir 11 dígitos numéricos.");
        }
    }

    private void validarEmail() {
        if (email == null || email.trim().isEmpty()) {
            throw new DomainException("Erro: E-mail é obrigatório.");
        }
        if (!email.contains("@")) {
            throw new DomainException("Erro: E-mail inválido. Deve conter '@'.");
        }
    }

    private void validarTelefone() {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new DomainException("Erro: Telefone é obrigatório.");
        }
        if (!telefone.matches("\\d{11}")) {
            throw new DomainException("Erro: Telefone deve possuir 11 dígitos numéricos.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
