package potterpg.console;

import potterpg.console.fluxos.FluxoPrincipal;
import potterpg.core.regras.CapituloRegra;
import potterpg.core.regras.interfaces.ICapituloRegra;

public class TesteStartConsoleApp {
	
	static ICapituloRegra _cRegra = new CapituloRegra();;
	
	public static void main(String[] args) {
		
		FluxoPrincipal regra = new FluxoPrincipal();
		regra.start();
	}

}
