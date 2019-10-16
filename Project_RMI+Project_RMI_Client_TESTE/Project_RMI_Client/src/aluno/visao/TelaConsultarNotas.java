package aluno.visao;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aluno.interfac.GestorAlunos;

import aluno.modelo.Nota;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TelaConsultarNotas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField textFieldMat;

	private JLabel lblStatus;
	
	private JButton btnNewButton;
	
	private GestorAlunos gestor;

	private JLabel lblAluno;
	
	List<Nota> notas = new ArrayList<Nota>();

	private JScrollPane scrollPane;
	private JTextPane textPane;
	
	public TelaConsultarNotas(GestorAlunos gestor) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getLblCodigo());
		contentPane.add(getTextFieldMat());
	
		contentPane.add(getLblStatus());
		
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblAluno());
		contentPane.add(getScrollPane());
		
		this.gestor = gestor;
	}

	
	private JLabel getLblCodigo() {
		if (lblCodigo == null) {
			lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 11, 414, 14);
		}
		return lblCodigo;
	}
	private JTextField getTextFieldMat() {
		if (textFieldMat == null) {
			textFieldMat = new JTextField("");
			textFieldMat.setBounds(10, 29, 315, 20);
			textFieldMat.setColumns(10);
		}
		return textFieldMat;
	}
		
	private JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Status");
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setBounds(10, 236, 414, 14);
		}
		return lblStatus;
	}
	
	
	private JLabel getLblAluno() {
		if (lblAluno == null) {
			lblAluno = new JLabel(" Disciplinas - Nota1 - Nota2 - Nota3: ");
			lblAluno.setBounds(10, 60, 414, 14);
		}
		return lblAluno;
	}
	

	String[] disc = {"TM406-Calculo Aplicado      ",
					 "TM417-Otimizacao Linear     ",
					 "IM471-Analise de algoritmos ",
					 "TM421-Computacao Grafica    ",
					 "TM412-Modelagem de Sistemas "};
	
	private JButton getBtnNewButton() {
		
		if (btnNewButton == null) {
			
			btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					textPane.setText("");
				
					try {
						notas = gestor.consultar_notas(Integer.parseInt( textFieldMat.getText()));
						
						for(Nota n: notas) {
							String disciplina = null; 
							
							
					        switch(n.getCod_disc()){
					           	case 1:
					        		disciplina = disc[0];
					                break;
					          
					            case 2:
					            	disciplina = disc[1];
					                break;
					            case 3:
					            	disciplina = disc[2];
					                break;
						            
					            case 4:
					            	disciplina = disc[3];
					                break;
					            case 5:
					            	disciplina = disc[4];
					                break;
					        }
					               
							textPane.setText(textPane.getText()+ "\n" + disciplina +
									" - " + String.valueOf( n.getNota1() )+
									" - " + String.valueOf( n.getNota2() )+
									" - " + String.valueOf( n.getNota3() ));	
						}
						
						
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
			});
			btnNewButton.setBounds(335, 28, 89, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 104, 347, 103);
			scrollPane.setViewportView(getTextPane());
		}
		return scrollPane;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
		}
		return textPane;
	}
}

