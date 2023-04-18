package modelos;

public class Aluno {
	
	private String nome;
	private String matricula;
	private double mensalidade;
	private String telefoneResponsavel;
	private String nomeResponsavel;
	private Endereco endereco;
	
	
	public Aluno() {}
	
	public Aluno(String nome, String matricula,String nomeResponsavel,String telefoneResponsavel, double mensalidade, Endereco endereco) {
		this.nome = nome;
		this.matricula = matricula;
		this.nomeResponsavel =  nomeResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;
		this.mensalidade = mensalidade;
		this.endereco = endereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public boolean equals(Aluno aluno) {
		return matricula.equals(aluno.matricula);
	}
	

}
