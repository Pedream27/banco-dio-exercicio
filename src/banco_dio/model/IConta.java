package banco_dio.model;

public interface IConta {
	
	public void sacar(double valor) ;
	public void depositar(double valor);
	public void tranferir(Conta conta , double valor);
	

}
