<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c"%>    

<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

<script>
const doJoinForm_onSubmit = function(form) {
	form.email.value = form.email.value.trim();
	form.loginPw.value = form.loginPw.value.trim();
	form.loginPwChk.value = form.loginPwChk.value.trim();
	form.name.value = form.name.value.trim();
	
	if(form.email.value.length == 0){
		alert('이메일을 입력해주세요.');
		form.email.focus();
		return;
	}
	
	if(form.loginPw.value.length == 0){
		alert('비밀번호를 입력해주세요.');
		form.loginPw.focus();
		return;
	}
	
	if(form.loginPwChk.value.length == 0){
		alert('비밀번호 확인을 입력해주세요.');
		form.loginPwChk.focus();
		return;
	}
	
	if(form.name.value.length == 0){
		alert('이름을 입력해주세요.');
		form.name.focus();
		return;
	}
	
	if(form.loginPw.value != form.loginPwChk.value){
		alert('비밀번호가 맞는지 다시 확인해주세요.');
		form.loginPwChk.focus();
		return;
	}
	
	form.submit();
}
</script>

<section class="mt-8">
	<div class="container mx-auto">
        <div class="w-9/12 mx-auto">
            <form action="/usr/member/doJoin" method="post" onsubmit="doJoinForm_onSubmit(this); return false;">
                <table class="table table-lg">
                    <tr>
                        <th>이메일</th>
                        <td><input class="input input-bordered w-full max-w-xs" type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input class="input input-bordered w-full max-w-xs" type="text" name="loginPw" /></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td><input class="input input-bordered w-full max-w-xs" type="text" name="loginPwChk" /></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input class="input input-bordered w-full max-w-xs" type="text" name="name" /></td>
                    </tr>
                </table>
                
                <div class="flex justify-center mt-6">
                    <button class="btn btn-wide" type="submit">가입</button>
                </div>
            </form>
        </div>
    </div>
</section>
