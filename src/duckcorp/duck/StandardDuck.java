package duckcorp.duck;

/**
 * Canard en plastique standard.
 *
 * TODO (Ex1) :
 *   - Faites hériter cette classe de Duck
 *   - Implémentez le constructeur StandardDuck(int qualityScore) avec un appel à super
 *   - Implémentez getBasePrice() et describe()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class StandardDuck extends Duck {

    public static final double BASE_PRICE = 25.0;

    /**
     * Crée un nouveau canard standard avec le score de qualité spécifié.
     *
     * @param qualityScore le score de qualité du canard (entre 0 et 100)
     */
    public StandardDuck(int qualityScore) {
        super(DuckType.STANDARD, qualityScore);
    }

    /**
     * Retourne le prix de base d'un canard standard.
     *
     * @return le prix de base : 25.0
     */
    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Retourne une description textuelle de ce canard standard.
     *
     * @return la description "Canard Standard"
     */
    @Override
    public String describe() {
        return "Canard Standard";
    }

}
