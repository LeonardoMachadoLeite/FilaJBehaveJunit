package exceptions;

public class FilaVaziaException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3934391539931695741L;

	public FilaVaziaException() {
        super("A fila está vazia.");
    }
}

