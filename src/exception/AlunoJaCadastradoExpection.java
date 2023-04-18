package exception;

public class AlunoJaCadastradoExpection extends Exception{
	
	public AlunoJaCadastradoExpection() {
		System.out.println("Não foi possível cadastrar, usuário já cadastrado!!");
	}

}
