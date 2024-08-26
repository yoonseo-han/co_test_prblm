var map = new Map(); 

let number = 0;
let str = "string";
let obj = { a: 1 };
let func = () => {
    console.log('func');
};

map.set(number, 4); //key에 number 가능
map.set(str, 1); // key에 string 가능
map.set(obj, 2); //key에 object 가능
map.set(func, 3); // key에 함수 가능
map.set(number, 0); // 덮어쓰기 가능

console.log(map); // Map(4) {0 => 0, "string" => 1, {…} => 2, ƒunc => 3}

console.log(map.get(str)); 
console.log(map.has(str)); 