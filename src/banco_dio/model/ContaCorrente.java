package banco_dio.model;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(String nome, String cpf, double valor) {
		 super(nome, cpf, valor);
			
		}

	@Override
	public void ImprimirExtrato() {
		System.out.println("---------- Extrato Conta Corrente ----------");
		imprimirInfosComuns();
	}
	


}
