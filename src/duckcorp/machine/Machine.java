package duckcorp.machine;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;

import java.util.Random;

/**
 * Classe abstraite représentant une machine de production.
 *
 * TODO (Ex2) :
 *   - Faites implémenter l'interface Maintainable à cette classe
 *   - Implémentez maintain()
 *   - Implémentez produceDuck(), getPurchaseCost(), getName() dans les sous-classes
 * @author Roussille Philippe <roussille@3il.fr>
 */
public abstract class Machine implements Maintainable {

    private static final Random RANDOM = new Random();

    private final DuckType producedType;
    private final int      capacity;
    private int            condition;
    private final int      maintenanceCost;

    /** Constructeur fourni. */
    protected Machine(DuckType producedType, int capacity, int maintenanceCost) {
        this.producedType    = producedType;
        this.capacity        = capacity;
        this.condition       = 100;
        this.maintenanceCost = maintenanceCost;
    }

    // --- Getters fournis ---

    public DuckType getProducedType()    { return producedType; }
    public int      getCapacity()        { return capacity; }
    public int      getMaintenanceCost() { return maintenanceCost; }

    /**
     * Retourne l'état actuel de la machine.
     *
     * L'état détermine la qualité des canards produits et la nécessité d'une maintenance.
     * À chaque fin de tour, l'état se dégrade de 10 points.
     *
     * @return l'état de la machine compris entre 0 et 100 inclus
     */
    public int getCondition() { return condition; }

    // --- TODO : maintain() ---

    /**
     * Effectue une maintenance de la machine.
     *
     * L'opération augmente l'état de 40 points, plafonné à 100. Le coût de la
     * maintenance peut être récupéré via {@link #getMaintenanceCost()}.
     */
    public void maintain() {
        condition = Math.min(100, condition + 40);
    }

    // --- Méthodes fournies ---

    /**
     * Dégrade automatiquement la machine de 10 points d'état.
     *
     * Cette méthode est appelée à la fin de chaque tour par la fabrique.
     * L'état descend minimum à 0. Ne pas modifier.
     *
     * @see duckcorp.factory.Factory
     */
    public void degrade() {
        condition = Math.max(0, condition - 10);
    }

    /**
     * Calcule la qualité d'un canard produit selon l'état actuel de la machine.
     *
     * La qualité dépend principalement de l'état (70%), avec une variation aléatoire (0-30%).
     * À appeler obligatoirement dans les implémentations de {@link #produceDuck()}.
     * Ne pas modifier.
     *
     * @return le score de qualité calculé (entre 0 et 100 inclus)
     */
    protected final int computeQuality() {
        int base      = (int) (condition * 0.7);
        int variation = RANDOM.nextInt(31);
        return Math.min(100, base + variation);
    }

    // --- Méthodes abstraites à implémenter dans les sous-classes ---

    /**
     * Produit un canard du type correspondant à cette machine.
     *
     * La qualité du canard dépend de l'état de la machine. Utilisez
     * {@link #computeQuality()} pour obtenir la qualité.
     *
     * @return un nouveau canard produit par cette machine
     */
    public abstract Duck   produceDuck();

    /**
     * Retourne le coût d'achat de cette machine.
     *
     * @return le prix d'achat de cette machine
     */
    public abstract int    getPurchaseCost();

    /**
     * Retourne le nom commercial de cette machine.
     *
     * @return le nom descriptif de cette machine
     */
    public abstract String getName();

    // --- toString fourni ---

    /**
     * Retourne une représentation textuelle de la machine.
     *
     * Inclut le nom, la capacité de production et l'état actuel.
     *
     * @return une chaîne d'information sur la machine
     */
    @Override
    public String toString() {
        return String.format("%s [capacité : %d/tour, état : %d%%]",
                getName(), capacity, condition);
    }
}
