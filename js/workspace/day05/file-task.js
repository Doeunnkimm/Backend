// 삼품명, 가격, 재고를 JS 객체에 프로퍼티로 담는다.
// JSON 형식으로 반환한 뒤, product.json으로 출력한다.
// product.json에 있는 JSON 형식을 JS Object 타입으로 변환하여 각 프로퍼티를 출력한다.

let fs = require('fs');

let product = { name: '시계', price: 10000, stock: 5 };
let productJSON = JSON.stringify(product);
let result;
// console.log(productJSON);

// fs.writeFile('product.json', productJSON, 'utf-8', err => {
//   if (err) console.log(err);
//   else console.log('성공!');
// });

result = JSON.parse(
  fs.readFileSync('product.json', (err, content) => {
    if (err) console.log(err);
  })
);

// const productObject = JSON.parse(productJSON);
// console.log(productObject);

console.log(result);
