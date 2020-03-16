<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="kr.or.connect.todo.dto.TodoDto"%>

<c:set var="list" value='<%=request.getAttribute("todoList")%>' />
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
			<nav class="header_nav">
				<button class="btn_newtodo">새로운 TODO 등록</button>
			</nav>
		</header>
		<section class="container">
			<header class="container_top">
				<h1 class="h1_list_name">TODO</h1>
				<h1 class="h1_list_name">DOING</h1>
				<h1 class="h1_list_name">DONE</h1>
			</header>
			<section class="container_bottom">
				<ul class="card_list card_list_TODO">
					<c:forEach var="it" items="${list }">
						<c:if test='${it.type == "TODO" }'>
							<li class="card ${it.type }" id='${it.id }'>
								<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
								${it.name }, 우선순위 ${it.sequence }
								<button class="card_button">➔</button>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<ul class="card_list card_list_DOING">
					<c:forEach var="it" items="${list }">
						<c:if test='${it.type == "DOING" }'>
							<li class="card ${it.type }" id='${it.id }'>
								<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
								${it.name }, 우선순위 ${it.sequence }
								<button class="card_button">➔</button>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<ul class="card_list card_list_DONE">
					<c:forEach var="it" items="${list }">
						<c:if test='${it.type == "DONE" }'>
							<li class="card ${it.type }" id='${it.id }'>
								<h3 class="card_title">${it.title }</h3> 등록날짜: ${it. regDate},
								${it.name }, 우선순위 ${it.sequence }
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</section>
		</section>
	</div>
</body>
<script src="/todo_scripts/main.js"></script>
</html>
