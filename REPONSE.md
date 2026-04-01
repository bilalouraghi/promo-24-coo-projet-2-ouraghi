# Question 1 : Une méthode default dans une interface peut-elle accéder aux champs privés de la classe qui l'implémente ? Justifiez, en vous appuyant sur isDefective() dans Qualifiable et getQualityScore() dans Duck.

## Réponse

Non, une méthode default ne peut pas accéder directement aux champs privés d'une classe qui l'implémente. Dans Qualifiable.java, isDefective() appelle la méthode publique getQualityScore() pour accéder au score, et ne peut pas accéder directement au champ privé qualityScore de Duck.java. Les méthodes default doivent passer par les méthodes publiques de l'interface pour respecter l'encapsulation.

# Question 2 : Dans ce projet, Maintainable est une interface et Machine est une classe abstraite. Quelle règle Java vous aurait empêché de faire l'inverse (rendre Maintainable abstraite et Machine une interface) ? Plus généralement, quand choisit-on une interface plutôt qu'une classe abstraite ?

## Réponse

En Java, une interface ne peut pas contenir de champs d'instance (sauf des constantes), tandis qu'une classe abstraite peut en contenir. Si Maintainable était une classe abstraite, elle pourrait avoir des champs d'instance, ce qui n'est pas le cas pour une interface. De plus, une classe peut implémenter plusieurs interfaces mais ne peut hériter que d'une seule classe abstraite. On choisit une interface lorsque l'on veut définir un contrat que plusieurs classes peuvent implémenter sans partager une hiérarchie de classes, tandis qu'une classe abstraite est choisie lorsque l'on veut fournir une implémentation partielle et partager du code entre les classes qui en héritent.