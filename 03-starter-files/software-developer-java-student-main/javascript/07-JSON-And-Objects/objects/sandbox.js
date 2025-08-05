let cat = new Object();
cat.name = "Fluffy";
cat.breed = "Bombay Cat";
cat.age = 3;
cat.meow = function() {
    console.log(`${this.name} says 'Meow!'.`);
};

console.log(cat);
cat.meow();

let cat2 = {
    name: "Fluffy",
    breed: "Bombay Cat",
    age: 3,
    meow: function() {
        console.log(`${this.name} says 'Meow!'.`);
    }
};

console.log(cat2);
cat2.meow();

let owner = {
    name: "Jane Doe",
    city: "Chicago"
};

cat.owner = owner;

console.log(cat);
console.log(`${cat.name} is owned by ${cat.owner.name}.`);

// associative array syntax
console.log(cat['breed']);

console.log(typeof(cat.unknown));

delete cat.age;
console.log(cat.age); // undefined

// comparing objects
let cup = {
    color: "blue",
    vol: 12
};

let cup2 = {
    color: "blue",
    vol: 12
};

console.log(cup == cup2); // false

let cup3 = cup2;

console.log(cup3 == cup2); // true

cup2.color = "red";
console.log(cup3.color); // red
console.log(cup.color); // blue

let x = 2;
let y = x;
x = 4;
console.log(y); // still 2


let json = '{"name":"Fritz", "breed":"Tabby", "age":3, "colors":["white","grey","black"], "owner": {"name":"Jane Doe"}}';
let cat4 = JSON.parse(json);
console.log(cat4);

let catsJSON = '[{"name":"Fluffy", "breed":"Bombay Cat", "age":3}, {"name":"Fritz", "breed":"Tabby", "age":3}]';
let catlist = JSON.parse(catsJSON);
console.log(catlist);

let catJSON = JSON.stringify(cat);
console.log(catJSON);