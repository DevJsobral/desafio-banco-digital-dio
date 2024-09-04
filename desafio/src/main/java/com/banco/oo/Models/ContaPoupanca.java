package com.banco.oo.Models;

import com.banco.oo.Exceptions.InvalidOperationException;

public class ContaPoupanca extends Conta {

	private double valorInvestido;
	private int tempo;

	public ContaPoupanca(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}

	public void investir(Double valor, int tempo) {
		if (this.saldo >= valor) {
			saldo -= valor;
			valorInvestido += valor * tempo;
			this.tempo = tempo;
		} else {
			throw new InvalidOperationException("Você não possui o saldo necessário para realizar esse investimento");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Rendimento Total da conta em %d anos: %.2f", tempo, this.valorInvestido));
	}
}