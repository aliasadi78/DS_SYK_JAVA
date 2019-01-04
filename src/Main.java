import java.util.ArrayList;
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
        String vor = input.nextLine().toUpperCase();
        ArrayList v = new ArrayList(vor.length());
        String[] v1 = new String[vor.length()];
        v1 = vor.split("");
        for (int i = 0; i < vor.length(); i++){
            v.add(i,v1[i]);
        }
        if (!testgrammer(rule)){
            System.out.println("Wrong Grammar");
        }
        else {
            System.out.println("NO");
        }
//        else (cyk(rule,v)){
//            System.out.println("NO");
//        }
    }

    public static Boolean cyk(String[][] rule,ArrayList v){
        Boolean T = true;
        String[][] str = new String[rule.length][2];
        String[] s = new String[rule.length];

        for (int i = 0; i < v.size(); i++){
            s = rule[i][1].toUpperCase().split("");
            for (int j = 0; j < rule.length; j++){
                if (v.get(i).equals(s[0])){
                    str[i][0] = rule[i][0];
                    System.out.println(str[i][i]);
                }

            }


        }
        return true;
    }

    public static Boolean testgrammer(String[][] rule) {
        String[] c;
        Boolean T = true;
        for (int i = 0; i < rule.length; i++) {
            c = new String[rule[i][1].length()];
            for (int j = 0; j < rule.length; j++) {
                c = (rule[j][1].split(""));
                for (int k = 0; k < c.length; k++) {

                    if ((int) (c[k]).charAt(0) > 64 && (int) (c[k]).charAt(0) < 91) {
                        if (T == false){
                            return false;
                        }
                        if (c.length < 3) {
                            T = true;
                        }
                        else {
                            T = false;
                        }
                    } else if ((int) (c[k]).charAt(0) > 96 && (int) (c[k]).charAt(0) < 123) {
                        if (T == false){
                            return false;
                        }
                        if (c.length < 2) {
                            T = true;
                        }
                        else {
                            T = false;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return T;
    }
}
//import java.util.ArrayList;
//
//public class Main{
//    public static void main(String[] args){
//        String str = "aabbb";
//        int n = str.length() * (str.length() + 1 ) / 2;
//        ArrayList str1 = new ArrayList(n);
//        for (int i = 0; i <= str.length(); i++){
//            for (int j = i; j <= str.length(); j++){
//                if (i!=j) {
//                    str1.add(str.substring(i, j));
//
//
//                }
//            }
//        }
//        System.out.println(str1);
//        ArrayList Str = new ArrayList(n);
//        for (int i = 1; i <= str.length(); i++) {
//            int j = 0;
//            for (j = 0; j < n; j++) {
//                if (str1.get(j).toString().length() == i){
//                    Str.add(str1.get(j));
//                }
//            }
//        }
//        System.out.println(Str);
//    }
//}
