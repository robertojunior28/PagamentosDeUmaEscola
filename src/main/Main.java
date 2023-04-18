package main;

import java.util.Scanner;

import exception.AlunoJaAdimplenteExpection;
import exception.AlunoJaCadastradoExpection;
import exception.AlunoNaoEncontradoException;
import exception.ListaVaziaException;
import modelos.Aluno;
import modelos.Endereco;
import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;

public class Main {
	
	
	public static void main(String[] args) throws AlunoJaCadastradoExpection, AlunoNaoEncontradoException, ListaVaziaException {
		
		
		Scanner sc = new Scanner(System.in);
		int entrada = Integer.MAX_VALUE;
		CentralDeInfomacoes central = MetodosPersistencia.obterCentral();
		
		while(entrada != 6) {
			
			System.out.println("Escolha uma das opções para seguir: ");
			System.out.println("1 - Cadastrar um aluno. ");
			System.out.println("2 - Listar de Pagamentos.");
			System.out.println("3 - Listar todos os alunos. ");
			System.out.println("4 - Zerar as listas de quem pagou e de quem ainda não pagou.");
			System.out.println("5 - Gerar relatório");
			System.out.println("6 - para sair do sistema. ");
			
			entrada = Integer.parseInt(sc.nextLine());
			
			switch (entrada) {
			
			
			case 6: {
				System.out.println("PROGRAMA ENCERRADO");
				sc.close();
				break;
			}
			case 1:{
				
				System.out.println("Digite o nome do aluno ou 0 para voltar ao menu: ");
				String nome = sc.nextLine();
				
				if(nome.equals("0")) {
					continue;
				}
				System.out.println("Digite a matrícula do aluno: ");
				String matricula = sc.nextLine();
				
				if(matricula.equals("0")) {
					continue;
				}
				
				System.out.println("Digite o nome do responsável do aluno: ");
				String responsavel = sc.nextLine();
				
				if(responsavel.equals("0")) {
					continue;
				}
				
				System.out.println("Digite o telefone do responsável do aluno: ");
				String telefone = sc.nextLine();
				
				if(telefone.equals("0")) {
					continue;
				}
				
				System.out.println("Digite o valor da mensalidade do aluno: ");
				Double mensalidade = Double.parseDouble(sc.nextLine());
				
				if(mensalidade.equals("0")) {
					continue;
				}
				
				System.out.println("------Dados do Endereço do aluno-----");
				
				System.out.println("Rua: ");
				String rua = sc.nextLine();
				
				if(rua.equals("0")) {
					continue;
				}
				
				System.out.println("Cidade: ");
				String cidade = sc.nextLine();
				
				if(cidade.equals("0")) {
					continue;
				}
				
				System.out.println("Bairro: ");
				String bairro = sc.nextLine();
				
				if(bairro.equals("0")) {
					continue;
				}
				
				System.out.println("Numero: ");
				String numero = sc.nextLine();
				
				if(numero.equals("0")) {
					continue;
				}
				
				Endereco endereco = new Endereco(rua,numero,cidade,bairro);
			
				Aluno aluno = new Aluno(nome, matricula,responsavel,telefone,mensalidade,endereco);
				
				try {
					central.adicionarAluno(aluno);
					System.out.println("Aluno cadastrado com sucesso!");
				} catch (AlunoJaCadastradoExpection e) {
					e.getMessage();
				}
				break;
				
			}
			case 2:{
				new JanelaListaPagamentos();
				break;
				
			}
			case 3:{
				new JanelaListarTodosAlunos();
				break;
				
			}
			case 4:{
				try {
					central.reiniciarOsPagamentosDoMes();
					System.out.println("Listas zeradas");
				} catch (AlunoNaoEncontradoException e) {
					e.getMessage();
				}
				break;
			}
			case 5:
				new GraficoLucroEPrejuizo();
				break;
			
			default:
				System.out.println("Entrada --> "+ entrada + " <-- invalida, digite uma entrada válida!");
			}
	 
		}
		
	}
	
	

}
