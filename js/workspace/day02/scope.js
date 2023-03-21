// var x = 20;
// global.x = 20; // node에서의 최상위 객체가 global <- node에만 있음. 따라서 브라우저에서는 사용 X
// window.x = 20; // 그래서 브라우저에서는 옆과 같이 사용해야 함

// globalThis.x = 20; // node라면 global객체, window라면 window 객체로 선언해줌 --> 이걸 쓰자

// function f() {
//     var x = 10; // 지역변수
//     y = 20; // 전역 변수
//     var z = 30; // 지역변수
//     console.log(x); // 10
//     console.log(global.x); // 20
//     console.log(y); // 20
// }

// f();

// console.log(x); // 20
// console.log(y); // 20
// console.log(z); // f 함수 안에 지역 함수라 사용 X

// for는 함수가 아니기 때문에 밖에서도 사용할 수 있다
// for(var i=0; i<10; i++) {

// }
// console.log(i); // 10

// for(let i=0; i<10; i++) {

// }
// console.log(i); // error