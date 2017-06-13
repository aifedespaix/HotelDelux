# HotelDeluXxX
Le porno est en suplément, mais les luxxx est présent !

# 1 Script BDD :

/db_final.sql
 Evitez d'utiliser phpmyadmin, prennez un logiciel qui permet d'executer des requetes dans votre base directement.
 Si votre base s'appelle hotel, faites ça avant d'executer le script :
 
 drop database if exist hotel;
 create database hotel;
 use database hole;
 
 A l'execution du script, si ça plante, c'est surement à cause des clés étrangères.
 Pour passer le problème :
 a) désactivez la gestion de clés étrangères durant l'execution et script.
 b) Sinon, lancez tous les script en ignorant les lignes erronnées, lancez le script 3 - 4 fois, en théorie la base sera constuite complètement 
 (ça foncitonne chez moi (Executer avec la console d'intellij idea, car elle permet d'ignorer les requetes echouées)
 
 # 2 hibernate
 Oubliez pas de préciser votre config BDD dans hibernate.cfg.xml
 
 Pour un mysql sous windows 10 avec un xamp ou wamp, vous devrez avoir quelque chose comme ça :
      <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hotel</property>
      <property name="hibernate.connection.username">root</property>
      <property name="hibernate.connection.password"></property>
      
  # 3 Librairies Java
  Oubliez pas d'importer dans la gestion de votre ID les librairies (Progiciel_hotelerie/Librairies/Java et JavaFx)
  
  # 4 Connexion
  
  Pour se connecter à l'appli, un compte par défaut est présent : 
  identifiant   : a
  mot de passe  : a
  
