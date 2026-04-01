package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.StandardDuck;

/**
 * Presse produisant des canards Standard.
 *
 * TODO (Ex2) :
 * - Faites hériter cette classe de Machine
 * - Implémentez le constructeur sans paramètre avec un appel à super
 * - Implémentez produceDuck(), getPurchaseCost(), getName()
 * 
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class StandardPress extends Machine {

    public static final int PURCHASE_COST = 500;
    public static final int CAPACITY = 5;
    public static final int MAINTENANCE_COST = 50;

    /**
     * Crée une nouvelle presse standard.
     */
    public StandardPress() {
        super(DuckType.STANDARD, CAPACITY, MAINTENANCE_COST);
    }

    /**
     * Produit un canard standard avec une qualité dépendante de l'état de la presse.
     *
     * @return un nouveau canard standard
     */
    @Override
    public Duck produceDuck() {
        return new StandardDuck(computeQuality());
    }

    /**
     * Retourne le coût d'achat d'une presse standard.
     *
     * @return le coût : 500 euros
     */
    @Override
    public int getPurchaseCost() {
        return PURCHASE_COST;
    }

    /**
     * Retourne le nom commercial de cette presse.
     *
     * @return "Presse Standard"
     */
    @Override
    public String getName() {
        return "Presse Standard";
    }
}
