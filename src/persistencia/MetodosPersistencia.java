package persistencia;

import meses.Mes;
import modelos.NomeDoArquivo;

public class MetodosPersistencia {

	public static CentralDeInfomacoes obterCentral() {
		Persistencia persistencia = new Persistencia();
		CentralDeInfomacoes central = persistencia.recuperarCentral(NomeDoArquivo.nomeDoArquivo());
		
		return central;
	}
	
	public static void salvarCentral(CentralDeInfomacoes central) {
		Persistencia persistencia = new Persistencia();
		persistencia.salvarCentral(central, NomeDoArquivo.nomeDoArquivo());
	}
	
	
//----------------------------MES-------------------------------------------------------------
	
	public static Mes obterMeses() {
		Persistencia persistencia = new Persistencia();
		Mes mes = persistencia.recuperarMes(NomeDoArquivo.nomeDoArquivoDosMeses());
		
		return mes;
	}
	
	public static void salvarMeses(Mes mes) {
		Persistencia persistencia = new Persistencia();
		persistencia.salvarMes(mes, NomeDoArquivo.nomeDoArquivoDosMeses());
	}
}
