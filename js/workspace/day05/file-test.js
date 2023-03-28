let file = require('fs');

// file.writeFile('경로', '내용', '인코딩', '콜백함수');
// file.writeFile('hello.txt', '안녕하세요', 'utf-8', function (err) {
//   if (err) console.log(err);
//   else console.log('성공');
// });

// file.readFile('경로', '인코딩', '콜백함수');
file.readFile('hello.txt', 'utf-8', function (err, content) {
  if (err) console.log(err);
  else console.log(content);
});
