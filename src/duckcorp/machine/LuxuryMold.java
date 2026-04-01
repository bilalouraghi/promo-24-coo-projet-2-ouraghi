package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.LuxuryDuck;

/**
 * Moule produisant des Canards de Luxe.
 *
 * TODO (Ex2) :
 *   - Faites hériter cette classe de Machine
 *   - Implémentez le constructeur sans paramètre avec un appel à super
 *   - Implémentez produceDuck(), getPurchaseCost(), getName()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class LuxuryMold extends Machine {

    public static final int PURCHASE_COST    = 800;
    public static final int CAPACITY         = 2;
    public static final int MAINTENANCE_COST = 80;

    /**
     * Crée un nouveau moule de luxe avec ses caractéristiques par défaut.
     *
     * Le moule produit des canards de luxe avec une capacité de 2 canards par tour
     * et un coût de maintenance de 80€.
     */
    public LuxuryMold() {
        super(DuckType.LUXURY, CAPACITY, MAINTENANCE_COST);
    }

    /**
     * Produit un canard de luxe avec une qualité dépendante de l'état du moule.
     *
     * @return un nouveau canard de luxe avec une qualité calculée selon l'état du moule
     */
    @Override
    public Duck produceDuck() {
        return new LuxuryDuck(computeQuality());
    }

    /**
     * Retourne le coût d'achat d'un moule de luxe.
     *
     * C'est l'investissement initial le plus élevé, mais il produit les canards
     * offrant les meilleures marges bénéficiaires.
     *
     * @return le coût : 800 euros
     */
    @Override
    public int getPurchaseCost() {
        return PURCHASE_COST;
    }

    /**
     * Retourne le nom commercial de ce moule.
     *
     * @return "Moule de Luxe"
     */
    @Override
    public String getName() {
        return "Moule de Luxe";
    }
}
