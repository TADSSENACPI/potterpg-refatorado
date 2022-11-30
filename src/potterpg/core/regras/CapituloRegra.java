package potterpg.core.regras;

import java.util.ArrayList;

import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Capitulo;
import potterpg.core.entidades.Pergunta;
import potterpg.core.regras.interfaces.ICapituloRegra;
import potterpg.core.regras.interfaces.IGerenico;
import potterpg.core.regras.interfaces.IPerguntaRegra;

public class CapituloRegra implements ICapituloRegra, IGerenico {

	IPerguntaRegra _pRegra;
	private Capitulo capitulo1 = new Capitulo(1);
	private Capitulo capitulo2 = new Capitulo(2);
	private Capitulo capitulo3 = new Capitulo(3);
	private Capitulo capitulo4 = new Capitulo(4);
	
	private final ContainerDI containerDI = new ContainerDI();

	public CapituloRegra() {
		
		_pRegra = containerDI.getDependencia(_pRegra);
	}
	
	public ArrayList<Capitulo> buscarCapitulos() {
		ArrayList<Capitulo> capitulos = selectionSortParaCapitulos();
		return capitulos;
	}

	private ArrayList<Capitulo> selectionSortParaCapitulos() {

		int posicaoMenor;
		Pergunta perguntaAuxiliarDeTroca = new Pergunta();
		ArrayList<Capitulo> capitulos = separarPerguntasPorCapitulo();

		for (Capitulo c : capitulos) {

			for (int i = 0; i < c.getListaPergunta().size(); i++) {

				posicaoMenor = i;

				for (int j = i + 1; j < c.getListaPergunta().size(); j++) {

					if (c.getListaPergunta().get(j).getCod_Capitulo() < c.getListaPergunta().get(posicaoMenor)
							.getCod_Capitulo()) {
						posicaoMenor = j;
					}
				}

				perguntaAuxiliarDeTroca = c.getListaPergunta().get(posicaoMenor);
				c.getListaPergunta().set(posicaoMenor, c.getListaPergunta().get(i));
				c.getListaPergunta().set(i, perguntaAuxiliarDeTroca);
			}
		}
		return capitulos;
	}

	private ArrayList<Capitulo> separarPerguntasPorCapitulo() {

		ArrayList<Pergunta> perguntas = _pRegra.buscarTodasPerguntas();
		ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
		if(capitulo1.getListaPergunta().size() == 0) {
			for (Pergunta p : perguntas) {
				if (p.getCod_Capitulo() == capitulo1.getCod_Capitulo()) {
					capitulo1.addPerguntaNaLista(p);
					
				} else if (p.getCod_Capitulo() == capitulo2.getCod_Capitulo()) {
					capitulo2.addPerguntaNaLista(p);
					
				} else if (p.getCod_Capitulo() == capitulo3.getCod_Capitulo()) {
					capitulo3.addPerguntaNaLista(p);
					
					
				} else if (p.getCod_Capitulo() == capitulo4.getCod_Capitulo()) {
					capitulo4.addPerguntaNaLista(p);					
				}
			}
		}
		capitulos.add(capitulo1);
		capitulos.add(capitulo2);
		capitulos.add(capitulo3);
		capitulos.add(capitulo4);

		return capitulos;
	}
}
