package util;

import src.Controller.BoissonTab;

public class generalFunctions<T> {

    /*
    Mettre à jour le switch de la fonction enregistrer
    avec les nouveaux controller
     */

    /**
     *
     * @param t
     * @param nb_ligne_a_update
     * @return
     */
    public boolean enregistrer(T t, int nb_ligne_a_update)
    {
        switch(t.getClass().getName())
        {
            case "BoissonTab":
                BoissonTab boissonTab = (BoissonTab) t;
                break;
            case "MenuTab":
                break;
            case "PlatTab":
            break;

            default:
                break;
        }

        return true;

    }

}
