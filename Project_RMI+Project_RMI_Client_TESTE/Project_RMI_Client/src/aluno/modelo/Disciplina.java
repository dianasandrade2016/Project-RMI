package aluno.modelo;

public class Disciplina {
	
	private int cod_disc;
	private String nomeDisciplina;
	
	public Disciplina() {}
	
	public Disciplina(int cod_disc, String nomeDisciplina) {
		super();
		this.cod_disc = cod_disc;
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getCod_disc() {
		return cod_disc;
	}
	public void setCod_disc(int cod_disc) {
		this.cod_disc = cod_disc;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
}
