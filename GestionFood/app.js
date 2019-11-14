const express = require('express');
const app = express();
const { Pool } = require('pg');
const bodyParser = require('body-parser');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

let foods = [];

const connectionString = 'postgresql://root:root@database:5432/postgres';
const pool = new Pool({
    connectionString: connectionString,
    ssl: false,
});

app.get('/foods', (req, res) => {
      res.end(JSON.stringify(foods));
});

app.post('/addFood', (req, res) => {
    let food = {};
    food.name = req.body.name;
    food.quantity = req.body.quantity;
    foods.push(food);
        res.end(JSON.stringify({status: "success", message: "food added successfully!"}));
});

app.post('/searchFoodbyName', (req, res) => {
    let search = [];
    foods.forEach((f) => {
        if (f.name == req.body.name) {
            search.push(f);
        }
    });
        res.end(JSON.stringify(search));
});
app.delete("/deleteFood", (req, res) => {
    foods.forEach((f) => {
        if (f.name == req.body.name) {
            foods.splice(foods.indexOf(f), 1);
        }
    });

        res.end(JSON.stringify({status: "success", message: "food deleted successfully!"}));

});

app.get('/', (req, res) => {
res.send('hi');
});

require('./eureka-helper/eureka-helper').registerWithEureka('foodService', 9001);
app.listen(9001, () => {
    console.log("rest work");
});
