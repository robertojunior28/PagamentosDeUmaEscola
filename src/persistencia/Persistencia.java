package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import meses.Mes;
import modelos.Aluno;





public class Persistencia {
	
	XStream xStream = new XStream(new DomDriver("UTF-8"));
    
		/**
		 * metodo salvar dados nos arquivos
		 * pegando o programa a ser salvo e o nome do arquivo 
		 * onde será salvo
		 * @param aluno recebe um aluno
		 * @param arquivoAlunos recebe um nome de arquivo existente
		 */
    public void salvarCentral(CentralDeInfomacoes aluno, String arquivoAlunos){
        try {
            File arquivo = new File(arquivoAlunos);
            arquivo.createNewFile();
            PrintWriter pW = new PrintWriter(arquivo, "UTF-8");
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            xml += xStream.toXML(aluno);
            pW.print(xml);
            pW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    	/**
     	*  esse método recupera se o arquivo existe pelo seu nome, caso não exista ele 
     	* lança uma exceção do tipo FileNotFoundException e cria uma nova central 
     	* @param nomeArquivo nome do arquivo
     	* @return retorna uma central
     	*/
    public CentralDeInfomacoes recuperarCentral(String nomeArquivo){
    	try {
    		File arquivo = new File(nomeArquivo);
    		xStream.allowTypes(new Class[] {CentralDeInfomacoes.class,Aluno.class});
    		if (arquivo.exists()) {
    			return (CentralDeInfomacoes) xStream.fromXML(new FileInputStream(arquivo));
    		}
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    		return new CentralDeInfomacoes();
    }

    
    
 //----------------------------MES----------------------------------------------------------------------  
    
    public void salvarMes(Mes aluno, String arquivoAlunos){
        try {
            File arquivo = new File(arquivoAlunos);
            arquivo.createNewFile();
            PrintWriter pW = new PrintWriter(arquivo, "UTF-8");
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            xml += xStream.toXML(aluno);
            pW.print(xml);
            pW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    	
    public Mes recuperarMes(String nomeArquivo){
    	try {
    		File arquivo = new File(nomeArquivo);
    		xStream.allowTypes(new Class[] {Mes.class,Aluno.class});
    		if (arquivo.exists()) {
    			return (Mes) xStream.fromXML(new FileInputStream(arquivo));
    		}
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    		return new Mes();
    }
}
