# CS361-Final-Project

## Microservices Section
The recipe microservices provided gives a way for users to request recipe of dishes in the database. 
### Requesting Data
To request data, the user service must first clear the file "rcv-service.txt". It should then write the name of the desired dish to the file "req-service.txt".
Example run: clear "rcv-service.txt" and write "bread" to "req-service.txt".
### Receiving Data
To receive data, the user service can read the recipe of the desired dish in the file "rcv-service.txt". The recipe is given in the format <'NAME OF DISH;INGREDIENT1: XXg, INGREDIENT2: XXg, ...'>. If the recipe for the requested dish is not in the database, the line "Recipe does not exists." would be found instead.
### UML for Microservice
![recipe](https://user-images.githubusercontent.com/107161143/236835463-ec08242a-bcdc-4f76-a958-2059ea6e6f22.png)
