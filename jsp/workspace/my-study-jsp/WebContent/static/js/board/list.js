const $ul = $('ul');
let text = "";

boards.forEach(board => {
	text += `
		<li>
			<div>
				<a href="javascript:location.href='${contextPath}/board/detailOk.board'">
					<section class="content-container">
						<h4>${board.boardTitle}</h4>
						<h5>${board.memberName}</h5>
						<h6>${elapsedTime(board.boardRegisterDate)}</h6>
						<h6>조회 ${board.boardReadCount}</h6>
					</section>
				</a>
			</div>
		</li>
	`;
})

$ul.append(text);

/*시간 계산*/
function elapsedTime(date) {
  const start = new Date(date);
  const end = new Date();

  const diff = (end - start) / 1000;
  
  const times = [
    { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
    { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
    { name: '일', milliSeconds: 60 * 60 * 24 },
    { name: '시간', milliSeconds: 60 * 60 },
    { name: '분', milliSeconds: 60 },
  ];

  for (const value of times) {
    const betweenTime = Math.floor(diff / value.milliSeconds);

    if (betweenTime > 0) {
      return `${betweenTime}${value.name} 전`;
    }
  }
  return '방금 전';
}