package potterpg.data;

import java.util.ArrayList;

import potterpg.core.entidades.Jogador;

public interface IJogadorData {	
	
	public boolean SalvarJogador(Jogador jogador);
	public ArrayList<Jogador> buscarTodosJogadores();
}
