package Quiz;

import Quiz.Classes.HumanQuizFactory;
import Quiz.Classes.NumberQuizFactory;
import Quiz.Classes.PlaceQuizFactory;
import Quiz.Interface.LogicInterface;
import Quiz.Interface.QuizFactory;

import java.util.Scanner;

public class QuizLogic {
    //    QuizFactory qf = new QuizFactory();
    Scanner sc = new Scanner(System.in);
    QuizFactory quizFactory;

    public void quizLogic() {
        String type;
        String answerCount = null;
        LogicInterface quiz;
        do {
            do {
                System.out.println("문제 테마을 선택하세요!");
                System.out.println("A : 사람 관련 B : 장소 관련 C : 숫자 관련 0 : 나가기");
                type = sc.next();
                if (type.equals("A") || type.equals("B") || type.equals("C") || type.equals("0")) {
                    System.out.println("입력되었습니다!");
                } else {
                    System.out.println("잘못 입력했습니다!");
                }
            } while (!type.equals("A") && !type.equals("B") && !type.equals("C") && !type.equals("0"));
            if (!type.equals("0")) {
                do {
                    System.out.println("문제 유형을 선택하세요!");
                    System.out.println("A : 객관식 B : 단답식 C : 주관식 ");
                    answerCount = sc.next();
                    if (answerCount.equals("A") || answerCount.equals("B") || answerCount.equals("C")) {
                        System.out.println("입력 되었습니다!");
                    } else {
                        System.out.println("잘못 입력했습니다!");
                    }
                } while (!answerCount.equals("A") && !answerCount.equals("B") && !answerCount.equals("C"));
            } else {
                System.out.println("나가기!");
            }
            if (type.equals("A") && answerCount.equals("A") || type.equals("A") && answerCount.equals("B")) {
                System.out.println("사람 단일 문제");
                quizFactory = new HumanQuizFactory();
                quiz = quizFactory.createOneAnswerQuiz();
                quiz.quizAlgorithm();
            } else if (type.equals("A") && answerCount.equals("C")) {
                System.out.println("사람 복수 문제");
                quizFactory = new HumanQuizFactory();
                quiz = quizFactory.createVariousAnswerQuiz();
                quiz.quizAlgorithm();
            } else if (type.equals("B") && answerCount.equals("A") || type.equals("A") && answerCount.equals("B")) {
                System.out.println("장소 단일 문제");
                quizFactory = new PlaceQuizFactory();
                quiz = quizFactory.createOneAnswerQuiz();
                quiz.quizAlgorithm();
            } else if (type.equals("B") && answerCount.equals("C")) {
                System.out.println("장소 복수 문제");
                quizFactory = new PlaceQuizFactory();
                quiz = quizFactory.createVariousAnswerQuiz();
                quiz.quizAlgorithm();
            } else if (type.equals("C") && answerCount.equals("A") || type.equals("A") && answerCount.equals("B")) {
                System.out.println("숫자 단일 문제");
                quizFactory = new NumberQuizFactory();
                quiz = quizFactory.createOneAnswerQuiz();
                quiz.quizAlgorithm();
            } else if (type.equals("C") && answerCount.equals("C")) {
                System.out.println("숫자 복수 문제");
                quizFactory = new NumberQuizFactory();
                quiz = quizFactory.createVariousAnswerQuiz();
                quiz.quizAlgorithm();
            } else {
                System.out.println("해당 객체가 존재하 지 않아요!");
            }
        } while (!type.equals("0"));
    }
}

