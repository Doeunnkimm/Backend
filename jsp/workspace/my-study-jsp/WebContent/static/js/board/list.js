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
						<h6>조회 ${board.boardReadCount}</h6>
					</section>
				</a>
			</div>
		</li>
	`;
})

$ul.append(text);