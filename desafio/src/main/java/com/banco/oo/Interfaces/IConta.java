package com.banco.oo.Interfaces;

import com.banco.oo.Models.Conta;

public interface IConta {
	
	void sacar (double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino);
	
	void imprimirExtrato();
}