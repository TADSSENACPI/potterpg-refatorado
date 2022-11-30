package potterpg.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import potterpg.core.entidades.Jogador;

public class JogadorData implements IJogadorData {

	String path = "C:\\Users\\conta\\Documents\\projetos\\java\\potterpg-refatorado\\src\\potterpg\\bases\\JogadorBase.csv";

	@Override
	public boolean SalvarJogador(Jogador jogador) {

		boolean status = false;
		if (jogador != null) {
			ArrayList<Jogador> listaDeJogadores = buscarTodosJogadores();
			listaDeJogadores.add(jogador);
			salvarListaDeJogadores(listaDeJogadores);
			status = true;
		}

		return status;
	}

	@Override
	public ArrayList<Jogador> buscarTodosJogadores() {

		ArrayList<Jogador> lista = new ArrayList<Jogador>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linha = br.readLine();
			linha = br.readLine();

			while (linha != null) {

				String dados[] = linha.split(",");

				String nome = dados[0].replaceAll("\"","");
				double pontuacao = Double.parseDouble(dados[1].replaceAll("\"",""));
				String mododeJogo = dados[2].replaceAll("\"","");
				String dataDeCriacao = dados[3].replaceAll("\"","");

				Jogador jogador = new Jogador(nome, pontuacao, mododeJogo, dataDeCriacao);
				lista.add(jogador);

				linha = br.readLine();

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	private void salvarListaDeJogadores(ArrayList<Jogador> lista) {
		
		ArrayList<String[]> listaParaCsv = new ArrayList<String[]>();
		listaParaCsv.add(new String[] { "Nome", "Pontuacão", "ModoDeJogo", "DataDeCriacao" });
		
		try (FileWriter fw = new FileWriter(path);) {
			
			CSVWriter writer = new CSVWriter(fw);
			for(Jogador j : lista) {
				
				String nome = j.getNome().replace("\"", "");
				String pontuacao = String.valueOf(j.getPontuacao()).replace("\"", "");
				String modo = j.getModoDeJogo().replace("\"", "")  + " ";
				String data = String.valueOf(j.getDataDeCriacao()).replace("\"", "");
				listaParaCsv.add(new String[] { nome, pontuacao, modo, data });
			}
			writer.writeAll(listaParaCsv);
			fw.close();
			writer.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
