package potterpg.core.regras.interfaces;

import java.util.ArrayList;

import potterpg.core.entidades.Jogador;

public interface IJogadorRegra {
	
	public boolean salvarJogador(Jogador jogador);	
	public ArrayList<Jogador> buscarTodosJogadores();
	

}
