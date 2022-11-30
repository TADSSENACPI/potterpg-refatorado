package potterpg.containers;

import potterpg.console.fluxos.FluxoCapitulo;
import potterpg.console.fluxos.FluxoJogador;
import potterpg.console.fluxos.FluxoMenu;
import potterpg.console.fluxos.FluxoPergunta;
import potterpg.console.fluxos.FluxoUtils;
import potterpg.console.fluxos.interfaces.IFluxoCapitulo;
import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoMenu;
import potterpg.console.fluxos.interfaces.IFluxoPergunta;
import potterpg.console.fluxos.interfaces.IFluxoUtils;
import potterpg.core.regras.CapituloRegra;
import potterpg.core.regras.JogadorRegra;
import potterpg.core.regras.PerguntaRegra;
import potterpg.core.regras.interfaces.ICapituloRegra;
import potterpg.core.regras.interfaces.IJogadorRegra;
import potterpg.core.regras.interfaces.IPerguntaRegra;
import potterpg.data.IJogadorData;
import potterpg.data.JogadorData;

public class ContainerDI {
	
	public IJogadorRegra getDependencia(IJogadorRegra regra) {
		regra = new JogadorRegra();
		return regra;
	}
	public IPerguntaRegra getDependencia(IPerguntaRegra regra) {
		regra = new PerguntaRegra();
		return regra;
	}
	public ICapituloRegra getDependencia(ICapituloRegra regra) {
		regra = new CapituloRegra();
		return regra;
	}
	public IFluxoCapitulo getDependencia(IFluxoCapitulo fluxo) {
		fluxo = new FluxoCapitulo();
		return fluxo;
	}
	public IFluxoPergunta getDependencia(IFluxoPergunta fluxo) {
		fluxo = new FluxoPergunta();
		return fluxo;
	}
	public IFluxoJogador getDependencia(IFluxoJogador fluxo) {
		fluxo = new FluxoJogador();
		return fluxo;
	}
	public IFluxoMenu getDependencia(IFluxoMenu fluxo) {
		fluxo = new FluxoMenu();
		return fluxo;
	}
	public IFluxoUtils getDependencia(IFluxoUtils fluxo) {
		fluxo = new FluxoUtils();
		return fluxo;
	}
	public IJogadorData getDependencia(IJogadorData data) {
		return new JogadorData();
	}
}
