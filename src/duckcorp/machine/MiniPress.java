package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.MiniDuck;

/**
 * Presse produisant des Mini Canards.
 *
 * TODO (Ex2) :
 *   - Faites hériter cette classe de Machine
 *   - Implémentez le constructeur sans paramètre avec un appel à super
 *   - Implémentez produceDuck(), getPurchaseCost(), getName()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniPress extends Machine {

    public static final int PURCHASE_COST    = 300;
    public static final int CAPACITY         = 8;
    public static final int MAINTENANCE_COST = 30;

    /**
     * Crée une nouvelle mini-presse.
     */
    public MiniPress() {
        super(DuckType.MINI, CAPACITY, MAINTENANCE_COST);
    }

    /**
     * Produit un mini canard avec une qualité dépendante de l'état de la presse.
     *
     * @return un nouveau mini canard
     */
    @Override
    public Duck produceDuck() {
        return new MiniDuck(computeQuality());
    }

    /**
     * Retourne le coût d'achat d'une mini-presse.
     *
     * @return le coût : 300 euros
     */
    @Override
    public int getPurchaseCost() {
        return PURCHASE_COST;
    }

    /**
     * Retourne le nom commercial de cette presse.
     *
     * @return "Mini-Presse"
     */
    @Override
    public String getName() {
        return "Mini-Presse";
    }
}
