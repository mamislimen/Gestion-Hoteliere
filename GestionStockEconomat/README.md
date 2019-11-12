

## Api pour Economat :

Port : 8889

## List produit :

GET "/produits"


## Recherhe produit par son nom :

GET "/produits/nom"
Exemple : "/produits/viande"


**

## Recherche prosuit par son id :

**
GET "/produits/id"
Exemple : "/produits/1"


**

## Ajouter un produit :

**
POST "/produits"
Exemple : 

    {
    		"nom" : "viande";
    		"description" : "viande de vache";
    		"categorie" : "Boucherie";
    		"quantite" : 150;
    		"prixUnitaire" : 30000;
    		"fournisseur" : "ste de viande tunise";
    }

**

## Mise à jour un produit :

**
PUT "/produits/id"
Exemple : "/produits/1"

    {
    		"nom" : "viande";
    		"description" : "viande de vache";
    		"categorie" : "Boucherie";
    		"quantite" : 150;
    		"prixUnitaire" : 33000;
    		"fournisseur" : "ste de viande tunise";
    }

**

## Supprimer un produit

** :
DELETE "/produits/id"
Exemple : "/produits/1"

