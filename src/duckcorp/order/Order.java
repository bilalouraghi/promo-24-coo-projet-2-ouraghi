package duckcorp.order;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.stock.Stock;

/**
 * Commande client : demande un certain nombre de canards d'un type donné.
 *
 * TODO (Ex4) :
 *   - Implémentez getTotalValue(), canBeFulfilled(), fulfill()
 *   - Implémentez equals() et hashCode() basés sur l'id
 *
 * Les getters et tick() sont fournis.
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class Order {

    private static int counter = 0;

    private final String id;
    private final DuckType duckType;
    private final int quantity;
    private final double pricePerUnit;
    private int turnsRemaining;
    private OrderStatus status;

    /**
     * Constructeur fourni.
     */
    public Order(DuckType duckType, int quantity, double pricePerUnit, int turnsRemaining) {
        this.id             = String.format("CMD-%03d", ++counter);
        this.duckType       = duckType;
        this.quantity       = quantity;
        this.pricePerUnit   = pricePerUnit;
        this.turnsRemaining = turnsRemaining;
        this.status         = OrderStatus.PENDING;
    }

    // --- Getters fournis ---

    public String      getId()              { return id; }
    public DuckType    getDuckType()        { return duckType; }
    public int         getQuantity()        { return quantity; }
    public double      getPricePerUnit()    { return pricePerUnit; }
    public int         getTurnsRemaining()  { return turnsRemaining; }
    public OrderStatus getStatus()          { return status; }

    // --- Méthode fournie ---

    /**
     * Décrémente le délai restant. Si le délai atteint 0, la commande expire.
     * Appelée automatiquement par Game à chaque tour. Ne pas modifier.
     */
    public void tick() {
        if (status == OrderStatus.PENDING) {
            turnsRemaining--;
            if (turnsRemaining <= 0) {
                status = OrderStatus.EXPIRED;
            }
        }
    }

    // --- TODO ---

    /**
     * Retourne la valeur totale de la commande (pricePerUnit * quantity).
     */
    public double getTotalValue() {
        return pricePerUnit * quantity;
    }

    /**
     * Retourne true si le stock contient suffisamment de canards du bon type
     * pour honorer cette commande.
     *
     * Attention à la signature : le paramètre doit accepter tout Stock
     * dont le type générique étend Duck, pas seulement Stock<Duck>.
     */
    public boolean canBeFulfilled(Stock<? extends Duck> stock) {
        return stock.countByType().getOrDefault(duckType, 0) >= quantity;
    }

    /**
     * Marque la commande comme honorée (status = FULFILLED).
     * Appelée par Factory.fulfillOrder() après retrait du stock.
     */
    public void fulfill() {
        this.status = OrderStatus.FULFILLED;
    }

    /**
     * Compare cette commande avec un autre objet en fonction de son identifiant unique.
     *
     * Deux commandes sont égales si et seulement si elles possèdent le même ID.
     * Cela permet d'utiliser les commandes dans un Set ou une Map sans doublons.
     *
     * @param o l'objet à comparer avec cette commande
     * @return true si les deux objets représentent la même commande (même ID),
     *         false sinon
     * @see #hashCode()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id.equals(order.id);
    }

    /**
     * Retourne le code de hachage de cette commande basé sur son identifiant unique.
     *
     * Cette implémentation est cohérente avec {@link #equals(Object)} : si deux
     * commandes sont égales (même ID), elles produisent le même code de hachage.
     *
     * @return le code de hachage basé sur l'identifiant
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // --- toString fourni ---

    @Override
    public String toString() {
        return String.format("[%s] %dx %s → %.0f€/u (%.0f€) — %d tour(s) — %s",
                id, quantity, duckType.getLabel(), pricePerUnit,
                pricePerUnit * quantity, turnsRemaining, status);
    }
}
