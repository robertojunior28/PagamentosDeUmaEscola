package main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import persistencia.CentralDeInfomacoes;
import persistencia.MetodosPersistencia;

import javax.swing.*;

public class GraficoLucroEPrejuizo extends JanelaPadrao {
	private float previsto;
	private JLabel labelLP;
	
	
	public GraficoLucroEPrejuizo() {
		super("Relatório");
		setSize(500, 500);
		relatorio();
		//label();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/*private void label() {
		labelLP = new JLabel("Lucro previsto" + previsto);
		labelLP.setBounds(5, 20, 70, 30);
		add(labelLP);
		
	}*/

	private CentralDeInfomacoes central = MetodosPersistencia.obterCentral();
	
	public void relatorio() {
		
		float previsto = central.lucroPrevisto();
		float recebido = central.lucroRecebido();
		float prejuizo = previsto - recebido;
	
        // Criando um objeto DefaultPieDataset que representará os dados do gráfico
        DefaultPieDataset dataset = new DefaultPieDataset();
        // Adicionando os valores ao conjunto de dados
        
        dataset.setValue("Lucro Recebido", recebido);
        dataset.setValue("Prejuízo", prejuizo);

        // Criando um objeto JFreeChart passando o conjunto de dados e a configuração do gráfico como parâmetros
        JFreeChart chart = ChartFactory.createPieChart(
                "Lucro e Prejuízo", // Título do gráfico
                dataset // Conjunto de dados
        );

        // Obtendo a referência do plot do gráfico e personalizando o formato da legenda
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(null); // Desabilitando a exibição dos rótulos dos setores

        // Criando um objeto ChartPanel passando o objeto JFreeChart como parâmetro
        ChartPanel chartPanel = new ChartPanel(chart);

        // Criando uma janela para exibir o gráfico
        
        setContentPane(chartPanel);
        
	}
}