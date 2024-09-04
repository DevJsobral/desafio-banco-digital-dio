package com.banco.oo.Models;

import com.banco.oo.Exceptions.InvalidOperationException;
import com.banco.oo.Interfaces.IConta;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {
	
	private static final String AGENCIA_PADRAO = "000-1";
	private static int SEQUENCIAL = 01;

	protected String agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		banco.adicionarConta(this);
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
		} else {
			throw new InvalidOperationException("Você não possui saldo suficiente para realizar essa operação");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			throw new InvalidOperationException("Você não possui saldo suficiente para realizar essa operação");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(this.agencia);
		System.out.println(this.numero);
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public String toString() {
		return "Agencia= " + agencia + ", numero=" + numero + ".";
	}

}