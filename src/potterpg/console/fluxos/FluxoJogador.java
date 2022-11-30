package potterpg.console.fluxos;

import java.util.Scanner;

import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoUtils;
import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Dragao;
import potterpg.core.entidades.Jogador;
import potterpg.core.regras.interfaces.IJogadorRegra;

public class FluxoJogador implements IFluxoJogador{

	
	Jogador jogador = new Jogador();
	IFluxoUtils _FUtils;
	IJogadorRegra _jRegra;
	ContainerDI cdi = new ContainerDI();
	Scanner input = new Scanner(System.in);
	
	public FluxoJogador() {
		
		_FUtils = cdi.getDependencia(_FUtils);
		_jRegra = cdi.getDependencia(_jRegra);
	}


	@Override
	public boolean verificaVida() {
		boolean status = false;
		if(jogador.getVida() < 1) {
			status = true;
		}
		
		return status;
	}

	@Override
	public boolean salvarJogador(Jogador jogador) {
		return _jRegra.salvarJogador(jogador);
	}
	@Override
	public void sorteioDragao() {
		Dragao dragao = new Dragao();
		_FUtils.datilografa(dragao.getDescricao() + "\n\n");
	}
	@Override
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	@Override
	public Jogador getJogador() {
		return jogador;
	}
}
