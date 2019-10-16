package aluno.interfac;


import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;
import aluno.modelo.Aluno;
import aluno.modelo.Nota;

// Criar a interface remota que define os métodos de serem invocados remotamente
// A interface tem de ser subclasse da interface java.rmi.Remote;
// cada método de uma interface remota tem de lançar a excepção java.rmi.RemoteException.

public interface GestorAlunos extends Remote {
	 
    Aluno consultarAluno(int codigo) throws RemoteException;
	
	List<Aluno> listar() throws RemoteException;
       
	String cadastrar_nota(int cod_aluno,int cod_disc,Double n1,Double n2,Double n3) throws RemoteException;
	
    String consultar_nota(int mat, String disciplina) throws RemoteException;
	
	List<Nota> consultar_notas(int mat) throws RemoteException;
	
	public String  consultar_cr(int mat)throws RemoteException;
	
	
}