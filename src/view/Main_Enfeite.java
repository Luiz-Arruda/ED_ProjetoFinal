package view;

import javax.swing.JOptionPane;

import controller.Cadastro_enfeites;
import controller.Consultas;

public class Main_Enfeite {

	public static void main(String[] args) {
		Cadastro_enfeites enfeites = new Cadastro_enfeites();
		int ops = 0;
		
		while (ops != 99) {

			
			ops = Integer.parseInt(JOptionPane.showInputDialog("Inicio: \n1-Cadastro Enfeite \n99-Sair  "));
			
			switch (ops) {
			case 1:
				enfeites.Cadastro_Enfeites();
				break;
			
			case 99: 
				break;
				
			default:
				break;
			} // fim switch
		} // fim while
		
	} // fim maim
} // fim classe
