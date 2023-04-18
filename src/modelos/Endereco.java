package modelos;

public class Endereco {
	
	private String rua;
	private String numero;
	private String CEP;
	private String cidade;
	private String bairro;
	
	public Endereco(String rua,String numero,String cidade,String bairro) {
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.rua = rua;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String toString() {
		return " Rua: "+ rua + ", Numero: " + numero + ", Cidade: " + cidade + ", Bairro: " + bairro;
	}
	
	

}
