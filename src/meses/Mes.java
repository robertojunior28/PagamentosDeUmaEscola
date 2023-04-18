package meses;

import java.util.ArrayList;
import java.util.List;

import modelos.Aluno;
import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;

public class Mes {
	
	private List<Aluno> janeiro;
	private List<Aluno> fevereiro;
	private List<Aluno> marco;
	private List<Aluno> abril;
	private List<Aluno> maio;
	private List<Aluno> junho;
	private List<Aluno> julho;
	private List<Aluno> agosto;
	private List<Aluno> setembro;
	private List<Aluno> outubro;
	private List<Aluno> novembro;
	private List<Aluno> dezembro;
	
	
	private double prejuizo;
	 
	private double lucro;
	 
	private double lucroEstimado = prejuizo + lucro;

	
	public Mes() {
		this.janeiro = new ArrayList<>();
	}
	
	public boolean adicionarJaneiro(Aluno aluno) {
		this.janeiro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarFevereiro(Aluno aluno) {
		this.fevereiro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarMarco(Aluno aluno) {
		this.marco.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarAbril(Aluno aluno) {
		this.abril.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarMaio(Aluno aluno) {
		this.maio.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarJunho(Aluno aluno) {
		this.junho.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	public boolean adicionarJulho(Aluno aluno) {
		this.julho.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarAgosto(Aluno aluno) {
		this.agosto.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarSetembro(Aluno aluno) {
		this.setembro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarOutubro(Aluno aluno) {
		this.outubro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarNovembro(Aluno aluno) {
		this.novembro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean adicionarDezembro(Aluno aluno) {
		this.dezembro.add(aluno);
		this.prejuizo += aluno.getMensalidade();
		MetodosPersistencia.salvarMeses(this);
		return true;
	}
	
	
	
	public boolean removerAluno(List<Aluno> alunos, Aluno aluno) {
		alunos.remove(aluno);
		this.lucro += aluno.getMensalidade();
		this.prejuizo -= aluno.getMensalidade();
		
		return true;
	}
	
	//-------------------------------------------------------------------------------------------------
	

	public double getPrejuizo() {
		return prejuizo;
	}

	public List<Aluno> getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(List<Aluno> janeiro) {
		this.janeiro = janeiro;
	}

	public List<Aluno> getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(List<Aluno> fevereiro) {
		this.fevereiro = fevereiro;
	}

	public List<Aluno> getMarco() {
		return marco;
	}

	public void setMarco(List<Aluno> marco) {
		this.marco = marco;
	}

	public List<Aluno> getAbril() {
		return abril;
	}

	public void setAbril(List<Aluno> abril) {
		this.abril = abril;
	}

	public List<Aluno> getMaio() {
		return maio;
	}

	public void setMaio(List<Aluno> maio) {
		this.maio = maio;
	}

	public List<Aluno> getJunho() {
		return junho;
	}

	public void setJunho(List<Aluno> junho) {
		this.junho = junho;
	}

	public List<Aluno> getJulho() {
		return julho;
	}

	public void setJulho(List<Aluno> julho) {
		this.julho = julho;
	}

	public List<Aluno> getAgosto() {
		return agosto;
	}

	public void setAgosto(List<Aluno> agosto) {
		this.agosto = agosto;
	}

	public List<Aluno> getSetembro() {
		return setembro;
	}

	public void setSetembro(List<Aluno> setembro) {
		this.setembro = setembro;
	}

	public List<Aluno> getOutubro() {
		return outubro;
	}

	public void setOutubro(List<Aluno> outubro) {
		this.outubro = outubro;
	}

	public List<Aluno> getNovembro() {
		return novembro;
	}

	public void setNovembro(List<Aluno> novembro) {
		this.novembro = novembro;
	}

	public List<Aluno> getDezembro() {
		return dezembro;
	}

	public void setDezembro(List<Aluno> dezembro) {
		this.dezembro = dezembro;
	}

	

	public void setPrejuizo(double prejuizo) {
		this.prejuizo = prejuizo;
	}

	public double getLucro() {
		return lucro;
	}

	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	public double getLucroEstimado() {
		return lucroEstimado;
	}

	public void setLucroEstimado(double lucroEstimado) {
		this.lucroEstimado = lucroEstimado;
	}

	
	
	
}
