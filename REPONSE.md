# Question 1 : Une méthode default dans une interface peut-elle accéder aux champs privés de la classe qui l'implémente ? Justifiez, en vous appuyant sur isDefective() dans Qualifiable et getQualityScore() dans Duck.

## Réponse

Non, une méthode default ne peut pas accéder directement aux champs privés d'une classe qui l'implémente. Dans Qualifiable.java, isDefective() appelle la méthode publique getQualityScore() pour accéder au score, et ne peut pas accéder directement au champ privé qualityScore de Duck.java. Les méthodes default doivent passer par les méthodes publiques de l'interface pour respecter l'encapsulation.