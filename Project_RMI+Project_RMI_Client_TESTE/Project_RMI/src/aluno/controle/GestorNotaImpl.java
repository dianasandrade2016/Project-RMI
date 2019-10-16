package aluno.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import aluno.modelo.Nota;

public class GestorNotaImpl {

	private List<Nota> notas = new ArrayList<Nota>();
		
	public GestorNotaImpl(){
		super();
	}
			
	public List<Nota> listarNotas() {

		FileReader arq; 
	    BufferedReader lerArq; 
	    	
	    try{
			arq = new FileReader("Notas.txt"); 
			lerArq = new BufferedReader(arq); 
							
			String s = lerArq.readLine();
					
		
			while (s != null) {
									
				String[] msg = s.split("	");
	               
	            int cod_aluno = Integer.parseInt( msg[0] );
	            int cod_disc = Integer.parseInt( msg[1] );
	            Double nota1 = Double.parseDouble( msg[2] );
	            Double nota2 = Double.parseDouble( msg[3] );
	            Double nota3 = Double.parseDouble( msg[4] );

				//a cada aluno carregado cria um Aluno e adiciona na Lista;
	                      
	            Double calc_media = (double) (nota1+nota2+nota3)/3 ;
	          
				notas.add( new Nota( cod_aluno, cod_disc, nota1, nota2, nota3, calc_media) );
					
				s = lerArq.readLine();
			}
			
			lerArq.close();

		}catch(Exception e){
			System.out.println(e.getMessage());
		
		}return notas;
	}
}