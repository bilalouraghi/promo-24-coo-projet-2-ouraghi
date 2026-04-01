package duckcorp.duck;

/**
 * Canard en plastique de luxe.
 *
 * TODO (Ex1) :
 * - Faites hériter cette classe de Duck
 * - Implémentez le constructeur LuxuryDuck(int qualityScore) avec un appel à
 * super
 * - Implémentez getBasePrice() et describe()
 * 
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class LuxuryDuck extends Duck {

    public static final double BASE_PRICE = 80.0;

    /**
     * Crée un nouveau canard de luxe avec le score de qualité spécifié.
     *
     * @param qualityScore le score de qualité du canard (entre 0 et 100)
     */
    public LuxuryDuck(int qualityScore) {
        super(DuckType.LUXURY, qualityScore);
    }

    /**
     * Retourne le prix de base d'un canard de luxe.
     *
     * @return le prix de base : 80.0
     */
    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * Retourne une description textuelle de ce canard de luxe.
     *
     * @return la description "Canard de Luxe"
     */
    @Override
    public String describe() {
        return "Canard de Luxe";
    }

}