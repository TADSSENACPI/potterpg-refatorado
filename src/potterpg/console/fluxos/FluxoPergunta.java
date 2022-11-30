package potterpg.console.fluxos;

import java.util.Scanner;

import potterpg.console.fluxos.interfaces.IFluxoPergunta;
import potterpg.core.entidades.Pergunta;

public class FluxoPergunta implements IFluxoPergunta {
	
	Scanner input = new Scanner(System.in);
	FluxoUtils utils = new FluxoUtils();

	public boolean apresentarPergunta(Pergunta p) {
		
		apresentaConteudoPergunta(p.getConteudoPergunta());
		System.out.println();
		apresentaAlternativas(p.getAlternativas());
		
		return validarResposta(p.getAlternativaCorreta());
	}
	public boolean casoErre(Pergunta p) {
		apresentaAlternativas(p.getAlternativas());
		
		return validarResposta(p.getAlternativaCorreta());
	}
	private void apresentaConteudoPergunta(String string) {
		utils.datilografa(string);
	}
	public void apresentaAlternativas(String[] alternativas) {
		for (String s : alternativas) {
			utils.datilografa("\n" + s);
		}
	}
	private boolean validarResposta(String respota) {
		
		boolean status = false;
		System.out.print("\n\nR: ");
		String respostaInput = input.next();
		
		if(respostaInput.equalsIgnoreCase(respota)) {
			
			status = true;
		}
		
		return status;
	}
	
}
