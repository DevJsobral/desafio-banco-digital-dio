package com.banco.oo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cliente {

	private String nome;
	private String endereco;
	private int idade;
	private String cpf;

	public void alterarEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", idade=" + idade + ", cpf=" + cpf + "]";
	}

	
}