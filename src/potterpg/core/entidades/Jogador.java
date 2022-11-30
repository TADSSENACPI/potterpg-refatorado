package potterpg.core.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jogador {
	
	private String nome;
	private double pontuacao = 100;
	private String modoDeJogo;
	private String dataDeCriacao;
	private int vida;
	private long tempoDeJogatina;

	public Jogador(String nome, double pontuacao,String modoDeJogo, String dataDeCriacao) {
		
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.modoDeJogo = modoDeJogo;
		this.dataDeCriacao = dataDeCriacao;		
	}
	public Jogador() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.dataDeCriacao = dataFormatada.format(new Date());
	}
	
	public Jogador(String nome) {
		
		this.nome = nome;
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.dataDeCriacao = dataFormatada.format(new Date());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public long getTempoDeJogatina() {
		return tempoDeJogatina;
	}
	public void setTempoDeJogatina(long tempoDeJogatina) {
		this.tempoDeJogatina = tempoDeJogatina;
	}
	public String getDataDeCriacao() {
		return dataDeCriacao;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public String getModoDeJogo() {
		return modoDeJogo;
	}
	public void setModoDeJogo(String modoDeJogo) {
		this.modoDeJogo = modoDeJogo;
	}
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontuacao=" + pontuacao + ", modoDeJogo=" + modoDeJogo + ", dataDeCriacao="
				+ dataDeCriacao + ", vida=" + vida + "]";
	}
	
}
