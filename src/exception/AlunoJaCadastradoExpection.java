package exception;

public class AlunoJaCadastradoExpection extends Exception{
	
	public AlunoJaCadastradoExpection() {
		System.out.println("N�o foi poss�vel cadastrar, usu�rio j� cadastrado!!");
	}

}
