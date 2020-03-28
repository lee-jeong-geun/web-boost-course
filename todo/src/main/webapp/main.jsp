<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="kr.or.connect.todo.dto.TodoDto"%>

<c:set var="todoList" value='<%=request.getAttribute("TODO")%>' />
<c:set var="doingList" value='<%=request.getAttribute("DOING")%>' />
<c:set var="doneList" value='<%=request.getAttribute("DONE")%>' />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="/todo_css/main.css">
</head>
<body>
	<div id="wrap">
		<header class="header">
			<h2 class="header_title">나의 해야할 일들</h2>
			<button onclick="location.href='new'" class="header_button_newtodo">새로운 TODO 등록</button>
		</header>
		<section class="container">
			<section class="card_list_container">
				<h1 class="card_list_name">TODO</h1>
				<ul class="card_list card_list_todo">
					<c:forEach var="it" items="${todoList }">
						<li class="card" data-id='${it.id }' data-type='${it.type }'>
							<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
							${it.name }, 우선순위 ${it.sequence }
							<button class="card_button">➔</button>
						</li>
					</c:forEach>
				</ul>
			</section>
			<section class="card_list_container">
				<h1 class="card_list_name">DOING</h1>
				<ul class="card_list card_list_doing">
					<c:forEach var="it" items="${doingList }">
						<li class="card" data-id='${it.id }' data-type='${it.type }'>
							<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
							${it.name }, 우선순위 ${it.sequence }
							<button class="card_button">➔</button>
						</li>
					</c:forEach>
				</ul>
			</section>
			<section class="card_list_container">
				<h1 class="card_list_name">DONE</h1>
				<ul class="card_list card_list_done">
					<c:forEach var="it" items="${doneList }">
						<li class="card" data-id='${it.id }' data-type='${it.type }'>
							<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
							${it.name }, 우선순위 ${it.sequence }
						</li>
					</c:forEach>
				</ul>
			</section>
		</section>
	</div>
</body>
<script src="/todo_scripts/main.js"></script>
</html>
