package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import meses.Mes;
import modelos.Aluno;
import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;
import persistencia.UtilidadesJanela;
import persistencia.UtilidadesJanelaMes;

public class JanelaLucroPrejuizoPorMes extends JanelaPadrao{

	private UtilidadesJanelaMes tabela;
	private DefaultTableModel modelo; 
	private String idmatricula;
	private String idNome;
	private int linhaSelecionada;
	
	private List<Aluno> alunos;
	
	private Mes mes = MetodosPersistencia.obterMeses();
	
	private JLabel titulo;
	
	private JComboBox<String[]> comboMeses;
	
	private JButton botaoOK;
	
	private JButton botaoPagou;
	
	private JButton botaoVoltar;

	private JButton botaoVerGafico;
	
	public JanelaLucroPrejuizoPorMes() {
		super("Relatorio Mensal");
		setSize(500, 500);
		setLocationRelativeTo(null);
		labelTitulo();
		adicionarCombo();
		adicionarBotoes();
		
		setVisible(true);
		repaint();
		
	}



	


	private void adicionarCombo() {
		String[] listaMeses =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novenbro", "Dezembro" };
		comboMeses = new JComboBox(listaMeses);
		comboMeses.setBounds(20, 75, 87, 20);
		add(comboMeses);
		
		
		
	}



	private void labelTitulo() {
		titulo = new JLabel("Relatório Mensal");
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(75, 20, 400, 30);
		titulo.setFont(new Font("Arial",Font.BOLD, 40));
		add(titulo);
		
	}
	

	
	private void adicionarBotoes() {
		
		botaoOK = new JButton("OK");
		botaoOK.setBounds(110, 75, 52, 20);
		botaoOK.setForeground(Color.BLUE);
        botaoOK.setBackground(new Color(102,205,170));
        botaoOK.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent e) {
    				
    			 String selecionado = (String)comboMeses.getSelectedItem();
    			 if(selecionado.equals("Janeiro")) {
    				 alunos = mes.getJaneiro();
    			 }else if(selecionado.equals("Fevereiro")) {
    				 alunos = mes.getFevereiro();
    			 }else if(selecionado.equals("Março")) {
    				 alunos = mes.getMarco();
    			 }else if(selecionado.equals("Abril")) {
    				 alunos = mes.getAbril();
    			 }else if(selecionado.equals("Maio")) {
    				 alunos = mes.getMaio();
    			 }else if(selecionado.equals("Junho")) {
    				 alunos = mes.getJunho();
    			 }else if(selecionado.equals("Julho")) {
    				 alunos = mes.getJulho();
    			 }else if(selecionado.equals("Agosto")) {
    				 alunos = mes.getAgosto();
    			 }else if(selecionado.equals("Setembro")) {
    				 alunos = mes.getSetembro();
    			 }else if(selecionado.equals("Outubro")) {
    				 alunos = mes.getOutubro();
    			 }else if(selecionado.equals("Novembro")) {
    				 alunos = mes.getNovembro();
    			 }else {
    				 alunos = mes.getDezembro();
    			 }
    			
    			 adicionarTabela();
    			tabela.getModelo().fireTableDataChanged();
    		}
        	
            }); 
        this.add(botaoOK);
		
		
		botaoPagou = new JButton("Pagou");
		botaoPagou.setBounds(60, 420, 100, 30);
		botaoPagou.setForeground(Color.BLUE);
        botaoPagou.setBackground(new Color(102,205,170));
        botaoPagou.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent e) {
    		
    			 try {
    		      	    Aluno aE = new Aluno();
    		      	    aE.setMatricula(tabela.getIdmatricula());
    		    	   
    		    	    boolean achou = false;
    		    	    
    		    	    for(Aluno aluns: alunos) {
    		    	    	if(aluns.equals(aE)) {
    		    	    		achou = true;
    		    	    		alunos.remove(aE);
    		    	    		mes.removerAluno(alunos, aluns);
    		    	    		MetodosPersistencia.salvarMeses(mes);
    		    	    		break;
    		    	    	}else
    		    	    		JOptionPane.showMessageDialog(null,"Aluno não encontrado!!");
    		    	    }
    		    	       if(achou == true) {
    		    	    	   
    		    	    	  
   
    		    	    	   
    		    	    	   tabela.getModelo().removeRow(tabela.getLinhaSelecionada());
    		    	    	   tabela.getTabela().repaint();
    		    	    	   JOptionPane.showMessageDialog(null,"Aluno " + tabela.getIdNome() + " removido com sucesso!");
    		    	       }
    		    	       
    	    	    } catch(Exception erro) {
    	    	    	erro.printStackTrace();
    			    }
    		}
        	
            }); 
        add(botaoPagou);
		
		
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(320, 420, 100, 30);
		
		botaoVoltar.setForeground(Color.BLUE);
        botaoVoltar.setBackground(new Color(102,205,170));
        botaoVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoVoltar) {
					dispose();
					//new MenuPrincipal();
				}
			}
        	
        });
        add(botaoVoltar);
        
        
        botaoVerGafico = new JButton("Ver Gráfico");
        botaoVerGafico.setBounds(373, 75, 100, 20);
        botaoVerGafico.setForeground(Color.BLUE);
        botaoVerGafico.setBackground(new Color(102,205,170));
        botaoVerGafico.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == botaoVerGafico) {
					
					new GraficoLucroEPrejuizo();
				}
			}
        	
        });
        add(botaoVerGafico);
	}
	
	
	
	
	
	
	private void adicionarTabela() {
		
		tabela = new UtilidadesJanelaMes();
		
		this.add(tabela.tab(alunos, 20, 100, 455, 300));
		tabela.getTabela().repaint();
	}

	
	
	//-----------------------------------------------------------------------------------------
	
	
	public String getIdmatricula() {
		return idmatricula;
	}

	public String getIdNome() {
		return idNome;
	}
	
	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	

	
}
