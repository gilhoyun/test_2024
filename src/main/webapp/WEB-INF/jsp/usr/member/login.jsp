<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<script>
	const doLoginForm_onSubmit = function(form) {
		form.email.value = form.email.value.trim();
		form.loginPw.value = form.loginPw.value.trim();

		if (form.email.value.length == 0) {
			alert('이메일을 입력해주세요.');
			form.email.focus();
			return;
		}

		if (form.loginPw.value.length == 0) {
			alert('비밀번호를 입력해주세요.');
			form.loginPw.focus();
			return;
		}

		form.submit();
	}
</script>


<section class="mt-8">
	<div class="container mx-auto">
		<div class="w-6/12 mx-auto">
				<table class="table table-lg">
				<form action="/usr/member/doLogin" method="post" onsubmit="doLoginForm_onSubmit(this); return false;">
					<tr>
						<th>이메일</th>
						<td><input class="input input-bordered w-full max-w-xs" type="text" name="email" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input class="input input-bordered w-full max-w-xs" type="text" name="loginPw" /></td>
					</tr>
				</table>	
				<div class="flex justify-center mt-6">
					<button class="btn btn-wide" type="submit">로그인</button>
				</div>
				</form>
			
		</div>
	</div>
</section>