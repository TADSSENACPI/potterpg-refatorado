package potterpg.core.regras;

import java.util.ArrayList;

import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Jogador;
import potterpg.core.regras.interfaces.IJogadorRegra;
import potterpg.data.IJogadorData;

public class JogadorRegra implements IJogadorRegra {

	IJogadorData _JData;
	ContainerDI cdi = new ContainerDI();
	
	public JogadorRegra() {
		
		_JData = cdi.getDependencia(_JData);
	}

	@Override
	public boolean salvarJogador(Jogador jogador) {
		boolean status = false;
		
		if (jogador != null) {
			status = _JData.SalvarJogador(jogador);
		}
		return status;
	}

	@Override
	public ArrayList<Jogador> buscarTodosJogadores() {
		return bubbleSortParaJogadores(_JData.buscarTodosJogadores());
	}
	private ArrayList<Jogador> bubbleSortParaJogadores(ArrayList<Jogador> jogadores) {

		Jogador jogadorAuxiliar = null;
		
		for (int i = 0; i < jogadores.size(); i++) {

			for (int j = 1; j < (jogadores.size() - i); j++) {

				if (jogadores.get(j - 1).getPontuacao() < jogadores.get(j).getPontuacao()) {

					jogadorAuxiliar = jogadores.get(j - 1);
					jogadores.set(j - 1,jogadores.get(j));
					jogadores.set(j, jogadorAuxiliar);
				}
			}
		}
		return jogadores;		
	}
	
}
