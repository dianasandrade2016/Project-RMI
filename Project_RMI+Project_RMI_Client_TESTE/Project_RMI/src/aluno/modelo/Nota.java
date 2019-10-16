package aluno.modelo;

import java.io.Serializable;

public class Nota implements Serializable{
	
	
	private static final long serialVersionUID = -141135446188916643L;
	
	private int cod_aluno;
	private int cod_disc;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Double media;
	
	public Nota(){};
	
	public Nota(int cod_aluno, int cod_disc, Double nota1, Double nota2, Double nota3,Double media) {
		super();
		this.cod_aluno = cod_aluno;
		this.cod_disc = cod_disc;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.media = media;
	}
	
	public int getCod_aluno() {
		return cod_aluno;
	}
	
	public void setCod_aluno(int cod_aluno) {
		this.cod_aluno = cod_aluno;
	}

	public int getCod_disc() {
		return cod_disc;
	}

	public void setCod_disc(int cod_disc) {
		this.cod_disc = cod_disc;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}
}
