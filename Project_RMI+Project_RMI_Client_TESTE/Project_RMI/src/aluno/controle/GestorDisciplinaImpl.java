package aluno.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import aluno.modelo.Disciplina;

public class GestorDisciplinaImpl {

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
	public GestorDisciplinaImpl(){
		super();
	}
	
	public List<Disciplina> listarDisc() {

		FileReader arq; 
	    BufferedReader lerArq; 
	    	
	    try{
			arq = new FileReader("Disciplinas.txt"); 
			lerArq = new BufferedReader(arq); 
							
			String s = lerArq.readLine().replaceAll(" ","");
					
		
			while (s != null) {
									
				String[] msg = s.split("	");
	               
	               //String matricula = msg[0];//matricula sendo registrada pelo contador

	            String cod = msg[0];
	            String nomeDisc = msg[1];

	                
				//System.out.println("("+contador+") "+contador +" "+ nome+" "+nota1+" "+nota2+" "+nota3+" ");

				//a cada aluno carregado cria um Aluno e adiciona na Lista;
				Disciplina d = new Disciplina();
				d.setCod_disc( Integer.parseInt( cod ) );
				d.setNomeDisciplina( nomeDisc );

					
				disciplinas.add(d);
					
				s = lerArq.readLine();
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		
		}return disciplinas;
	}
}


