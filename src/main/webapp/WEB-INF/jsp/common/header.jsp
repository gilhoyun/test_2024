<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- 테일윈드CSS -->
<script src="https://cdn.tailwindcss.com"></script>
<!-- 데이지 UI -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.14/dist/full.min.css" rel="stylesheet" type="text/css" />
<!-- JQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- 폰트어썸 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<!-- common css -->
<link rel="stylesheet" href="/resource/common.css" />
</head>
<body>
	<section class="bg-stone-400 flex justify-between items-center p-3 text-white px-32">
		<a href="/" class="mr-auto">HOME</a> 

		<div class="flex space-x-4">
		     <a href="/usr/article/list">게시물</a>
			<c:choose>
				<c:when test="${sessionScope.loginedMemberId != null}">
					<a href="/usr/member/logout">로그아웃</a>
					<a href="/usr/member/myPage">마이페이지</a>
				</c:when>
				<c:otherwise>
					<a href="/usr/member/join">회원가입</a>
					<a href="/usr/member/login">로그인</a>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</body>
</html>
