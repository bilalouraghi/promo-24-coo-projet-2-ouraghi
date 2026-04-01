package duckcorp.duck;

/**
 * Canard en plastique miniature.
 *
 * TODO (Ex1) :
 *   - Faites hériter cette classe de Duck
 *   - Implémentez le constructeur MiniDuck(int qualityScore) avec un appel à super
 *   - Implémentez getBasePrice() et describe()
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniDuck extends Duck {

    public static final double BASE_PRICE = 12.0;

    /**
     * Crée un nouveau mini canard avec le score de qualité spécifié.
     *
     * @param qualityScore le score de qualité du canard (entre 0 et 100)
     */
    public MiniDuck(int qualityScore) {
        super(DuckType.MINI, qualityScore);
    }

    /**
     * Retourne le prix de base d'un mini canard.
     *
     * @return le prix de base : 12.0
     */
    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Retourne une description textuelle de ce mini canard.
     *
     * @return la description "Mini Canard"
     */
    @Override
    public String describe() {
        return "Mini Canard";
    }

}
