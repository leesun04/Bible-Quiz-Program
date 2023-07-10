package Analyze;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CheckGrades {
    int temp;
    double percent;
    int percent1;
    ArrayList<JSONObject> jsonArray;// 정답 받는 필드
    public void checkGrades() {
        System.out.println("------------- 유저별 채점 결과 -------------");
        readJson();
        for (int a= 0; a<temp; a++){
            percent =  (Double.parseDouble(jsonArray.get(a).get("answerCount").toString()) /(Double.parseDouble( jsonArray.get(a).get("allCount").toString())));
            percent1 = (int) (percent *100);
            System.out.println("유저 이름 : " + jsonArray.get(a).get("name") );
            System.out.println("맞은 갯수 : " + jsonArray.get(a).get("answerCount")+ "    전체 갯수 : " + jsonArray.get(a).get("allCount") + "     정답률 : "  + percent1 + "%");
            System.out.println();
        }
    }
    void readJson(){
        String path = "User.Json";
        JSONObject jsonObject;


        try {
            JSONParser jsonParser = new JSONParser();
            Reader reader = new FileReader(path);
            jsonObject = (JSONObject) jsonParser.parse(reader);
            jsonArray = (ArrayList<JSONObject>) jsonObject.get("User");
            this.temp = jsonArray.size();
            System.out.println(temp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}