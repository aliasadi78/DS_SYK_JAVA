import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt((input.nextLine()));
        String[][] rule = new String[size][2];
        String[] R = new String[2];
        for (int i = 0; i < size; i++){
            String r = input.nextLine();
            R = r.split(" -> ");
            rule[i][0] = R[0];
            rule[i][1] = R[1];
        }
        String[] c = new String[0];
        int[] d = new int[rule.length];
        for (int i = 0 ; i < rule.length; i++) {
            if (rule[i][1].length() > 1) {
                c = new String[rule[i][1].length()];
                for (int j = 0; j < rule[i][1].length(); j++) {
                    c = (rule[i][1].split(""));
                }
            }
        }

        for (int i = 0; i < size; i++){
            System.out.print(c[i]);
            System.out.print(c[i]);
            System.out.println();
        }
// for (int i = 0; i < size; i++){
//            System.out.print(rule[i][0]);
//            System.out.print(rule[i][1]);
//            System.out.println();
//        }
//        if (testgrammer(rule)){
//            System.out.println("Wrong Grammar");
//        }
//        String[] c = new String[size];
//        for (int i = 0; i < rule.length; i++){
//            c[i] = String.valueOf(rule[i][1].split(""));
//        }

    }
//    public static Boolean testgrammer(String[][] rule) {
//        for (int i = 0 ; i < rule.length; i++){
//            if (rule[i][1].length() > 1){
//                char[] c = new char[rule.length];
//                for(int j = 0; i < rule.length; i++){
//                     c[j] += (rule[j][1].split("")).toString().charAt(0);
//                }
//                return false;
//            }
//        }
//
//        return true;
//    }
}
