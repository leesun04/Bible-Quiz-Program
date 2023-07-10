package Quiz.Classes;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HumanVariousQuiz extends VariousAnswerQuiz {
    Scanner sc = new Scanner(System.in);
    String question;
    String answer;
    List<String> answers = new ArrayList<>();
    String select;


    public void inputQuiz() {
        do {
            System.out.println("사람관련된 문제를 입력하세요");
            String q = sc.next();
            this.question = q;
            System.out.println(question);
            do {
                System.out.println("입력하신 문제가 맞나요? A: 예,  B: 다시입력");
                select = sc.next();
                if (select.equals("A")) {
                    System.out.println("입력 되었습니다!");
                } else if (select.equals("B")) {
                    System.out.println("다시 입력하기!");
                } else {
                    System.out.println("잘못 입력했어요!");
                }
            } while (!select.equals("A") && !select.equals("B"));

        } while (!select.equals("A"));
    }

    public void inputAnswer() {
        do {
            System.out.println("정답를 입력하세요");
            String a = sc.next();
            this.answer = a;
            System.out.println(answer);
            do {
                System.out.println("입력하신 정답이 맞나요? A : 예  B : 예, 그리고 추가입력 C : 다시입력");
                select = sc.next();
                if (select.equals("A") || select.equals("B")) {
                    answers.add(answer);
                    System.out.println("입력 되었습니다!");
                } else {
                    System.out.println("잘못 입력했어요!");
                }
            } while (!select.equals("A") && !select.equals("B"));
        } while (!select.equals("A"));
    }


    public void saveJson() {
        Gson gson = new Gson();
        String path = "HumanQuizJson.Json";
        //전체
        JSONObject jsonObject;
        //SHA JSON 배열
        JSONObject SHAJson;
        //LHA JSON 배열
        JSONObject LHAJson;
        //정보를 넣을 JSON 파일
        JSONObject QuizInnerObject = new JSONObject();

        JSONObject writeJson = new JSONObject();
        try {
            int temp;
            JSONParser jsonParser = new JSONParser();
            Reader reader = new FileReader(path);
            jsonObject = (JSONObject) jsonParser.parse(reader);
            SHAJson = (JSONObject) jsonObject.get("SHA");
            LHAJson = (JSONObject) jsonObject.get("LHA");
            temp = LHAJson.size();

            QuizInnerObject.put("Quiz", question);
            QuizInnerObject.put("QuizAnswer", answers);
            LHAJson.put("LHA" + temp, QuizInnerObject);

            writeJson.put("SHA", SHAJson);
            writeJson.put("LHA", LHAJson);

            FileWriter fileWriter = new FileWriter(path);
            gson.toJson(writeJson, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

