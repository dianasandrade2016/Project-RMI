package aluno.visao;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aluno.interfac.GestorAlunos;
import aluno.modelo.Aluno;
import aluno.modelo.Nota;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


public class TelaCadastrarNota extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField textFieldMat;
	private JLabel lblDisciplina;
	private JComboBox<String> comboBoxDisc;
	private JLabel lblStatus;
	private JLabel lblNota;
	private JTextField textField_1;
	private JLabel lblNota_1;
	private JTextField textField_2;
	private JLabel lblNota_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private GestorAlunos gestor;
	private JLabel lblAluno;
	private JTextField textFieldAluno;
	private JButton btnNewButton_1;
	
	List<Nota> notas = new ArrayList<Nota>();
	
	public TelaCadastrarNota(GestorAlunos gestor) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getLblCodigo());
		contentPane.add(getTextFieldMat());
		contentPane.add(getLblDisciplina());
		contentPane.add(getComboBoxDisc());
		contentPane.add(getLblStatus());
		contentPane.add(getLblNota());
		contentPane.add(getTextField_1());
		contentPane.add(getLblNota_1());
		contentPane.add(getTextField_2());
		contentPane.add(getLblNota_2());
		contentPane.add(getTextField_3());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblAluno());
		contentPane.add(getTextFieldAluno());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnAlterar());
		
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
			textFieldMat = new JTextField("2011785081");
			textFieldMat.setBounds(10, 29, 315, 20);
			textFieldMat.setColumns(10);
		}
		return textFieldMat;
	}
	private JLabel getLblDisciplina() {
		if (lblDisciplina == null) {
			lblDisciplina = new JLabel("Disciplina(s)");
			lblDisciplina.setBounds(10, 109, 414, 14);
		}
		return lblDisciplina;
	}
	private JComboBox<String> getComboBoxDisc() {
		if (comboBoxDisc == null) {
			comboBoxDisc = new JComboBox<String>();
			comboBoxDisc.setBounds(10, 134, 315, 20);
		}
		return comboBoxDisc;
	}
	private JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Status");
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			lblStatus.setBounds(10, 236, 414, 14);
		}
		return lblStatus;
	}
	private JLabel getLblNota() {
		if (lblNota == null) {
			lblNota = new JLabel("Nota1:");
			lblNota.setBounds(10, 165, 46, 14);
		}
		return lblNota;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(10, 182, 46, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNota_1() {
		if (lblNota_1 == null) {
			lblNota_1 = new JLabel("Nota2:");
			lblNota_1.setBounds(66, 165, 46, 14);
		}
		return lblNota_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(66, 182, 46, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblNota_2() {
		if (lblNota_2 == null) {
			lblNota_2 = new JLabel("Nota3");
			lblNota_2.setBounds(122, 165, 46, 14);
		}
		return lblNota_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(122, 182, 46, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	
	String[] disc = {" TM406-Calculo Aplicado "," TM417-Otimizacao Linear "," IM471-Analise de algoritmos "," TM421-Computacao Grafica "," TM412-Modelagem de Sistemas "};
	
	private JButton btnAlterar;
	
	int cod_disc_selecionada = 0;
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					comboBoxDisc.removeAllItems();
				
					try {
						notas = gestor.consultar_notas(Integer.parseInt( textFieldMat.getText()));
						Aluno a = gestor.consultarAluno( Integer.parseInt( textFieldMat.getText()));
				
						if(a==null) {
							lblStatus.setText("Nenhum Aluno Encontrado!");
							textFieldAluno.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						
						}else {
							textFieldAluno.setText( a.getNome());
							lblStatus.setText("Aluno Encontrado!");
						}						
						
						for(Nota n : notas) {
							int disciplina; disciplina = n.getCod_disc();
							
					        switch(disciplina){
					            
					        	case 1:
					        		comboBoxDisc.addItem(disc[0]);
					                break;
					          
					            case 2:
					            	comboBoxDisc.addItem(disc[1]);
					                break;
					            case 3:
					            	comboBoxDisc.addItem(disc[2]);
					                break;
						            
					            case 4:
					            	comboBoxDisc.addItem(disc[3]);
					                break;
					            case 5:
					            	comboBoxDisc.addItem(disc[4]);
					                break;
					        }
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
			});
			btnNewButton.setBounds(335, 28, 89, 23);
		}
		return btnNewButton;
	}
	private JLabel getLblAluno() {
		if (lblAluno == null) {
			lblAluno = new JLabel("Aluno:");
			lblAluno.setBounds(10, 60, 414, 14);
		}
		return lblAluno;
	}
	private JTextField getTextFieldAluno() {
		if (textFieldAluno == null) {
			textFieldAluno = new JTextField();
			textFieldAluno.setBounds(10, 78, 414, 20);
			textFieldAluno.setColumns(10);
		}
		return textFieldAluno;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("OK");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nomeDisc = "";
					if( comboBoxDisc.getSelectedItem()==null ) {
						lblStatus.setText("Selecione a Disciplina!");
					}else {
						nomeDisc = comboBoxDisc.getSelectedItem().toString();
						for(int i=0;i<disc.length;i++) {

							if(disc[i].equals(nomeDisc)) {
								
								
								for(Nota n : notas) {
									if(n.getCod_disc()==i+1) {
										textField_1.setText( String.valueOf( n.getNota1() ) );
										textField_2.setText( String.valueOf( n.getNota2() ) );
										textField_3.setText( String.valueOf( n.getNota3() ) );
										
										cod_disc_selecionada = n.getCod_disc();
									}
								}
							}
						}
					}			
				}
			});
			
			btnNewButton_1.setBounds(335, 134, 89, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton("Alterar");
			btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						gestor.cadastrar_nota(Integer.parseInt( textFieldMat.getText() ), cod_disc_selecionada,
								Double.parseDouble( textField_1.getText() ),
								Double.parseDouble( textField_2.getText() ),
								Double.parseDouble( textField_3.getText() ) );
					} catch (NumberFormatException | RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnAlterar.setBounds(335, 227, 89, 23);
		}
		return btnAlterar;
	}
}
