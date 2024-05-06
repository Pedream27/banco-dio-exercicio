package banco_dio;

import banco_dio.model.Conta;
import banco_dio.model.ContaCorrente;
import banco_dio.model.ContaPoupanca;

public class app {

	public static void main(String[] args) {
		
		Conta corrente = new ContaCorrente("Pedro", "085353506", 2500);
		Conta poupanca = new ContaPoupanca("Pedro", "085353506", 2500);
		
		corrente.depositar(8000);
		corrente.tranferir(poupanca, 500);
		corrente.ImprimirExtrato();
		poupanca.ImprimirExtrato();
		poupanca.depositar(0);
		corrente.ComprarCartão("Caderno", 12.5);
		corrente.ComprarCartão("Mochila", 25.50);
		corrente.imprimirExtratoCartão();
		
		
	}

}
