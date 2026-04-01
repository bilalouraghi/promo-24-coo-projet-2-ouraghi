package duckcorp.machine;

/**
 * Interface représentant une machine pouvant être entretenue.
 *
 * TODO (Ex2) :
 *   - Implémentez needsMaintenance() et getConditionLabel() (méthodes default)
 * @author Roussille Philippe <roussille@3il.fr>
 */
public interface Maintainable {

    /**
     * Retourne l'état actuel de la machine.
     *
     * @return l'état de la machine compris entre 0 et 100 inclus
     */
    int getCondition();

    /**
     * Effectue une opération de maintenance sur la machine.
     *
     * Cette opération restaure l'état de la machine (généralement de 40 points,
     * plafonné à 100).
     */
    void maintain();

    /**
     * Détermine si cette machine nécessite une maintenance urgente.
     *
     * Une machine est considérée comme nécessitant une maintenance si son état
     * est strictement inférieur à 30.
     *
     * @return true si l'état est strictement inférieur à 30, false sinon
     */
    default boolean needsMaintenance() {
        if (getCondition() < 30) {
            return true;
        }
        return false;
    }

    /**
     * Retourne un libellé décrivant l'état actuel de la machine.
     *
     * Le libellé est déterminé selon les seuils suivants :
     * <ul>
     *   <li>condition >= 80 : "Parfait"</li>
     *   <li>condition >= 50 : "Correct"</li>
     *   <li>condition >= 30 : "Usé"</li>
     *   <li>condition < 30 : "Critique"</li>
     * </ul>
     *
     * @return un libellé décrivant l'état de la machine
     */
    default String getConditionLabel() {
        if (getCondition() >= 80) {
            return "Parfait";
        } else if (getCondition() >= 50) {
            return "Correct";
        } else if (getCondition() >= 30) {
            return "Usé";
        } else {
            return "Critique";
        }
    }
}
