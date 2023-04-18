package exception;

public class AlunoNaoEncontradoException extends Exception{
	
	public AlunoNaoEncontradoException() {
		System.out.println("Não foi possivel encontrar o aluno.");
	}

}
