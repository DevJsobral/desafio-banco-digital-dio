package com.banco.oo;

import com.banco.oo.Models.Banco;
import com.banco.oo.Models.Cliente;
import com.banco.oo.Models.Conta;
import com.banco.oo.Models.ContaCorrente;
import com.banco.oo.Models.ContaPoupanca;

public class Main {
	public static void main(String[] args) {

		//Agora para uma conta ser instânciada ela precisa ser adicionada à um banco.
		//Onde automaticamente é colocada na lista de contas do banco
		Banco meuBanco = new Banco();

		//Criação de um cliente
		Cliente meuCliente = new Cliente("Zé Castro", "Rua 2 casa 3", 27, "189-189-189-89");
		Cliente meuClientePoupanca = new Cliente("Zé Daniel", "Rua 3 casa 4", 72, "168-168-168-68");

		//Um cliente não pode mudar suas informações, apenas seu endereço:
		meuCliente.alterarEndereco("Rua 3 casa 3");

		//Criando um conta corrente e poupança, para isso um cliente já deve existir para ser associado à mesma
		Conta minhaCC = new ContaCorrente(meuCliente, meuBanco);
		ContaPoupanca minhaCP = new ContaPoupanca(meuClientePoupanca, meuBanco);

		//Exibindo quantidade de contas do banco e seu numero
		meuBanco.exibirNumeroDasContas();
		//Retorno é diferente apenas pra demonstrar
		System.out.println(meuBanco.exibirQtdContas());

		//Depositando valores em ambas as contas
		minhaCC.depositar(4500);
		minhaCP.depositar(2000.99);

		//Transferindo valores e validando informações das contas:
		minhaCC.transferir(4000.00, minhaCP);
		minhaCC.imprimirExtrato();
		minhaCP.imprimirExtrato();

		System.out.println("------------------- Extrato após investir ---------------------");
		//Uma conta poupança pode investir o dinheiro por x tempo, tendo um método especial:
		minhaCP.investir(2000.00, 4);
		//validando novamente
		minhaCC.imprimirExtrato();
		minhaCP.imprimirExtrato();

		//Realizando Operações inválidas para testar exception Personalizada
		//minhaCC.sacar(5000);
		//minhaCP.investir(7000.00, 1);

	}
}
