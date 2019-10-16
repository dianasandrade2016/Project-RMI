package aluno.visao;
import java.rmi.Naming;
import aluno.interfac.GestorAlunos;

public class Tester {

	public static void main(String[] args) {
		
		try {
			GestorAlunos g = (GestorAlunos) Naming.lookup("rmi://localhost/GestorAlunos");
				
			System.out.println( g.consultar_notas(2011785081).size() );
			System.out.println( g.consultar_cr(2011785081));
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
