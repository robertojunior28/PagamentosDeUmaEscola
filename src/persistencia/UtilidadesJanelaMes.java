package persistencia;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Aluno;

public class UtilidadesJanelaMes {
	
	private DefaultTableModel modelo;
	private JTable tabela;
	private String idmatricula;
	private String idNome;
	private int linhaSelecionada;
	
	public JScrollPane tab(List<Aluno> alunos, int x, int y, int lag, int alt) {

	      //colunas da lista 
	      modelo  = new DefaultTableModel();
	      modelo.addColumn("Nome");
	      modelo.addColumn("Matricula");
	      modelo.addColumn("Telefone");
	      modelo.addColumn("Mensalidade");
	      
			if(alunos != null && alunos.size() > 0 ){
            
        	for(Aluno aluno : alunos){
               
        		Object[] linha = new Object[4];
                
                linha[0] = aluno.getNome();
                linha[1] = aluno.getMatricula();
                linha[2] = aluno.getTelefoneResponsavel();
                linha[3] = aluno.getMensalidade();
               
                modelo.addRow(linha);
            }
        }    
	        
        tabela = new JTable(modelo);
        
        tabela.addMouseListener(new MouseListener() {
			
				public void mouseReleased(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				
				public void mouseClicked(MouseEvent e) {
				
					linhaSelecionada = tabela.getSelectedRow();
					
					if(linhaSelecionada != -1) {
						idmatricula = tabela.getValueAt(linhaSelecionada, 1).toString();
						idNome = tabela.getValueAt(linhaSelecionada, 0).toString();
					}else {
						JOptionPane.showMessageDialog(null, "Selecione um aluno");
					}
		            tabela.repaint();
				}
			});
	        JScrollPane painelTabela = new JScrollPane(tabela, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			for(int i = 0; i < 4; i++) {
				tabela.getColumnModel().getColumn(i).setPreferredWidth(145);
			}
	        painelTabela.setBounds(x, y, lag, alt);
	      
	        return painelTabela;
	}
	
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

	public JTable getTabela() {
		return tabela;
	}
}
