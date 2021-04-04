package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Consultas {
	private String codTema;
	private String codigo;
	private String tema;
	private String descricao;
	private String preco;
	private NO_Enfeites inicio;
	
		
	public Consultas() {
		inicio=null;
	}

//	public String BuscarEnfeites(String codigo) {
//		NO_Enfeites aux;
//		aux = inicio;
//		if (aux == null) {
//			System.out.println("Lista vazia");
//		}
//		else {
//			String cod = aux.enfeites.getCodTema();
//			
//			while (aux.prox != null) {
//				while (cod != codigo) {
//					aux = aux.prox;
//				} // fim while
//				return aux.enfeites.getTemaEnfeite();
//			} // fim while
//		} // fim else
//		codigo = "nao encontrado";
//		return codigo;
//	}
	
	public void RecuperarListaEnfeites()  {
		
		NO_Enfeites aux = inicio;
		String lista;
		
		try {
			 String fileName = "ArquivoEnfeites.txt";	

			 	BufferedReader ler = new BufferedReader(new FileReader( fileName ));
			 	boolean str;
			 	while (str = ler.readLine() != null ) {
		        				        		
						codTema = ler.readLine();
						tema = ler.readLine();
						descricao = ler.readLine();
						preco = ler.readLine();
						System.out.println("\n"+codTema + tema+ descricao + preco);
					
						GerarLista(codTema,tema, descricao, preco);
			 	}
		} catch (Exception e) {
		} // fim try e catch 
		
	} // fim da lista de enfeites
	
	public void GerarLista(String codTema, String tema, String descricao, String preco) {
		NO_Enfeites aux = inicio;
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);
		enfeites.setCodTema(codTema);
		enfeites.setTemaEnfeite(tema);
		enfeites.setDescricaoEnfeite(descricao);
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista está vazia
			NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no nó criado
			inicio = n;									// carrega inicio com "n" - novo nó criado
		}  // fim if
		else {
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endereço
				} // fim while
				NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no nó criado
//				NO_Enfeites n = new NO_Enfeites(enfeites);	// cria um novo nó com endereço "n" e carrega dado "e"
				aux.prox = n;								// carrega n aux o endereço de n		
		}  // fim do else
	}  //fim gerar lista
	
	public void PercorreListaEnfeite() {
			if (inicio == null) {
				System.out.println("Lista vazia");
			} // if
			else {
				NO_Enfeites aux1 = inicio;	// criação de duas variaveis
				
				while (aux1 != null) {
					System.out.println("Codigo: " +aux1.enfeites.getCodTema() +" Tema: " +aux1.enfeites.getTemaEnfeite()+" Descrição: "+ aux1.enfeites.getDescricaoEnfeite() + " Preço: " + aux1.enfeites.getPreco()); 
					aux1 = aux1.prox;
				} // fim while
			} // fim else
		} // fim percorre lista
} // fim consulta
