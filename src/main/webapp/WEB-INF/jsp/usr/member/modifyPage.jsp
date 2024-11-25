<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<script>
	const doModifyPage_onSubmit = function(form) {
		form.name.value = form.name.value.trim();

		if (form.name.value.length == 0) {
			alert('이름을 입력해주세요.');
			form.name.focus();
			return;
		}

		form.submit();
	}
</script>

<section class="mt-8">
	<div class="container mx-auto">
		<div class="w-9/12 mx-auto">
			<form action="/usr/member/doModifyPage" method="post" onsubmit="doModifyPage_onSubmit(this); return false;">
				<table class="table table-lg">
					<tr>
						<th>번호</th>
						<td>${member.id }</td>
					</tr>
					<tr>
						<th>가입일</th>
						<td>${member.regDate }</td>
					</tr>
					<tr>
						<th>수정일</th>
						<td>${member.updateDate }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${member.email }</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input class="input input-bordered  max-w-xs type="text" name="name" /></td>
					</tr>
				</table>
				<div class="w-9/12 mx-auto mt-6 text-sm flex justify-end">
					<button type="submit" class="btn btn-sm">수정</button>
				</div>
			</form>
		</div>
	</div>
</section>
