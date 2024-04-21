import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample quiz questions
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", List.of("London", "Paris", "Berlin", "Rome"), 1));
        questions.add(new QuizQuestion("What is 2 + 2?", List.of("3", "4", "5", "6"), 1));

        Quiz quiz = new Quiz(questions);

        Scanner scanner = new Scanner(System.in);

        while (quiz.hasNextQuestion()) {
            QuizQuestion currentQuestion = quiz.getNextQuestion();
            System.out.println(currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Your answer (1-" + options.size() + "): ");
            int selectedOptionIndex = scanner.nextInt() - 1;

            quiz.submitAnswer(selectedOptionIndex);
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score is: " + quiz.getScore() + "/" + questions.size());

        scanner.close();
    }
}

