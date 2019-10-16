package aluno.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import aluno.controle.GestorAlunosImpl;
import aluno.interfac.GestorAlunos;

//RMI registry é um serviço de nomes que faz a gestão das referências remotas para o sistema RMI.
//O servidor tem que registar o objeto no registry, permitindo assim aos clientes obter a referência do objecto remoto
 
public class MainServer {
	
    public static void main(String[] args) throws Exception {
    	
    	
    	//Iniciar a execução do registry 
    	LocateRegistry.createRegistry(1099);
    	
        //cria uma instancia da classe GestorAlunos que implementa o metodo remoto
        GestorAlunos gestor = new GestorAlunosImpl();
        
        System.out.println("--> RMI registry ready : Servidor rodando");
        
        //Informa o “RMI registry” de que este objecto está disponível com o nome recebido no parâmetro String        
        Naming.rebind("//localhost/GestorAlunos", gestor);
        
        //Após a execução do servidor o objecto remoto estará acessível aos clientes pelo
        //nome: "//<máquina onde executa o servidor>/GestorAlunos instancia"
            
    	System.out.println("--> Objeto publicado");  
        
        System.out.println( "\n--> Lista de Aluno Carregada! (" + gestor.listar().size()+ ")" );
        
        System.out.println( "\nServidor Pronto!" );
   
    }
}