package potterpg.core.entidades;

import java.util.ArrayList;

public class Capitulo {

	private int cod_Capitulo;
	private ArrayList<Pergunta> listaPergunta = new ArrayList<Pergunta>();
	
	
	public Capitulo(int cod_Capitulo) {
		this.cod_Capitulo = cod_Capitulo;
	}
	public int getCod_Capitulo() {
		return this.cod_Capitulo;
	}
	
	public ArrayList<Pergunta> getListaPergunta() {
		return this.listaPergunta;
	}
	public boolean addPerguntaNaLista(Pergunta p) {
		int tamanho = listaPergunta.size();
		boolean status = false;
		listaPergunta.add(p);
		if(listaPergunta.size() > tamanho) {
			status = true;
		}
		return status;
	}

	@Override
	public String toString() {
		return "Codigo Capitulo: " + cod_Capitulo
				+ "\nPerguntas: " + listaPergunta.toString();
	}
	

}
