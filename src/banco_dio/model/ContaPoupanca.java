package banco_dio.model;

public class ContaPoupanca extends Conta {
	


	public ContaPoupanca(String nome, String cpf, double valor) {
		 super(nome, cpf, valor);
			
		}

	@Override
	public void ImprimirExtrato() {
		System.out.println("---------- Extrato Conta Poupança ----------");
		imprimirInfosComuns();
		
	}

	

}
