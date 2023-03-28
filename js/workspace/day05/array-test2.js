// 1~10까지 Array 객체에 담은 후 짝수만 출력
let numbers = new Array(10).fill(1);
numbers
  .map((number, i) => number + i)
  .filter(number => number % 2 === 0)
  .forEach(number => console.log(number));

// 한글을 정수로 변경
let inputText = '삼사오팔';
let text = '영일이삼사오육칠팔구';

console.log(
  inputText
    .split('')
    .map(ch => text.indexOf(ch))
    .join('')
);

// 정수를 한글로 변경
let inputNumber = 6823;
let numbers = '0123456789';
let text = '영일이삼사오육칠팔구';

console.log(
  (inputNumber + '')
    .split('')
    .map(num => text[numbers.indexOf(num)])
    .join('')
);

// 1~100까지 합 출력
let numbers = new Array(100).fill(1);
let sum = numbers.map((number, i) => number + i).reduce((acc, number) => (acc += number));
console.log(sum);
