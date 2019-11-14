

## Api pour Client:

Port : 8081

## List Client:

GET "/clients"


## Recherhe client par son cin:

GET "/clients/cin"
Exemple : "/clients/cin/10"


**
## Recherhe client par son type:

GET "/clients/type/"
Exemple : "/clients/type/Etranger"


**

## Recherche client par son id :

**
GET "/clients/id"
Exemple : "/clients/1"


**

## Ajouter un clients:

**
POST "/clients"
Exemple : 

    {

"cin": "50",
	"nom":"ines",
	"prenom":"ines",
	"tel":"2513642",
	"email":"ines@gmail.com",
	"adresse":"tunis",
	"type":"Etranger"
}

**

## Mise à jour un client:

**
PUT "/clients/id"
Exemple : "/clients/1"

    {

"cin": "50",
	"nom":"ines",
	"prenom":"ines",
	"tel":"2513642",
	"email":"ines@gmail.com",
	"adresse":"tunis",
	"type":"Etranger"
}

**
[Economat Doc](GestionClientt/README.md)
## Supprimer un client

** :
DELETE "/clients/id"
Exemple : "/clients/1"

