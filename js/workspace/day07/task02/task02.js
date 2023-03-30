const message = document.getElementById('result-message');
const input = document.getElementById('input');
const button = document.getElementById('button');

const numbers = '0123456789.';
const texts = '영일이삼사오육칠팔구점';

function onClickButton() {
  const arInputText = input.value.split('');
  let result = '';

  if (!input.value) {
    return;
  }
  for (let i = 0; i < arInputText.length; i++) {
    if (!numbers.includes(arInputText[i])) {
      message.innerHTML = '숫자만 입력해주세요';
      return;
    }
  }
  arInputText.forEach((num, i) => (result += texts[numbers.indexOf(num)]));
  message.innerHTML = result;
}

button.addEventListener('click', onClickButton);
