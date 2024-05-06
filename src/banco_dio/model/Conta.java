package banco_dio.model;

import banco_dio.exception.SaldoInsuficienteException;
import banco_dio.exception.ValorInvalidoException;

public abstract class Conta implements IConta {
	
	protected static int AGENCIA_PADRAO = 001;
	private static int SEQ_CONTA = 000001;
	
	protected int agencia;
	protected int conta;
	protected double saldo;
	private Cliente cliente;
	private Cartao cartao;
	
	
	
	public Conta(String nome , String cpf , double valor) {
		agencia = AGENCIA_PADRAO;
		conta = SEQ_CONTA++;
		cliente = new Cliente (nome , cpf , valor);
		cartao =  new Cartao (this.cliente);
		
		
		
	}
	
	
	private Double calcularLimite(boolean cartaoL, double renda) {
		return cartaoL == false ? 0.0 : renda * 0.20 ;
	
	}


	private boolean cartaoLiberado(Double renda) {
	 
		return renda > 1400 ? true : false;
	}


	public abstract void ImprimirExtrato();

	@Override
	public void sacar(double valor) {
		if(saldo >= valor) {
			saldo -= valor;
		}else {
			try {
				throw new SaldoInsuficienteException("ERRO : Saldo insuficiente");
			} catch (Exception e) {
			 System.out.println(e.getMessage());
			}
			
		}
		
	}

	@Override
	public void depositar(double valor) {
		if(valor > 0) {
			saldo += valor;
		}else {
			try {
			throw new ValorInvalidoException("ERRO: Valor inserido Invalodo ");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
	}
	}

	@Override
	public void tranferir(Conta conta, double valor) {
		if(valor > 0 ) {
			saldo -= valor;
			conta.depositar(valor);
		}else {
			// lança erro
			System.out.println("Valor tranferido invalido");
		}
		
	}
	
	public void ComprarCartão(String produto , Double valor) {
		cartao.adicionarCompra(produto	, valor);
	}
	
	public void imprimirExtratoCartão() {
		cartao.extradoCartão();
		cartao.fatura();
	}
	
	public  void imprimirInfosComuns() {
		
		System.out.println("Sr " + cliente.getNome() +"");
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("N° Conta: %d", conta));
		System.out.println("Saldo:  " + saldo);
		
	}
	
	


	
}
