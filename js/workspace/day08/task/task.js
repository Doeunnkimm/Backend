const banner = document.querySelector('div.banner');
const image_divs = document.querySelectorAll('div.banner div.image');
const first_div = document.querySelector('#first-temp');
const last_div = document.querySelector('#last-temp');
const prev_btn = document.querySelector('button.prev');
const next_btn = document.querySelector('button.next');
const page_number = document.querySelector('div.page-number');
let count = 1;
let check = true;

image_divs.forEach((image_div, i) => (image_div.style.backgroundImage = `url(00${i + 1}.jpg)`));
first_div.style.backgroundImage = `url(006.jpg)`;
last_div.style.backgroundImage = `url(001.jpg)`;

prev_btn.style.background = `url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNTIiIGhlaWdodD0iNTIiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CiAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgxIDEpIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxjaXJjbGUgZmlsbC1vcGFjaXR5PSIuMiIgZmlsbD0iIzAwMCIgY3g9IjI1IiBjeT0iMjUiIHI9IjI1Ii8+CiAgICAgICAgPHBhdGggZD0iTTIyLjI4NSAzMy42OTlhMSAxIDAgMCAwIDEuMzE5LjA5OGwuMDk1LS4wODIgOC03LjgxN2ExIDEgMCAwIDAgLjEwOC0xLjMwNmwtLjA4LS4wOTYtNy43MjMtOC4xODJhMSAxIDAgMCAwLTEuNTM1IDEuMjc2bC4wOC4wOTYgNy4wNDkgNy40NjktNy4yOTcgNy4xM2ExIDEgMCAwIDAtLjA5OCAxLjMxOWwuMDgyLjA5NXoiIGZpbGw9IiNGRkYiIGZpbGwtcnVsZT0ibm9uemVybyIvPgogICAgPC9nPgo8L3N2Zz4K')`;
next_btn.style.background = `url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNTIiIGhlaWdodD0iNTIiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CiAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgxIDEpIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxjaXJjbGUgZmlsbC1vcGFjaXR5PSIuMiIgZmlsbD0iIzAwMCIgY3g9IjI1IiBjeT0iMjUiIHI9IjI1Ii8+CiAgICAgICAgPHBhdGggZD0iTTIyLjI4NSAzMy42OTlhMSAxIDAgMCAwIDEuMzE5LjA5OGwuMDk1LS4wODIgOC03LjgxN2ExIDEgMCAwIDAgLjEwOC0xLjMwNmwtLjA4LS4wOTYtNy43MjMtOC4xODJhMSAxIDAgMCAwLTEuNTM1IDEuMjc2bC4wOC4wOTYgNy4wNDkgNy40NjktNy4yOTcgNy4xM2ExIDEgMCAwIDAtLjA5OCAxLjMxOWwuMDgyLjA5NXoiIGZpbGw9IiNGRkYiIGZpbGwtcnVsZT0ibm9uemVybyIvPgogICAgPC9nPgo8L3N2Zz4K')`;
page_number.innerHTML = `${count}/${image_divs.length}`;

let slide = setInterval(() => autoSlide(), 2000);

prev_btn.addEventListener('click', () => {
  if (!check) return;
  check = false;
  clearInterval(slide);
  banner.style.transform = `translate(${-1900 * --count}px)`;
  banner.style.transition = 'transform 0.7s';
  page_number.innerHTML = `${count}/${image_divs.length}`;

  if (count === 0) {
    page_number.innerHTML = `6/${image_divs.length}`;
    setTimeout(() => {
      banner.style.transition = 'transform 0s';
      banner.style.transform = `translate(-11400px)`;
    }, 700);
    count = 6;
  }
  slide = setInterval(() => autoSlide(), 2000);
  setTimeout(() => (check = true), 700);
});

next_btn.addEventListener('click', () => {
  if (!check) return;
  check = false;
  clearInterval(slide);
  banner.style.transform = `translate(${-1900 * ++count}px)`;
  banner.style.transition = 'transform 0.7s';
  page_number.innerHTML = `${count}/${image_divs.length}`;

  if (count === 7) {
    page_number.innerHTML = `1/${image_divs.length}`;
    setTimeout(() => {
      banner.style.transition = 'transform 0s';
      banner.style.transform = `translate(-1900px)`;
    }, 700);
    count = 1;
  }
  slide = setInterval(() => autoSlide(), 2000);
  setTimeout(() => (check = true), 700);
});

function autoSlide() {
  check = false;
  banner.style.transform = `translate(${-1900 * ++count}px)`;
  banner.style.transition = 'transform 0.7s';
  page_number.innerHTML = `${count}/${image_divs.length}`;

  if (count === 7) {
    page_number.innerHTML = `1/${image_divs.length}`;
    setTimeout(() => {
      banner.style.transition = 'transform 0s';
      banner.style.transform = `translate(-1900px)`;
    }, 700);
    count = 1;
  }
  setTimeout(() => (check = true), 700);
}
