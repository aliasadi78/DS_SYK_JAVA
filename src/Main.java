import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt((input.nextLine()));
        String[][] rule = new String[size][2];
        String[] R;
        for (int i = 0; i < size; i++){
            String r = input.nextLine();
            R = r.split(" -> ");
            rule[i][0] = R[0];
            rule[i][1] = R[1];
        }
        String vor = input.nextLine();
        if (!testgrammer(rule)){
            System.out.println("Wrong Grammar");
        }
    }
    public static Boolean testgrammer(String[][] rule) {
        String[] c;
        for (int i = 0; i < rule.length; i++) {
            c = new String[rule[i][1].length()];
            for (int j = 0; j < rule[i][1].length(); j++) {
                c = (rule[j][1].split(""));
                for (int k = 0; k < c.length; k++) {
                    if ((int) (c[k]).charAt(0) > 64 && (int) (c[k]).charAt(0) < 91) {
                        if (c.length < 3) {
                            return true;
                        }
                        else {
                            return false;
                        }
                    } else if ((int) (c[k]).charAt(0) > 96 && (int) (c[k]).charAt(0) < 123) {
                        if (c.length < 2) {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
