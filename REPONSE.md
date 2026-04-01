# Question ex1 : Une méthode default dans une interface peut-elle accéder aux champs privés de la classe qui l'implémente ? Justifiez, en vous appuyant sur isDefective() dans Qualifiable et getQualityScore() dans Duck.

## Réponse

Non, une méthode default ne peut pas accéder directement aux champs privés d'une classe qui l'implémente. Dans Qualifiable.java, isDefective() appelle la méthode publique getQualityScore() pour accéder au score, et ne peut pas accéder directement au champ privé qualityScore de Duck.java. Les méthodes default doivent passer par les méthodes publiques de l'interface pour respecter l'encapsulation.

# Question ex2 : Dans ce projet, Maintainable est une interface et Machine est une classe abstraite. Quelle règle Java vous aurait empêché de faire l'inverse (rendre Maintainable abstraite et Machine une interface) ? Plus généralement, quand choisit-on une interface plutôt qu'une classe abstraite ?

## Réponse

En Java, une interface ne peut pas contenir de champs d'instance (sauf des constantes), tandis qu'une classe abstraite peut en contenir. Si Maintainable était une classe abstraite, elle pourrait avoir des champs d'instance, ce qui n'est pas le cas pour une interface. De plus, une classe peut implémenter plusieurs interfaces mais ne peut hériter que d'une seule classe abstraite. On choisit une interface lorsque l'on veut définir un contrat que plusieurs classes peuvent implémenter sans partager une hiérarchie de classes, tandis qu'une classe abstraite est choisie lorsque l'on veut fournir une implémentation partielle et partager du code entre les classes qui en héritent.

# Question ex4:  Expliquez pourquoi canBeFulfilled(Stock<Duck> stock) serait une signature plus restrictive que canBeFulfilled(Stock<? extends Duck> stock). Donnez un exemple de code Java qui compilerait avec la seconde mais pas avec la première.

La signature canBeFulfilled(Stock<Duck> stock) est plus restrictive car elle n'accepte que des objets de type Stock qui contiennent exactement des Duck. En revanche, canBeFulfilled(Stock<? extends Duck> stock) accepte des objets de type Stock qui contiennent des Duck ou n'importe quelle sous-classe de Duck.

nous avons StandardDuck, MiniDuck et LuxuryDuck qui étendent tous Duck. Le code suivant compilerait avec la seconde signature mais pas avec la première :

```java
Order order = new Order(DuckType.STANDARD, 5, 25.0, 3);
Stock<StandardDuck> stockStandard = new Stock<>();
boolean canFulfill = order.canBeFulfilled(stockStandard);
```

Avec canBeFulfilled(Stock<Duck> stock), le compilateur rejette Stock<StandardDuck> car il attend un Stock<Duck> exact. Avec canBeFulfilled(Stock<? extends Duck> stock), c'est accepté car StandardDuck est une sous-classe de Duck.