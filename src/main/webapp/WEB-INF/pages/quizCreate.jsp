<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Quiz</title>
</head>
<body>
<h1>Create Quiz</h1>

<form method="post" action="quizCreate">
    <label for="quizTitle">Quiz Title:</label>
    <input type="text" id="quizTitle" name="quizTitle" required><br>

    <label for="quizDescription">Quiz Description:</label>
    <textarea id="quizDescription" name="quizDescription" required></textarea><br>

    <h2>Questions</h2>

    <div id="questionsContainer">
        <div class="question">
            <label>Question:</label>
            <textarea name="question0" required></textarea><br>

            <label>Answers:</label><br>
            <input type="text" name="answer-question0-0" required>
            <input type="radio" name="isCorrect-question0" value="answer-question0-0" required> Correct<br>

            <input type="text" name="answer-question0-1" required>
            <input type="radio" name="isCorrect-question0" value="answer-question0-1" required> Correct<br>

            <input type="text" name="answer-question0-2" required>
            <input type="radio" name="isCorrect-question0" value="answer-question0-2" required> Correct<br>

            <input type="text" name="answer-question0-3" required>
            <input type="radio" name="isCorrect-question0" value="answer-question0-3" required> Correct<br>
        </div>
    </div>

    <button type="button" onclick="addQuestion()">Add Question</button><br>

    <button type="submit">Create Quiz</button>
</form>

<script>
    var questionIndex = 1;

    function addQuestion() {
        var questionsContainer = document.getElementById("questionsContainer");

        var questionDiv = document.createElement("div");
        questionDiv.classList.add("question");

        var questionLabel = document.createElement("label");
        questionLabel.textContent = "Question:";

        var questionTextarea = document.createElement("textarea");
        questionTextarea.name = "question" + questionIndex;
        questionTextarea.required = true;

        var answersLabel = document.createElement("label");
        answersLabel.textContent = "Answers:";

        var lineBreak = document.createElement("br");

        var answerInput, correctRadio;
        for (var i = 0; i < 4; i++) {
            answerInput = document.createElement("input");
            answerInput.type = "text";
            answerInput.name = "answer" + questionIndex + "-" + i;
            answerInput.required = true;

            correctRadio = document.createElement("input");
            correctRadio.type = "radio";
            correctRadio.name = "isCorrect" + questionIndex;
            correctRadio.value = "answer" + questionIndex + "-" + i;
            correctRadio.required = true;
            correctRadio.textContent = " Correct";

            questionDiv.appendChild(answerInput);
            questionDiv.appendChild(correctRadio);
            questionDiv.appendChild(lineBreak.cloneNode());
        }

        questionsContainer.appendChild(questionDiv);

        questionIndex++;
    }
</script>
</body>
</html>
