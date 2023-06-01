<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>유저 등록 화면 </h2>
	<hr/><br/>
	<!-- 
		[입력값 검증 결과 테스트 시나리오]
		1. 유효한 데이터 입력 
		2. 우편번호를 빈 값으로 입력 
		3. 카드번호를 빈 값으로 입력 
		4. 카드 유효년월 과거 날짜 입력  
		
		[입력한 값 검증 결과 테스트 시나리오]
		1. 유효한 데이터 입력
		2. 사용자 아이디를 빈 값으로 입력 후 진행
		3. 사용자 이름을 빈 값으로 입력 후 진행
		4. 사용자 이름의 길이를 최대값보다 크게 입력 
		5. 사용자 이메일 주소를 형식에 맞지 않게 입력 
		6. 사용자 생년월일을 과거가 아닌 날짜로 입력
	 -->
	<form:form modelAttribute="member" method="post" action="/validation/result3">
		<table>
			<tr>
				<td>유저 ID</td>
				<td>
					<form:input path="userId"/>
					<font color="red">
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<form:input path="password"/>
					<font color="red">
						<form:errors path="password"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>E-MAIL</td>
				<td>
					<form:input path="email"/>
					<font color="red">
						<form:errors path="email"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<form:input path="dateOfBirth" type="date"/>
					<font color="red">
						<form:errors path="dateOfBirth"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<form:input path="address.postCode"/>
					<font color="red">
						<form:errors path="address.postCode"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<form:input path="address.location"/>
					<font color="red">
						<form:errors path="address.location"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>카드1 - 번호</td>
				<td>
					<form:input path="cardList[0].no"/>
					<font color="red">
						<form:errors path="cardList[0].no"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>카드1 - 유효년월</td>
				<td>
					<form:input path="cardList[0].validMonth"/>
					<font color="red">
						<form:errors path="cardList[0].validMonth"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>카드2 - 번호</td>
				<td>
					<form:input path="cardList[1].no"/>
					<font color="red">
						<form:errors path="cardList[1].no"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>카드2 - 유효년월</td>
				<td>
					<form:input path="cardList[1].validMonth"/>
					<font color="red">
						<form:errors path="cardList[1].validMonth"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>