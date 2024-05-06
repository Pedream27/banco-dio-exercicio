package banco_dio.model;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
	
	private Cliente cliente;
	private boolean cartaoAtivo;
	private double limite;
	private List<String> compras;
	private double fatura;


	public Cartao ( Cliente cliente) {
		
		this.cliente = new Cliente(cliente);
		cartaoAtivo = aprovarCartao(cliente);
		limite = limiteCartao(cartaoAtivo, cliente);
		compras = new ArrayList<String>();
		
		
		
	}
	
	public void fatura() {
		System.out.println("Sua fatura esta no valor de : " + fatura);
	}
	
	public void extradoCartão() {
		System.out.println("--------- Extrado Cartao -----------");
			for (String compra : compras) {
				System.out.println(compra);
			}
	
		
	}
	
	public void adicionarCompra(String produto , double valor) {
		if(cartaoAtivo) {
		if(limite >= fatura + valor) {
			compras.add(produto + " valor: R$"+ valor );
			fatura += valor;
		}else {
			System.out.println("Sem limite para realizar essa compra");
		}
		}else {
		System.out.println("Seu cartão não estar ativo porfavor ligue para a central ##########");
		}
		
		
	}
	
	

	private double limiteCartao(boolean cartaoAtivo2, Cliente cliente2) {
		return cartaoAtivo2 == false ? 0.0 : cliente.getRenda() * 0.20 ;
	}

	private boolean aprovarCartao(Cliente cliente2) {
		double renda = cliente.getRenda();
		return renda > 1400 ? true : false ;
			
	}
}
