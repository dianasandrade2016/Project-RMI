package aluno.modelo;

import java.io.Serializable;

public class Aluno implements Serializable{
 
	private static final long serialVersionUID = 1728799560066886492L;
	
	private int codigo;
    private String nome;
	
    public Aluno() {}
    
    public Aluno(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;

	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}    
}