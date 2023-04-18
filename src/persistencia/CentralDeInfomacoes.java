package persistencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception.AlunoJaAdimplenteExpection;
import exception.AlunoJaCadastradoExpection;
import exception.AlunoNaoEncontradoException;
import exception.ListaVaziaException;
import meses.Mes;
import modelos.Aluno;


public class CentralDeInfomacoes {
	
	private ArrayList<Aluno> todosAlunos;
	
	private ArrayList<Aluno> alunosQueNaoPagou;
	
	private ArrayList<Aluno> alunosQueJaPagou;

	
	
	public CentralDeInfomacoes() {
		todosAlunos = new ArrayList<>();
		alunosQueNaoPagou = new ArrayList<>();
		alunosQueJaPagou = new ArrayList<>();
	}
	
//-----------------------------------metodos de todos os alunos--------------------------------------------------
	/**
	 * Este metodo serve para recuperar um aluno
	 * 
	 * @param aluno
	 * @return aluno ou null
	 */
	 public Aluno recuperarAluno(Aluno aluno) {
	    	for(Aluno verificando: todosAlunos) {
	    		if(verificando.equals(aluno)) {
	    			return verificando;
	    		}
	    	}
	    	return null;
	   }
	 
	 
	 /**
	  * Este metodo adiciona um novo aluno caso o mesmo ainda não esteja cadastrado
	  * @param aluno
	  * @return
	  * @throws AlunoJaCadastradoExpection
	  */
	 public boolean adicionarAluno(Aluno aluno) throws AlunoJaCadastradoExpection{
	    	
		 	Aluno verificando = recuperarAluno(aluno);
	    	
	    	if(verificando != null) {
	    		throw new AlunoJaCadastradoExpection();
	    	}else {
	    		todosAlunos.add(aluno);
	    		alunosQueNaoPagou.add(aluno);
	    		MetodosPersistencia.salvarCentral(this);
	    		return true;
	    	}
	 }
	 
	 
	 /**
	  *  Este metodo serve para deletar um aluno da lista de alunos salvos
	  * @param aluno
	  * @return true para deu certo e mensagem de erro caso deu errado.
	  * @throws AlunoNaoEncontradoException
	  */
	 public boolean deletarAluno(Aluno aluno) throws AlunoNaoEncontradoException{
		
		 Aluno verificando = recuperarAluno(aluno);
		 
		 if(verificando == null) {
			 throw new AlunoNaoEncontradoException();
		 }else {
			 todosAlunos.remove(verificando);
			 alunosQueJaPagou.remove(verificando);
			 alunosQueNaoPagou.remove(verificando);
			 MetodosPersistencia.salvarCentral(this);
			 return true;
		 }
	 }
//	 
//	 /**
//	  * Este metodo retorna todos os alunos  cadastrados
//	  * @throws ListaVaziaException
//	  */
//	 public void listarTodosOsAlunos() throws ListaVaziaException{
//		
//		 System.out.println("---------------LISTA DE ALUNOS-------------------");
//		
//		 for (Aluno aluno : todosAlunos) {
//			
//			 if(!todosAlunos.isEmpty()) {
//				 System.out.println("Aluno(a): "+ aluno.getNome() + ", Matricula: " + aluno.getMatricula() + ", Responsável: " + aluno.getNomeResponsavel() + ", Telefone: " + aluno.getTelefoneResponsavel() + aluno.getEndereco());
//			 }else {
//				 throw new ListaVaziaException();
//			 }
//		}
//		 System.out.println("---------------------------------------------------");
//		
//	 }
//	 
	 /**
	  * adicionar um aluno na lista de quem já pagou
	  * retorna true caso consiga
	  * @param aluno
	  * @return
	  * @throws AlunoJaCadastradoExpection
	 * @throws AlunoNaoEncontradoException 
	  */
	 public boolean adicionarAlunoQueJaPagou(Aluno aluno) throws AlunoNaoEncontradoException, AlunoJaAdimplenteExpection{
	    	
		   Aluno verificando = recuperarAluno(aluno);
	    	
	    	Aluno alunoJaAdimplente = retornarAlunoQueJaPagou(aluno);
	    
	    	if(verificando == null) {
	    		throw new AlunoNaoEncontradoException();
	    	}else if(alunoJaAdimplente != null) {
	    		 throw new AlunoJaAdimplenteExpection();
	    	}else {
	    		alunosQueNaoPagou.remove(verificando);
	    		alunosQueJaPagou.add(verificando);
	    		MetodosPersistencia.salvarCentral(this);
	    		return true;
	    	}
	 }
	 
	 public Aluno retornarAlunoQueJaPagou(Aluno alunoEscolhido){
		 
		 for(Aluno aluno: alunosQueJaPagou) {
		
			 if(aluno.equals(alunoEscolhido)) {
				 return aluno;
			 }
		 }
		 return null;
	 }
	 

	 
//	
//	 /**
//	  * mostra todos os alunos que ja pagou 
//	  * @throws ListaVaziaException
//	  */
//	  public void listarTodosOsAlunosQueJaPagou() throws ListaVaziaException{
//	
//		 System.out.println("---------------LISTA DE TODOS OS ALUNOS QUE PAGOU---------------------------");
//		 for (Aluno aluno : alunosQueJaPagou) {
//			 if(!alunosQueJaPagou.isEmpty()) {
//				 System.out.println("Aluno(a): "+ aluno.getNome() + ", Matricula: " + aluno.getMatricula() + ", Responsável: " + aluno.getNomeResponsavel() + ", Telefone: " + aluno.getTelefoneResponsavel() + aluno.getEndereco());
//			 }else {
//				 throw new ListaVaziaException();
//			 }
//		}
//		 System.out.println("-----------------------------------------------------------------------------");
//		
//	 }
//
//	 /**
//	  * mostra todos os alunos da lista de quem nao pagou
//	  * @throws ListaVaziaException
//	  */
//	 public void listarTodosOsAlunosQueNaoPagou() throws ListaVaziaException{
//		
//		 System.out.println("-----------------LISTA DE TODOS OS ALUNOS QUE NÃO PAGOU---------------------------");
//		 
//		 
//		 for (Aluno aluno : alunosQueNaoPagou) {
//			 if(!alunosQueNaoPagou.isEmpty()) {
//				 System.out.println("Aluno(a): "+ aluno.getNome() + ", Matricula: " + aluno.getMatricula() + ", Responsável: " + aluno.getNomeResponsavel() + ", Telefone: " + aluno.getTelefoneResponsavel() + aluno.getEndereco());
//			 }else {
//				 throw new ListaVaziaException();
//			 }
//		}
//		System.out.println("---------------------------------------------------------------------------------");
//		}
//	 
//	 
//	 
	 
	 	 
	 
//--------------------------------metodos de reiniar os pagamentos----------------------------------------------
	
	 
	 /**
	  * Este metodo serve para zerar as listas de quem pagou e de quem nao pagou
	  * para quando chegar no inicio do proximo mês ele conseguir ter novamente o mesmo controle
	  * retorna true caso consiga
	  * @return
	  * @throws AlunoNaoEncontradoException
	  */
	
	 public boolean reiniciarOsPagamentosDoMes() throws AlunoNaoEncontradoException {
		 
		 Mes mes = MetodosPersistencia.obterMeses();
		 for (Aluno aluno : alunosQueNaoPagou) {
			mes.adicionarJaneiro(aluno);
		}
		 MetodosPersistencia.salvarMeses(mes);
		 
		 
		 
		 
		 alunosQueJaPagou = new ArrayList<>();
		 alunosQueNaoPagou = new ArrayList<>();
		 
		 MetodosPersistencia.salvarCentral(this);
		 
		 return true;
	 }
	 
	 
//----------------------------------lucro pretendido -----------------------------
	 
	 public float lucroPrevisto() {
			
		 float lucroPrevisto = 0;
			
			 if(!todosAlunos.isEmpty()) {
				 for (Aluno aluno : todosAlunos) {
					 lucroPrevisto += (double) aluno.getMensalidade();
				 }
			 }
			 MetodosPersistencia.salvarCentral(this);
			 
			 return lucroPrevisto;	
	}
	 
//-----------------------------------lucro recebido ----------------------------------
	 
	 public float lucroRecebido() {
			
		 float lucroPrevisto = 0;
			
			 if(!alunosQueJaPagou.isEmpty()) {
				 for (Aluno aluno : alunosQueJaPagou) {
					 lucroPrevisto += (float) aluno.getMensalidade();
				 }
			 }
			 MetodosPersistencia.salvarCentral(this);
			 
			 return lucroPrevisto;
		}
	 
	

	 
//--------------getts and setts---------------------------------------------------------------------------------

	public ArrayList<Aluno> getTodosAlunos() {
		return todosAlunos;
	}


	public void setTodosAlunos(ArrayList<Aluno> todosAlunos) {
		this.todosAlunos = todosAlunos;
	}


	public ArrayList<Aluno> getAlunosQueNaoPagou() {
		return alunosQueNaoPagou;
	}


	public void setAlunosQueNaoPagou(ArrayList<Aluno> alunosQueNaoPagou) {
		this.alunosQueNaoPagou = alunosQueNaoPagou;
	}


	public ArrayList<Aluno> getAlunosQueJaPagou() {
		return alunosQueJaPagou;
	}


	public void setAlunosQueJaPagou(ArrayList<Aluno> alunosQueJaPagou) {
		this.alunosQueJaPagou = alunosQueJaPagou;
	}
	
	
	
	
	 
	 
}
