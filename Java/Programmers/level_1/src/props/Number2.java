package props;

public class Number2 {
    public static String solution(String[] param0) {
        StringBuilder answer = new StringBuilder();

        for (String str : param0) {
            String temp = "";
            switch (str) {
                case "BOOL": temp="#";break;
                case "SHORT" : temp="##"; break;
                case "FLOAT" : temp="####"; break;
                case "INT" : temp="########"; break;
                case "LONG" : temp="########,########"; break;
            }

        }
        return answer.toString();

    }
    public static void main(String[] args) {
        String[] prop = {"BOOL"};
    }
}
