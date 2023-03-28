// 상품명, 가격, 재고를 프로퍼티로 담고 있는 Object 3개 선언한다.
// 3개의 Object를 1개의 Array 객체에 모두 담는다.
// JSON으로 변경시킨다.

function Item(name, price, stock) {
  this.name = name;
  this.price = price;
  this.stock = stock;
}

let shose = new Item('신발', 10000, 2);
let watch = new Item('시계', 50000, 4);
let coffee = new Item('커피', 5000, 7);

let itemArray = new Array(shose, watch, coffee);
let itemJSON = JSON.stringify(itemArray);

console.log(itemJSON);
