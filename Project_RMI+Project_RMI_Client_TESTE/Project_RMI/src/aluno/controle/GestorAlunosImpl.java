package aluno.controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.util.List;

import aluno.interfac.GestorAlunos;

import aluno.modelo.Aluno;
import aluno.modelo.Disciplina;
import aluno.modelo.Nota;

// Criar uma classe que implementa a interface remota GestorAlunos
		
public class GestorAlunosImpl extends UnicastRemoteObject implements GestorAlunos {

	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public GestorAlunosImpl() throws RemoteException {
		super();
	}
	
	private static final long serialVersionUID = 1179227415408023062L;
		
	
	@Override
	public Aluno consultarAluno(int codigo) {
		
		Aluno aluno = null;
		for(int i = 0; i < alunos.size(); i++) {
			
			if( alunos.get(i).getCodigo() == codigo ) {
				aluno = alunos.get(i);
			}
		}return aluno;
	}
	
	@Override
	public List<Aluno> listar() {
		
		FileReader arq; 
    	BufferedReader lerArq; 
    	
    	try{
			arq = new FileReader("Alunos.txt"); 
			lerArq = new BufferedReader(arq); 
						
			String s = lerArq.readLine();
				
		
			while (s != null) {
					
				String[] msg = s.split("	");
                String matricula = msg[0];
                String nome = msg[1];
                
				//a cada aluno carregado cria um Aluno e adiciona na Lista;
				Aluno a = new Aluno();
				a.setCodigo( Integer.parseInt( matricula ) );
				a.setNome( nome );
				
				alunos.add(a);
				
				s = lerArq.readLine();
            }

		}catch(Exception e){
			System.out.println(e.getMessage());
	
		}
		
		return alunos;
	}
	
	@Override
	public String consultar_nota(int mat, String disciplina) {
		listar();

		System.out.println(" TESTER procurando nota");
	
		String resultado ="nada";
		
		for(Aluno a: alunos) {

			if(a.getCodigo()==mat){
			
				resultado= "Matricula Encontrada";

				GestorDisciplinaImpl g = new GestorDisciplinaImpl();
				
				for(Disciplina d: g.listarDisc()) {
					
					if(d.getNomeDisciplina().equals(disciplina)) {
						
						System.out.println("Disciplina Encontrada");
												
						GestorNotaImpl notas = new GestorNotaImpl();
						for(Nota nota: notas.listarNotas()) {
							
							if(nota.getCod_aluno()==a.getCodigo()) {
								
								if(nota.getCod_disc()==d.getCod_disc()) {
									
									System.out.println("Notas Encontradas p/ a Disciplina informada");
									System.out.println(a.getNome()+" - "+d.getNomeDisciplina()+" - "+nota.getNota1()+
											" - "+nota.getNota2()+" - "+nota.getNota3());
									
									//resultado = a.getNome()+" - "+d.getNomeDisciplina()+" - "+nota.getNota1()+" - "+nota.getNota2()+" - "+nota.getNota3();
								}
							}
						}
					}
				}	
			}
		}return  resultado;
	}
	
	@Override
	public List<Nota> consultar_notas(int mat) {
				
		List<Nota> alunoNotas = new ArrayList<Nota>();
		
		for(Aluno a: alunos) {

			if(a.getCodigo() == mat){
												
				GestorNotaImpl notas = new GestorNotaImpl();
				
				for(Nota nota: notas.listarNotas()) {
							
					if(nota.getCod_aluno()==a.getCodigo()) {

						Nota n = new Nota();
						
						n.setCod_aluno(nota.getCod_aluno());
						n.setCod_disc(nota.getCod_disc());
						n.setNota1(nota.getNota1());
						n.setNota2(nota.getNota2());
						n.setNota3(nota.getNota3());
						n.setMedia(nota.getMedia());
						alunoNotas.add(n);
						
						System.out.println(n.getCod_aluno() + " - " + n.getCod_disc()+" - "+ n.getNota1() +
								" - "+n.getNota2()+" - "+n.getNota3()+" = "+n.getMedia());
					}
				}	
			}
		}return  alunoNotas;
	}
	
	@Override
	public String consultar_cr(int mat) {
		Double cr = 0.0;
		int cont = 0;
		
		String saida=null;
		
		List<Nota> notas = consultar_notas(mat);
		System.out.println(notas.size());
		if(notas.size()<=0) {
			System.out.println("sem nota para a matricula");
			
		}
		else {
			System.out.println("nota encontrada");
			saida = "nota encontrada";
			
			for(Nota nota: consultar_notas(mat)) {
				cont++;		
				cr = cr + nota.getMedia();
			}
			saida = String.valueOf(cr/cont);
		}
		
		return saida;
	}
		
	@Override
	public String cadastrar_nota(int cod_aluno,int cod_disc,Double n1,Double n2,Double n3){
	
		String status ="" ;

		try{
	
			File arq = new File("Notas.tmp");

			FileWriter fileWriter = new FileWriter(arq, false);
	        PrintWriter printWriter = new PrintWriter(fileWriter);
	        
	        GestorNotaImpl notas = new GestorNotaImpl();
	        
	        List<Nota> listaNotas = notas.listarNotas();
	        
	        
	        boolean alterou = false;
			
	        for(Nota nota: listaNotas) { //FOR para recriar o arquivo de notas
				
				if(nota.getCod_aluno()==cod_aluno ) { //procura na lista de notas  o aluno informado!
					
					if(nota.getCod_disc()==cod_disc ) { //com o aluno encontrado verifica o codigo da disciplina informada!
					
						printWriter.println(nota.getCod_aluno()+"	"+nota.getCod_disc()+"	"+n1+"	"+n2+"	"+n3); //altera apenas a disciplina informada

						alterou = true;//isso e caso encontre a disciplina, nao copie a linha antiga, somente a nova
						
						status = "Alterado!";
					}else {
						
					}
				}

				if(alterou==false) {//caso nao encontre a disciplina continua copiando as informacoes antigas
					printWriter.println(nota.getCod_aluno()+"	"+nota.getCod_disc()+"	"+nota.getNota1()+"	"+nota.getNota2()+"	"+nota.getNota3()); 

				}
				alterou=false;
			}

	        printWriter.flush();
	        printWriter.close();
	        
			File arq1 = new File("Notas.txt");
			arq1.delete();
			arq.renameTo(new File("Notas.txt"));
		
	        
	        System.out.println("GRAVADO!");
	        
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return status;
	}
}