package aluno.visao;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aluno.interfac.GestorAlunos;

import aluno.modelo.Aluno;
import aluno.modelo.Nota;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaConsultarCr extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel lblCodigo;
	private JTextField textFieldMat;

	private JLabel lblStatus;
	
	private JLabel lblCr;
	private JTextField textFieldCr;

	private JButton btnNewButton;
	
	private GestorAlunos gestor;

	List<Nota> notas = new ArrayList<Nota>();

	public TelaConsultarCr(GestorAlunos gestor) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		contentPane.add(getLblCodigo());
		contentPane.add(getTextFieldMat());
		
		contentPane.add(getLblStatus());
		
		contentPane.add(getTextFieldCr());
		contentPane.add(getLblCr());
		
		contentPane.add(getBtnNewButton());
		
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
			textFieldMat = new JTextField();
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
	
	private JLabel getLblCr() {
		if (lblCr == null) {
			lblCr = new JLabel("CR:");
			lblCr.setBounds(10, 86, 46, 14);
		}
		return lblCr;
	}
	private JTextField getTextFieldCr() {
		if (textFieldCr== null) {
			textFieldCr = new JTextField("");
			textFieldCr.setBounds(10, 100, 315, 20);
			textFieldCr.setColumns(10);
		}
		return textFieldCr;
	}
	
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent arg0) {
					
				try {
					
					String c = gestor.consultar_cr(Integer.parseInt(textFieldMat.getText()));
					
					if(c==null){
						textFieldCr.setText("");
						lblStatus.setText("sem nota para a matricula");
						
					}else{
						textFieldCr.setText(c);
						lblStatus.setText("Encontrado");
					}
						
					
									
				}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
			}); btnNewButton.setBounds(335, 28, 89, 23);
		}return btnNewButton;
	}
}