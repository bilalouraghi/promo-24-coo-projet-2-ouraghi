package duckcorp.duck;

/**
 * Interface représentant un objet dont on peut évaluer la qualité.
 *
 * TODO (Ex1) :
 * - Implémentez isDefective() et getQualityLabel() (méthodes default)
 * 
 * @author Roussille Philippe <roussille@3il.fr>
 */
public interface Qualifiable {

    /**
     * Retourne le score de qualité.
     *
     * @return le score de qualité compris entre 0 et 100 inclus
     */
    int getQualityScore();

    /**
     * Détermine si cet objet est défectueux.
     *
     * Un objet est considéré comme défectueux si son score de qualité
     * est strictement inférieur à 20.
     *
     * @return true si le score de qualité est strictement inférieur à 20,
     *         false sinon
     */
    default boolean isDefective() {
        if (getQualityScore() < 20) {
            return true;
        }
        return false;
    }

    /**
     * Retourne un libellé décrivant la qualité de cet objet.
     *
     * Le libellé est déterminé selon les seuils suivants :
     * <ul>
     *   <li>score >= 80 : "Excellent"</li>
     *   <li>score >= 50 : "Bon"</li>
     *   <li>score >= 20 : "Médiocre"</li>
     *   <li>score < 20 : "Défectueux"</li>
     * </ul>
     *
     * @return un libellé de qualité
     */
    default String getQualityLabel() {
        if (getQualityScore() >= 80) {
            return "Excellent";
        } else if (getQualityScore() >= 50) {
            return "Bon";
        } else if (getQualityScore() >= 20) {
            return "Médiocre";
        } else {
            return "Défectueux";
        }
    }
}
