package src.util;

import java.io.File;
import java.sql.Date;


public class Parametre {

    private static final String FILETYPE_FACTURE = "factures";
    public static final String FILETYPE_FACTURE_HEBERGEMENT    = FILETYPE_FACTURE + File.separator + "hebergement";
    public static final String FILETYPE_FACTURE_RESTAURANT     = FILETYPE_FACTURE + File.separator + "restaurant";
    public static final String FILETYPE_FACTURE_SPA            = FILETYPE_FACTURE + File.separator + "spa";
    public static final String FILETYPE_MENU                   = "menu";

    public static String getCheminFichier(String nomClient, String prenomClient, Date dateReservation, String fileType) {
        String cheminComplet = null;
        String nomFich = getNomFichier(nomClient, prenomClient, dateReservation);
        System.out.println(nomFich);

        // Url fichiers
        cheminComplet = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "GrandHotelDuParc";

        // Url Rangement
        cheminComplet += File.separator + fileType;
        // Création du répertoire
        new File(cheminComplet).mkdirs();

        // Nom Fichier
        cheminComplet += File.separator + nomFich;

        return cheminComplet;
    }

    public static String getNomFichier(String nomClient, String prenomClient, Date dateReservation) {
        String nomFic = nomClient + "-" + prenomClient + "-" + String.valueOf(dateReservation) + ".pdf";
        return nomFic;
    }

} 
