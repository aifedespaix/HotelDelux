package src.util;

import java.sql.Date;

public class generalFunctions {

    /**
     * Function qui calcule le prix d'une chambre en fonction du nombre d'enfants, adultes, des prix et du nombre de jours dans l'hotel
     *
     * @param prix      double
     * @param dateDebut Date
     * @param dateFin   Date
     * @return double
     */

    public static double calculPrixChambre(double prix, Date dateDebut, Date dateFin) {
        double prixReservation;

        final long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
        int nbJoursSejour = (int) ((dateFin.getTime() - dateDebut.getTime()) / MILLISECONDS_IN_DAY);
        prixReservation = prix * nbJoursSejour;

        return prixReservation;
    }

    /**
     * @param valide Boolean
     * @return String
     */
    public static String isValidate(Boolean valide) {
        String isValide;
        if (valide) {
            isValide = "Validée";
        } else {
            isValide = "Non validée";
        }
        return isValide;
    }
}
