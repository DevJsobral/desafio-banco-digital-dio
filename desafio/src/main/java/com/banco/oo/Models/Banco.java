package com.banco.oo.Models;

import java.util.ArrayList;
import java.util.List;


public class Banco {

	private final String NOME = "BANCO D.I.O";
	private static List<Conta> contas = new ArrayList<Conta>();

	public int exibirQtdContas() {
		return contas.size();
	}

	public void exibirNumeroDasContas() {
		contas.forEach(System.out::println);
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

}