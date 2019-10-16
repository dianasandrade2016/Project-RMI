package aluno.tester;

import aluno.controle.GestorAlunosImpl;

public class Tester {

	public static void main(String[] args) {
		
		try {
			GestorAlunosImpl g = new GestorAlunosImpl();
			// Ok;
			//g.consultar_nota(2011785081,"TM417 - Otimizacao Linear");
			
			// Problema não exibe as notas só aparece quando colocado o metodo listar()  no metodo de consultar_notas
			//g.consultar_notas(2011785081);
			
			// OK
			g.consultar_cr(2011785081);
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

