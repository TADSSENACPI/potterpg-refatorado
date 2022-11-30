package potterpg.core.regras;

import java.util.ArrayList;

import potterpg.core.entidades.Pergunta;
import potterpg.core.regras.interfaces.IPerguntaRegra;
import potterpg.data.IPerguntaData;
import potterpg.data.PerguntaData;

public class PerguntaRegra implements IPerguntaRegra {	
	
	private IPerguntaData _pData;
	
	public PerguntaRegra() {
		_pData = new PerguntaData();
	}
	
	@Override
	public ArrayList<Pergunta> buscarTodasPerguntas() {
		
		return _pData.buscarTodasPerguntas();
	}	
}
