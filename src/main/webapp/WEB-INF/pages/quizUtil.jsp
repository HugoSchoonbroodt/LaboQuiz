<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<h1>Quiz</h1>
<c:if test="${not empty quiz}">
    <h2>${quiz.quiz_title}</h2>
    <p>${quiz.quiz_desc}</p>
    <h3>Questions:</h3>
    <c:forEach var="question" items="${quiz.questions}">
        <h4>${question.question_text}</h4>
        <ul>
            <c:forEach var="answer" items="${question.answers}">
                <li>${answer.answer_text}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</c:if>
<c:if test="${empty quiz}">
    <p>No quiz selected.</p>
</c:if>
</body>
</html>
