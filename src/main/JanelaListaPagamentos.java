package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;
import persistencia.UtilidadesJanela;
import javax.swing.JButton;

public class JanelaListaPagamentos extends JanelaPadrao {
	
	private CentralDeInfomacoes central;
	private UtilidadesJanela tabela;
	private JButton btAdicionarPago;
	private JButton btAdicionarNaoPago;
	private JButton btVoltar;
	private JLabel textoInicial;
	private JLabel textoNaoPagou;
	private JLabel textoPagou;
	
	public JanelaListaPagamentos() {
		super("Lista Pagamentos");
		setSize(1025,500);
		lista();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JButton button(String nomeDoBotão, int x,int y, int lag, int alt) {
		 JButton botao = new JButton(nomeDoBotão);
		 botao.setBounds(x, y, lag, alt);
		 botao.setForeground(Color.BLUE);
		 botao.setBackground(new Color(102,205,170));
	     return botao;
	}
	
	public JLabel txt(String nomeTxt, int x,int y, int lag, int alt, int tamFont) {
	
		JLabel texto = new JLabel(nomeTxt);
		texto.setForeground(Color.BLUE);
		texto.setBounds(x,y,lag,alt);
		texto.setFont(new Font("Arial",Font.BOLD, tamFont));
		return texto;
	}
	
	public void lista() {
		
		textoInicial = txt("Lista de Pagamentos",217,5,600,60,55);
		add(textoInicial);
		
		textoPagou = txt("Alunos inadimplentes",136,70,300,20,20);
		add(textoPagou);
		
		textoNaoPagou = txt("Alunos adimplentes",680,70,300,20,20);
		add(textoNaoPagou);
		
		tabela = new UtilidadesJanela();
		
		central = MetodosPersistencia.obterCentral();
		
		add(tabela.tab(central.getAlunosQueNaoPagou(), 15, 95, 455, 300));
		
		add(tabela.tab(central.getAlunosQueJaPagou(), 540, 95, 455, 300));
		
		 btAdicionarPago = button(">",474, 170, 60, 40);
		 add(btAdicionarPago);
		 
	        
	    btAdicionarNaoPago = button("<", 474, 250, 60, 40);
	    add(btAdicionarNaoPago);
		
	
        btVoltar = button("Voltar",415, 407, 150, 40);
        add(btVoltar);
        
	}
}
