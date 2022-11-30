package potterpg.console.fluxos.interfaces;

import potterpg.core.entidades.Jogador;

public interface IFluxoJogador {

	public boolean verificaVida();
	public boolean salvarJogador(Jogador jogador);
	void sorteioDragao();
	void setJogador(Jogador jogador);
	Jogador getJogador();
}
