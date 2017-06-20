package src.util;
import java.io.File;
import java.sql.Date;


public class Parametre {
	
		public static String getCheminFichier(String nomClient, String prenomClient, Date dateReservation){
		String cheminComplet = null;
		String nomFich = getNomFichier(nomClient, prenomClient,dateReservation);
		System.out.println(nomFich);
		cheminComplet = "C:" + File.separator + "Users" + File.separator + "AifeDesPaix" + File.separator + "Desktop" + File.separator + "pdf" + File.separator + nomFich;
		System.out.println(cheminComplet);
		return cheminComplet;
	}
		
	public static String getNomFichier(String nomClient, String prenomClient, Date dateReservation){
		String nomFic = nomClient+ "-" + prenomClient + "-" +  String.valueOf(dateReservation) + ".pdf";
		return nomFic;
	}
} 
