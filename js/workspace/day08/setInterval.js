let interval = setInterval(function () {
  console.log('안녕하세요');
}, 1000);

setTimeout(() => {
  clearInterval(interval);
}, 5100);
