package main;

import java.awt.Color;

import javax.swing.JFrame;

public class JanelaPadrao extends JFrame{
	
	public JanelaPadrao(String nomeTela) {
	
		setTitle(nomeTela);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(127,255,212));
	}
	
	

}
