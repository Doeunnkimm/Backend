HTMLCollection.prototype.forEach = Array.prototype.forEach;

const input = document.getElementById('type-input');
const button = document.getElementById('type-button');
const arLine = document.getElementsByClassName('line');
const arType = document.getElementsByClassName('type');

console.log(arLine);

const typeList = [];
arType.forEach(el => typeList.push(el.innerHTML));

function onClickButton() {
  const index = typeList.indexOf(input.value);

  if (!input.value) {
    return;
  }
  if (index === -1) {
    alert('다시 시도해주세요');
    arLine.forEach(line => (line.style.backgroundColor = 'white'));
    return;
  }
  arLine.forEach(line => (line.style.backgroundColor = 'white'));
  arLine[index].style.backgroundColor = 'pink';
}

button.addEventListener('click', onClickButton);
