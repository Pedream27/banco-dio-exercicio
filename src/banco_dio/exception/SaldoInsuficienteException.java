package banco_dio.exception;

public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9164993434820946768L;
	
	
	public SaldoInsuficienteException(String menssage) {
			super(menssage);
	}

}
