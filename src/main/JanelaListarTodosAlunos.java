package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelos.Aluno;
import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;
import persistencia.UtilidadesJanela;


public class JanelaListarTodosAlunos extends JanelaPadrao{
	
	private List<Aluno> alunos;
	private CentralDeInfomacoes central;
	private UtilidadesJanela tabela;
	
	public JanelaListarTodosAlunos() {
		super("Todos Alunos");
		setSize(500,500);
		conf();
		tabela();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public void conf() {
		
		central = MetodosPersistencia.obterCentral();
		
		JLabel textoInicial = new JLabel("Alunos Cadastrados");
		textoInicial.setForeground(Color.BLUE);
		textoInicial.setBounds(52,7,490,60);
		textoInicial.setFont(new Font("Arial",Font.BOLD, 40));
		add(textoInicial);
	
        JButton botaoDeletar = new JButton("Deletar");
        botaoDeletar.setBounds(60, 397, 150, 40);
        botaoDeletar.setForeground(Color.BLUE);
        botaoDeletar.setBackground(new Color(102,205,170));
        botaoDeletar.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
		
			 try {
	    		
				alunos = central.getTodosAlunos();
	    	   
	      	    Aluno aE = new Aluno();
	      	    aE.setMatricula(tabela.getIdmatricula());
	    	   
	    	    boolean achou = false;
	    	    
	    	    for(Aluno aluns: alunos) {
	    	    	if(aluns.equals(aE)) {
	    	    		achou = true;
	    	    		break;
	    	    	}else
	    	    		JOptionPane.showMessageDialog(null,"Aluno não encontrado!!");
	    	    }
	    	       if(achou == true) {
	    	    	  
	    	    	   central.deletarAluno(aE);
	    	    	  
	    	    	   tabela.getModelo().removeRow(tabela.getLinhaSelecionada());
	    	    	   tabela.getTabela().repaint();
	    	    	   JOptionPane.showMessageDialog(null,"Aluno " + tabela.getIdNome() + " removido com sucesso!");
	    	       }
	    	       
    	    } catch(Exception erro) {
    	    	erro.printStackTrace();
		    }
		}
    	
        }); 
        
        add(botaoDeletar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(277, 397, 150, 40);
        botaoCancelar.setForeground(Color.BLUE);
        botaoCancelar.setBackground(new Color(102,205,170));
        botaoCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoCancelar) {
					dispose();
				}
			}
        	
        });
        add(botaoCancelar);
	}
	
	public void tabela() {
		
		tabela = new UtilidadesJanela();
		
		central = MetodosPersistencia.obterCentral();
		
		alunos = central.getTodosAlunos();
		
		add(tabela.tab(alunos,15, 75, 455, 300));
	}
}
