package potterpg.core.entidades;

import java.util.Random;

public class Dragao {
	
	private int cod_Dragao;
	private String descricao;
	
	
	public Dragao() {
		
		cod_Dragao = new Random().nextInt(4);
		
		if (cod_Dragao == 0) {			
			descricao = "Com isso o dragão que voce vai enfrentar é o Verde Galês Comum. Esta raça está entre as que causam menos problemas (excetuando-se pela rara exceção do Incidente Ilfracombe) preferindo, como o Olho-de-Opala, caça carneiros e se empenha para evitar os humanos, a não ser quando provocado. O verde-galã tem um urro surpreendentemente melodioso que é facilmente reconhecivel . Suas labaredas saem em jorros finos e seus ovos são cor de terra, sarapintados de verde";
		}
		if (cod_Dragao == 1) {
			
			descricao = "Com isso o dragão que você vai enfrentar o Meteoro Chinês. O Meteoro-China de cor escarlate, possui escamas macias e uma franja de pontas douradas em volta do focinho e olhos extremamente protuberantes. Pesa entra duas e quatro toneladas. chamado de Meteoro por causa das esferas de fogo que solta pelas narinas quando enfurecido, que tomam o formato de cogumelos.";
		}
		if (cod_Dragao == 2) {
			
			descricao = "Com isso o dragão que voce vai enfrentar o Focinho Curto Sueco. uma das especie mais perigosas, devido ao seu voo agil e o fogo extremamente quente. O habitat natural dos Focinho-Curto suecos são as montanhas e são muito bonito. Suas habi-lidades são voar, expelir chamas, couraça resistente a acido e queimaduras graves.";
		}
		if (cod_Dragao == 3) {
			
			descricao = "Com isso o dragao que voce vai enfrentar o Rabo Córneo Húngaro. Tem escamas negras, e aparencia de lagarto. Ele tem ol-hos amarelos, com pupilas verticais como as de um gato, chifres de bronze e picos coloridas semelhantes que se projetam a partir da sua longa cauda que ele usa em combate. O rugido do dragão um grito estridente, e sua chama pode chegar a cerca de 15 metros.";
		}	
		
	}
	
	public String getDescricao() {
		return descricao;
	}	
	
}
