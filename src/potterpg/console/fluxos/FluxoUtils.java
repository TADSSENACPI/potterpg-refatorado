package potterpg.console.fluxos;

import potterpg.console.fluxos.interfaces.IFluxoUtils;

public class FluxoUtils implements IFluxoUtils{
	
	@Override
	public void datilografa(String string) {
		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			j++;
			char caractere = string.charAt(i);
			
			try {
				
				Thread.sleep(40);
				
			} catch (Exception ex) {
				
				System.err.println(ex.getMessage());
				
			}
			if(j == 120) {
				System.out.println();
				j = 0;
			}
			System.out.print(caractere);
		}
	}
}
