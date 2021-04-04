package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Cadastro_enfeites {

	Consultas consultas = new Consultas();
	private String zero;
	private String codTema;
	private String tema;
	private String descricao;
	private String preco;
	private int ops;
	private NO_Enfeites inicio;
	
	 
	public Cadastro_enfeites() {
		inicio = null;

	}
		public void Cadastro_Enfeites() {
		while (ops != 99) {

			
			ops = Integer.parseInt(JOptionPane.showInputDialog("Inicio: \n1-Cadastro Enfeite \n2-Gravar Lista Enfeites \n3-Lista Enfeites \n4-Busca por Tema \n5-Remover da Lista enfeites \n6-Remover da Lista \n7- Mostar Lista recuperada \n99-Sair  "));
			
			Consultas consulta = new Consultas();

			switch (ops) {
			case 1:
				Cad_Enfeite();;
				break;
			case 2:	
				GravarEnfeites();
				break;	
			case 3:
				ListaEnfeite();
				break;
			case 4:
				tema = JOptionPane.showInputDialog("digitar codigo do tema para busca: ");
				BuscarEnfeites(tema);
				break;
			case 5:
				int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite a posiçao a ser removida: "));
				System.out.println(RemoverEnfeite(pos));
				break;
			case 6:
				consulta.RecuperarListaEnfeites();
				break;
			case 7:
				consulta.PercorreListaEnfeite();
//				System.out.println("lista " + consulta.PercorreListaEnfeite());
				break;
			
//			case 99: 
//				break;
				
			default:
				break;
			} // fim switch
		} // fim while
	} // fim cadastro enfeites
	

	public void Cad_Enfeite() {   // adicionar no final da lista
		Enfeites enfeites = new Enfeites(codTema, tema, descricao, preco);
		codTema = JOptionPane.showInputDialog("Informe o codigo do tema");
		enfeites.setCodTema(codTema);
		tema = JOptionPane.showInputDialog("Informe o tema do enfeite");
		enfeites.setTemaEnfeite(tema);
		descricao = JOptionPane.showInputDialog("Informe a descriçáo do enfeite");
		enfeites.setDescricaoEnfeite(descricao);
		preco = JOptionPane.showInputDialog("Informe o preço do tema");
		enfeites.setPreco(preco);
		
		if (inicio == null) {							// verifica se a lista está vazia
			NO_Enfeites n = new NO_Enfeites(enfeites);	// carrega o valor de "e" no nó criado
			inicio = n;									// carrega inicio com "n" - novo nó criado
		}  // fim if
		else {
				NO_Enfeites aux = inicio;				// cria endereço de nó "aux" e carrega com o endereço de inicio
				while (aux.prox != null) {				// prox vem da classe contructor NO
					aux = aux.prox;						// vai movendo aux para a proximo endereço
				} // fim while
				NO_Enfeites n = new NO_Enfeites(enfeites);	// cria um novo nó com endereço "n" e carrega dado "e"
				aux.prox = n;								// carrega n aux o endereço de n		
		}  // fim do else
		System.out.println("cadastro: " + "Codigo Tema: " +enfeites.getCodTema() + " Tema:" +enfeites.getTemaEnfeite()+ " Descrição: " + enfeites.getDescricaoEnfeite() +" Preço: " + enfeites.getPreco());
	} // cadastro enfeites
	
	
	public void GravarEnfeites()  {
		NO_Enfeites aux = inicio;
		String enfeite = " ";
		
		try {
			String fileName = "ArquivoEnfeites.txt";	
		    BufferedWriter gravar = new BufferedWriter(new FileWriter( fileName ));	
		
			while (aux != null){
	            gravar.write(0); gravar.newLine();
				codTema = aux.enfeites.getCodTema();
	            gravar.write(aux.enfeites.getCodTema() ); gravar.newLine();
				tema = aux.enfeites.getTemaEnfeite();
	            gravar.write(aux.enfeites.getTemaEnfeite() ); gravar.newLine();
				descricao = aux.enfeites.getDescricaoEnfeite();
	            gravar.write(aux.enfeites.getDescricaoEnfeite() ); gravar.newLine();
				preco = aux.enfeites.getPreco();
	            gravar.write(aux.enfeites.getPreco()); gravar.newLine();

				aux = aux.prox;
			}
		     gravar.close();  			
		} catch (Exception e) {

		}  // fim try-catch
		System.out.println("Lista gravada");
	} // fim gravar  enfeites
	
	public void ListaEnfeite() {
		if (inicio == null) {
			System.out.println("Lista vazia");
		} // if
		else {
			NO_Enfeites aux1 = inicio;	// criação de duas variaveis
			
			while (aux1 != null) {
				System.out.println("Codigo: " +aux1.enfeites.getCodTema() +" Tema: " +aux1.enfeites.getTemaEnfeite()+" Descricao: "+ aux1.enfeites.getDescricaoEnfeite() + " Preço: " + aux1.enfeites.getPreco()); 
				aux1 = aux1.prox;
			} // fim while
		} // fim else
	} // fim lista enfeites
	
	public void BuscarEnfeites(String tema) {
		String aux = "";
		for(NO_Enfeites nodo = inicio; nodo != null; nodo = nodo.prox) {
			aux = nodo.enfeites.getTemaEnfeite();
		       if (tema.equalsIgnoreCase(aux)) {
		        System.out.println("codigo " +nodo.enfeites.getCodTema() + " Tema: "+ nodo.enfeites.getTemaEnfeite()+" Descrição: " + nodo.enfeites.getDescricaoEnfeite()+" Preço: "+nodo.enfeites.getPreco());
		        break;
		       }
		} // fim for
	} // fim buscar
	
	public String RemoverInicio() {			// 6 remover no inico da lista
		String codTema1 = " ";								// criar as variaveis
		String tema1 = " ";
		String descricao1 = " ";
		String preco1 = " ";
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "Lista Vazia");
		} // fim inicio 
		else {
			codTema1 = inicio.enfeites.getCodTema();				
			tema1 = inicio.enfeites.getTemaEnfeite();				
			descricao1 = inicio.enfeites.getDescricaoEnfeite();
			preco1 = inicio.enfeites.getPreco();
			inicio = inicio.prox;			// passar para inicio o enderço do proximos endereço
		} // fim else
		return "Codigo: " + codTema1 + " Tema: " + tema1 + " Descricao: " + descricao1 + " Semestre: " +preco1;
	} // fim da classe Remove Inicio
	
	public String RemoveFinal() {					// 5 remover no final da lista
		String codTema1 = " ";								// criar as variaveis
		String tema1 = " ";
		String descricao1 = " ";
		String preco1 = " ";
		
		if (inicio == null ) {
			JOptionPane.showConfirmDialog(null, "Lista Vázia");
		}
		else {
			if (inicio.prox == null) {			// inicio é o primeiro elemento da lista
				codTema1 = inicio.enfeites.getCodTema();				
				tema1 = inicio.enfeites.getTemaEnfeite();				
				descricao1 = inicio.enfeites.getDescricaoEnfeite();
				preco1 = inicio.enfeites.getPreco();		
				inicio = null;					// informa que é o ultimo elemento da lista
			} // fim IF
			else {
				NO_Enfeites aux1 = inicio;			// gerando duas varias, uma para varrer a lista
				NO_Enfeites aux2 = inicio;
				
				NO_Enfeites aux = LocalizaDadoRemocaoFim(inicio, inicio);

				codTema1 = aux.prox.enfeites.getCodTema();				
				tema1 = aux.prox.enfeites.getTemaEnfeite();				
				descricao1 = aux.prox.enfeites.getDescricaoEnfeite();
				preco1 = aux.prox.enfeites.getPreco();	
				aux.prox = null;			// coloca null para mostrar o fim da lista. 
			} // fim else
		} // fim else
		return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
	} // fim remover no final
	
	public NO_Enfeites LocalizaDadoRemocaoFim(NO_Enfeites aux1, NO_Enfeites aux2) {
		if (aux1.prox != null ) {
			return LocalizaDadoRemocaoFim(aux1.prox, aux1);
		}
		return aux2 ;
	}
	
	public String RemoverEnfeite(int pos) {
		String codTema1 = " ";								// criar as variaveis
		String tema1 = " ";
		String descricao1 = " ";
		String preco1 = " ";	
		int i = 1; 
		NO_Enfeites aux = inicio;	// criar um endereçamento aux com valor inicial
		
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "Lista Vazia !");
			codTema1 = inicio.enfeites.getCodTema();				
			tema1 = inicio.enfeites.getTemaEnfeite();				
			descricao1 = inicio.enfeites.getDescricaoEnfeite();
			preco1 = inicio.enfeites.getPreco();
			return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
		} // fim IF 
		
		if (pos == 1) {  // remoção pos = 1, remoção será no inicio da lista
			codTema1 = aux.enfeites.getCodTema();
			tema1 = aux.enfeites.getTemaEnfeite();
			descricao1 = aux.enfeites.getDescricaoEnfeite();
			preco1 = aux.enfeites.getPreco();
			RemoverInicio();
			return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
		} // Fim IF
		else {
			while (aux.prox != null) {  // remover no final da lista
				aux = aux.prox;   // guarda no aux o endereço do proximo da posição
				i++;				// vai guardando os posiçoes ate encontral null
			} // fim While
			if (pos > i || pos <=0) {  // posicoes invalidas
				JOptionPane.showConfirmDialog(null, "Posição invalida");
				return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
			} // fim IF
			else if (pos == i){			// Remoção no final
				codTema1 = aux.enfeites.getCodTema();
				tema1 = aux.enfeites.getTemaEnfeite();
				descricao1 = aux.enfeites.getDescricaoEnfeite();
				preco1 = aux.enfeites.getPreco();
				RemoveFinal();
				return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
			} // fim else
			else {						// remover qualquer posição
				aux = inicio;			// carrega aux com inicio
				NO_Enfeites aux2 = aux;			// cria endereçamenteo aux 2 e copia aux
				
				while(pos > 1) {
					aux2 = aux;
					aux = aux.prox;
					pos --;
				} // while
				codTema1 = aux.enfeites.getCodTema();
				tema1 = aux.enfeites.getTemaEnfeite();
				descricao1 = aux.enfeites.getDescricaoEnfeite();
				preco1 = aux.enfeites.getPreco();
				aux2.prox = aux.prox;
				return "Codigo : " + codTema1 + " Tema: " + tema1 + " Descricao: " +descricao1 + " preco: " +preco1;
			} // fim else
		} // fim else
	} // fim metodo escolher remover
		
} // fim classe
