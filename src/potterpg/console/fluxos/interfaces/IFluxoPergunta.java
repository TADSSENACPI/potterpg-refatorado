package potterpg.console.fluxos.interfaces;

import potterpg.core.entidades.Pergunta;

public interface IFluxoPergunta {
	
	public boolean apresentarPergunta(Pergunta p);
	public boolean casoErre(Pergunta p);

}
