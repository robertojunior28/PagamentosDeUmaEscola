package exception;

public class AlunoNaoEncontradoException extends Exception{
	
	public AlunoNaoEncontradoException() {
		System.out.println("N�o foi possivel encontrar o aluno.");
	}

}
