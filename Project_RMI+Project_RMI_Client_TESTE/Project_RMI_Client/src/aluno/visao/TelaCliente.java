package aluno.visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aluno.interfac.GestorAlunos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import java.rmi.Naming;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConectar;
	private JLabel lblStatus;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblOpes;


	private GestorAlunos gestor;
	
	public static void main(String[] args) {

				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		contentPane.add(getBtnConectar());
		contentPane.add(getLblStatus());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getBtnNewButton_3());
		contentPane.add(getLblOpes());
	}

	private JButton getBtnConectar() {
		if (btnConectar == null) {
			btnConectar = new JButton("Conectar");
			btnConectar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						// o processo cliente obtém a referência ao objecto remoto através do 
						// método Naming.lookup(), invocando de seguida o método remoto.
						gestor = (GestorAlunos) Naming.lookup("rmi://localhost/GestorAlunos");
						// localizacao do stub no lookup = endereço     
						// método devolve uma referência remota do objeto, através do envio do stub 

				        lblStatus.setText("Conectado");
				        
				        System.out.println("OK");
				        
					}catch(Exception e1) {
						lblStatus.setText(" Nao foi possivel Conectar ");
						e1.printStackTrace();
					}
				}
			});
			btnConectar.setBounds(10, 11, 89, 23);
		}
		return btnConectar;
	}
	private JLabel getLblStatus() {
		if (lblStatus == null) {
			lblStatus = new JLabel("Status");
			lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
			lblStatus.setBounds(10, 36, 414, 14);
		}
		return lblStatus;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Consultar CR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TelaConsultarCr( gestor ).setVisible(true);
					
				}
			});
			btnNewButton.setBounds(10, 126, 414, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Consultar Notas");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TelaConsultarNotas( gestor ).setVisible(true); 
				}
			});
			btnNewButton_1.setBounds(10, 160, 414, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Consultar Nota");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TelaConsultarNota( gestor ).setVisible(true);
				}
			});
			btnNewButton_2.setBounds(10, 194, 414, 23);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Cadastrar Nota");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TelaCadastrarNota( gestor ).setVisible(true);	
				}
			});
			btnNewButton_3.setBounds(10, 228, 414, 23);
		}
		return btnNewButton_3;
	}
	private JLabel getLblOpes() {
		if (lblOpes == null) {
			lblOpes = new JLabel("Op\u00E7\u00F5es:");
			lblOpes.setBounds(10, 92, 46, 14);
		}
		return lblOpes;
	}
}
