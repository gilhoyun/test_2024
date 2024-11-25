<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<%@ include file="/WEB-INF/jsp/common/header.jsp"%>

<section class="mt-8">
	<div class="container mx-auto">
		<div class="w-9/12 mx-auto">
			<table class="table table-lg">
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
					<td>${member.name }</td>
				</tr>
			</table>
		</div>
		<div class="w-9/12 mx-auto mt-3 text-sm flex justify-end">
			<a class="btn btn-sm" href="modifyPage">회원정보수정</a>
		</div>
	</div>
</section>
