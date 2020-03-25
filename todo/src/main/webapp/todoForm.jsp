<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New</title>
<link rel="stylesheet" href="/todo_css/todoForm.css">
</head>

<body>
	<div id="wrap">
		<h1>할일 등록</h1>
		<form action="/register" method="post" class="form_container">
			<section class="title_container">
				<label for="title">어떤일인가요?</label>
				<input type="text" id="title" name="new_title" placeholder="swift 공부하기(24자까지)" maxlength="100" required/>
			</section>
			
			<section class="name_container">
				<label for="name">누가 할일인가요?</label>
				<input type="text" id="name" name="new_name" placeholder="홍길동" required/>
			</section>
			
			<section class="sequence_container">
				<span>우선순위를 선택하세요</span>
				<ul class="sequence_list">
					<li>
						<label for="sequence_1"> 
							<input type="radio" id="sequence_1" name="new_sequence" required/>1순위
						</label>
					</li>
					<li>
						<label for="sequence_2">
							<input type="radio" id="sequence_2" name="new_sequence"/>2순위
						</label>
					</li>
					<li>
						<label for="sequence_3">
							<input type="radio" id="sequence_3" name="new_sequence"/>3순위
						</label>
					</li>
				</ul>
			</section>
			
			<section class="button_container">
				<button type="button" onclick="location.href='main'" class="button button_white">&#60; &nbsp이전</button>
				<section class="button_list_right">
					<button type="submit" class="button button_blue">제출</button>
					<button type="reset" class="button button_blue">내용지우기</button>
				</section>
			</section>
		</form>
	</div>
</body>
<script type="text/javascript">
const element = document.querySelector("#title");

function maxLengthCheck(event) {
	if (this.value.length > 24) {
		const temp = this.value[24];
		this.value = this.value.replace(this.value.slice(0), this.value.slice(0, 23) + temp);
		event.target.innerText = this.value;
	}
}

element.addEventListener("input", maxLengthCheck);
</script>
</html>