
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAWEESOFT on 11/23/2016 AD.
 */
public class Main {
    public static void main(String[] ar) {
        Result[] expSys = loadData("./src/exp-sys.json");
        Result[] imagePro = loadData("./src/image-processing.json");

        List<Result> answer = new ArrayList<Result>();
        for (int i = 0; i<expSys.length; i++) {
            answer.add(expSys[i]);
        }

        for(int i = 0;i<imagePro.length; i++) {
            Result res = imagePro[i];
            int pos = answer.indexOf(res);
            if(pos == -1 && res.getPercantage() > 85) {
                res.setPercantage(res.getPercantage()/2);
                answer.add(res);
            }else if(pos >= 0 && res.getPercantage() < 45) {
                answer.remove(pos);
            }else if(pos >= 0 && res.getPercantage() >= 45) {
                Result dummy = answer.get(pos);
                dummy.setPercantage((dummy.getPercantage() + res.getPercantage()) /2);
            }
        }
        answer.sort(new Compare());
        printList(answer);

    }

    public static void printList(List<Result> results) {
        for(Result res : results) {
            System.out.println(res.getName());
            System.out.println(res.getPercantage());
            System.out.println("-------");
        }
    }

    public static Result[] loadData(String path) {
        Gson gson = new Gson();
        Result[] results = null;
        try {
            FileInputStream fs = new FileInputStream(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(fs));
            String str = null;
            String result = "";
            while((str = in.readLine()) != null) {
                result += str;
            }
            results = gson.fromJson(result, Result[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
