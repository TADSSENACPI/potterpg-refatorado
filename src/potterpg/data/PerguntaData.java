package potterpg.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import potterpg.core.entidades.Pergunta;

public class PerguntaData implements IPerguntaData	{

	String path = "C:\\Users\\conta\\Documents\\projetos\\java\\potterpg-refatorado\\src\\potterpg\\bases\\PerguntaBase.csv";
	
	@Override
	public ArrayList<Pergunta> buscarTodasPerguntas() {
		
		ArrayList<Pergunta> lista = new ArrayList<Pergunta>();		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			
			while(linha != null) {
				
				String dados[] = linha.split(";");
				
				int cod_OrdemDeChamada = Integer.parseInt(dados[0]);
				int cod_Capitulo = Integer.parseInt(dados[1]);
				int nivelDeDificuldade = Integer.parseInt(dados[2]);
				int pontos = Integer.parseInt(dados[3]);
				String conteudoPergunta = dados[4];
				String[] alternativas = {dados[5], dados[6], dados[7], dados[8]};
				String alternativaCorreta = dados[9];
				
				Pergunta pergunta = new Pergunta(cod_OrdemDeChamada, cod_Capitulo, nivelDeDificuldade, pontos, conteudoPergunta, alternativas, alternativaCorreta);
				lista.add(pergunta);
				
				linha = br.readLine();
				
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

}
