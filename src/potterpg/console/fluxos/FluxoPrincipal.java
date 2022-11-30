package potterpg.console.fluxos;

import potterpg.console.fluxos.interfaces.IFluxoCapitulo;
import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoMenu;
import potterpg.console.fluxos.interfaces.IFluxoUtils;
import potterpg.containers.ContainerDI;

public class FluxoPrincipal {

	IFluxoMenu _FMenu;
	IFluxoUtils _FUtils;
	IFluxoJogador _FJogador;
	IFluxoCapitulo _FCapitulo;
	ContainerDI cdi = new ContainerDI();

	public FluxoPrincipal() {
		
		_FMenu = cdi.getDependencia(_FMenu);
		_FUtils = cdi.getDependencia(_FUtils);
		_FJogador = cdi.getDependencia(_FJogador);
		_FCapitulo = cdi.getDependencia(_FCapitulo);
		
		
	}
	public void start() {
		
		
		_FMenu.start();		
		
	}
}
