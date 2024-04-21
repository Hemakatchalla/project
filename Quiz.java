import java.util.List;

public class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size();
    }

    public QuizQuestion getNextQuestion() {
        return questions.get(currentQuestionIndex++);
    }

    public void submitAnswer(int selectedOptionIndex) {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex - 1);
        if (selectedOptionIndex == currentQuestion.getCorrectAnswerIndex()) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }
}

