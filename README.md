# LeBon2i
Fake Le bon coin<br>
Team : 
- François Monteil
- Jean Szturemski
- Leandre Carpentier
- Alexandre Bodart

# Comment utiliser le projet ?
## Généner sa base de donnée
- Utiliser le script pour créer la bdd sous mysql
- Les identifiants doivent être utilisateur: root, mot de passe: root
## Créer le projet IntelliJ
- Créer un projet avec IntelliJ
- Dans Additionnal librairies and frameworks
  - Ajouter :
    - Hibernate
    - JavaEE Persistance (en utilisant la version 2.1)
  - Terminer de créer le projet sans rien parmétrer d'autre
- Une fois le projet créé, cliquer sur "File"
- Project structure
- Libraries, +
- From Maven
- Taper "mysql" et cliquer sur la loupe
- Choisissez "mysql:mysql-connector-java:8.0.19" et cliquer sur OK

## Lancer le projet LeBon2i
- Ouvrir le projet
- Lancer dans le package test la configuration 'InitBdd'
- Lancer dans ce même package la configuration 'Main'
  - L'interface de connexion va s'afficher.
  - Il est possible de se connecter à l'application via les identifiants test/test.
