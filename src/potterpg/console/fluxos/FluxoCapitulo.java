package potterpg.console.fluxos;

import java.util.ArrayList;
import java.util.Random;

import potterpg.console.fluxos.interfaces.IFluxoCapitulo;
import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoPergunta;
import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Capitulo;
import potterpg.core.entidades.Pergunta;
import potterpg.core.regras.interfaces.ICapituloRegra;

public class FluxoCapitulo implements IFluxoCapitulo {

	private ICapituloRegra _CRegra;
	private IFluxoJogador _FJogador;
	private IFluxoPergunta _FPergunta;
	private ContainerDI cdi = new ContainerDI();
	static double pontuacao;
	

	public FluxoCapitulo() {
		_CRegra = cdi.getDependencia(_CRegra);
		_FPergunta = cdi.getDependencia(_FPergunta);
	}
	@Override
	public void setFluxoJogadorSeEncontra(IFluxoJogador fxj) {
		this._FJogador = fxj;
	}
	
	@Override
	public void apresentarCapitulo(int codigo) {

		Capitulo capitulo = getCapitulo(codigo);
		
		fim : for (int i = 0; i <= capitulo.getListaPergunta().size(); i++) {
			
			var condicaoParaFinalizarCapitulo = fimDoCapitulo(codigo, i, capitulo.getListaPergunta().size());
			
			if(condicaoParaFinalizarCapitulo) {				
				capitulo =  null;
				break fim;
			}
			Pergunta p = capitulo.getListaPergunta().get(i);

			boolean statusDaResposta = _FPergunta.apresentarPergunta(p);

			if (statusDaResposta) escolhaCerta(p.getPontos());

			else {
					boolean novaResposta = false;
					do {
						
						escolhaErrada();
						
						if(!(isDead())) {
							novaResposta = _FPergunta.casoErre(p);
						}
					} while (!novaResposta);
				escolhaCerta(p.getPontos());
			}
		}
	}
	private boolean isDead() {
		boolean morreu = _FJogador.verificaVida();
		if (morreu) {
			System.err.println("\nVOCÊ MORREU!");
			aposMorte();			
		}
		return morreu;
		
	}

	private void aposMorte() {
		_FJogador.salvarJogador(_FJogador.getJogador());
		System.out.print("\nObrigado por jogar nosso game...");
		System.err.println(" EQUIPE POTTERPG !");
		System.exit(0);
	}

	/**
	 * @param numeroDoCapitulo Codígo de identificação do capítulo que está sendo processado no momento.
	 * @param atual Valor da pergunta que está sendo processada no momento da execução do programa.
	 * @param total Valor total de perguntas presentes no capítulo.
	 * @return Verdadeiro Caso o capítulo chega ao fim, Falso Caso o capítulo ainda tenha perguntas para processar.
	 */
	private boolean fimDoCapitulo(int numeroDoCapitulo, int atual, int total) {
		boolean status = false;
		if(atual >= total) {
			System.err.println("FIM DO " + numeroDoCapitulo + "ª CAPÍTULO...");
			status = true;
			
		}
		return status;
	}
	private void escolhaErrada() {

		_FJogador.getJogador().setVida(_FJogador.getJogador().getVida() - 1);
		String[] escolha = { "Essa escolha te levou a morte!", "Reflita sobre suas escolhas.",
				"Assistir os filme vai facilitar.", "Leia as instruções, lá tem alguns blogs sobre Harry Potter." };

		System.err.println("\nNÃO FOI DESSA VEZ! " + escolha[new Random().nextInt(4)]);
		System.err.println("VIDAS RESTANTES: " + _FJogador.getJogador().getVida());
	}
	
	private void escolhaCerta(int pontos) {

		pontuacao = pontuacao + pontos;
		String[] escolha = { "Ufa, essa foi por pouco!", "Continue assim! ",
				"Você parece ser um grande fã de Harry Potter.", "Você é realmente imbatível." };

		System.err.println("\nPARABÉNS! " + escolha[new Random().nextInt(4)]);
		System.err.println("PONTOS: " + pontuacao + "\n");
		_FJogador.getJogador().setPontuacao(pontos + _FJogador.getJogador().getPontuacao());
	}
	/**
	 * @param Código de identificação do capítulo
	 * @return Objeto do tipo Capitulo que contém o mesmo código passado no
	 *         parâmetro do método.
	 */
	private Capitulo getCapitulo(int codigo) {

		Capitulo capitulo = null;
		ArrayList<Capitulo> capitulos = _CRegra.buscarCapitulos();
		parar : for (Capitulo c : capitulos) {
			if ((c.getCod_Capitulo() == codigo)) {
				capitulo = c;
				break parar;
			}
		}
		return capitulo;
	}

}
