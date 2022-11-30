package potterpg.core.entidades;

public class Pergunta {

	int cod_OrdemDeChamada;
	int cod_Capitulo;
	int nivelDeDificuldade;
	int pontos;
	String conteudoPergunta;
	String[] alternativas = new String[3];
	String alternativaCorreta;

	public Pergunta(int cod_OrdemDeChamada, int cod_Capitulo, int nivelDeDificuldade, int pontos, String conteudoPergunta, String[] alternativas,
			String alternativaCorreta) {

		this.cod_OrdemDeChamada = cod_OrdemDeChamada;
		this.cod_Capitulo = cod_Capitulo;
		this.nivelDeDificuldade = nivelDeDificuldade;
		this.pontos = pontos;
		this.conteudoPergunta = conteudoPergunta;
		this.alternativas = alternativas;
		this.alternativaCorreta = alternativaCorreta;
	}
	public Pergunta() {
		
	}

	@Override
	public String toString() {
		return "cod_OrdemDeChamada = " + cod_OrdemDeChamada 
				+ "\ncod_Capitulo = " + cod_Capitulo;
			
	}

	public String toString(int i) {
		return "cod_OrdemDeChamada = " + cod_OrdemDeChamada 
				+ "\ncod_Capitulo = " + cod_Capitulo;
	}

	public int getCod_Capitulo() {
		return cod_Capitulo;
	}
	public int getNivelDeDificuldade() {
		return nivelDeDificuldade;
	}
	public int getPontos() {
		return pontos;
	}
	public String getConteudoPergunta() {
		return conteudoPergunta;
	}
	public String[] getAlternativas() {
		return alternativas;
	}
	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}		
}
