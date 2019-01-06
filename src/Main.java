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
            rule[i][0] = R[0].toUpperCase();
            rule[i][1] = R[1].toUpperCase();
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
//        if (cyk(rule,Arr(vor))){
//            System.out.println("NO");
//        }
    }

    public static ArrayList Arr(String vor){
        int n = vor.length() * (vor.length() + 1 ) / 2;
        ArrayList str1 = new ArrayList(n);
        for (int i = 0; i <= vor.length(); i++){
            for (int j = i; j <= vor.length(); j++){
                if (i!=j) {
                    str1.add(vor.substring(i, j));
                }
            }
        }
        System.out.println(str1);
        ArrayList Str = new ArrayList(n);
        for (int i = 1; i <= vor.length(); i++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (str1.get(j).toString().length() == i){
                    Str.add(str1.get(j));
                }
            }
        }
        System.out.println(Str);
        return Str;
    }
    public static Boolean cyk(String[][] rule,String v){
        Boolean T = true;
        String[][] str = new String[rule.length][2];
        String[] s = new String[rule.length];

//
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
//for (int i = 0; i < v.size(); i++){
//            s = rule[i][1].toUpperCase().split("");
//            for (int j = 0; j < rule.length; j++){
//                if (v.get(i).equals(s[0])){
//                    str[i][0] = rule[i][0];
//                    System.out.println(str[i][i]);
//                }
//
//            }
//
//
//        }
//
//import java.util.Scanner;
//public class Main {
//    public static final int MAX = 100;
//    public static String[][] gram = new String[MAX][MAX]; //to store entered grammar
//    public static String[] dpr = new String[MAX];
//    public static int p = 0; //np-> number of productions
//    public static int np;
//
//    final class DefineConstants
//    {
//        public static final int MAX = 100;
//    }
//    public static void main(String[] args) {
//        for (int y = 0; y < MAX; y++){
//            for (int x = 0; x < MAX; x++){
//                gram[y][x] = "";
//            }
//
//        }
//        for (int y = 0; y < MAX; y++){
//            dpr[y] = "";
//        }
//        int i;
//        int pt;
//        int j;
//        int l;
//        int k;
//        String a;
//        String str;
//        String r;
//        String pr;
//        String start;
//        final int MAX = 100;
////        String[][] gram = new String[DefineConstants.MAX][DefineConstants.MAX]; //to store entered grammar
////        String[] dpr = new String[DefineConstants.MAX];
////        int p = 0; //np-> number of productions
////        int np;
//        Scanner input = new Scanner(System.in);
////        System.out.println("Enter the start Variable ");
//        start = "S";
//        System.out.println("Number of productions ");
//        int np = Integer.parseInt(input.nextLine());
//        System.out.println("Enter the Rule ");
//        for (i = 0; i < np; i++)
//        {
//
//            a = input.nextLine();
//            pt = a.indexOf("->");
//            gram[i][0] = a.substring(0, pt);
//            if (lchomsky(gram[i][0]) == 0)
//            {
//                System.out.print("\nGrammar not in Chomsky Form");
////                abort();
//            }
//            a = a.substring(pt + 2,a.length());
//            break_gram(a);
//            for (j = 0; j < p; j++)
//            {
//                gram[i][j + 1] = dpr[j];
////                if (rchomsky(dpr[j]) == 0)
////                {
////                    System.out.print("\nGrammar not in Chomsky Form");
//////                    abort();
////                }
//            }
//        }
//        String[][] matrix = new String[MAX][MAX];
//        for (int y = 0; y < MAX; y++){
//            for (int x = 0; x < MAX; x++){
//                matrix[y][x] = "";
//            }
//
//        }
//        String st;
//        System.out.print("\nEnter string to be checked : ");
//        str = input.nextLine();
//        for (i = 0; i < str.length(); i++) //Assigns values to principal diagonal of matrix
//        {
//            r = "";
//            st = "";
//            st += str.charAt(i);
//            for (j = 0; j < np; j++)
//            {
//                k = 1;
//                while (!gram[j][k].equals(""))
//                {
//                    if (st.equals(gram[j][k]))
//                    {
//                        r = concat(r, gram[j][0]);
//                    }
//                    k++;
//                }
//            }
//            matrix[i][i] = r;
//        }
//        int ii;
//        int kk;
//        for (k = 1; k < str.length(); k++) //Assigns values to upper half of the matrix
//        {
//            for (j = k; j < str.length(); j++)
//            {
//                r = "";
//                for (l = j - k; l< j;l++)
//                {
//                    pr = gen_comb(matrix[j - k][l], matrix[l + 1][j]);
//                    r = concat(r, pr);
//                }
//                matrix[j - k][j] = r;
//            }
//        }
//
//        for (i = 0; i < str.length(); i++) //Prints the matrix
//        {
//            k = 0;
//            l = str.length() - i - 1;
//            for (j = 1; j < str.length(); j++)
//            {
//                System.out.print(matrix[k++][j]);
//                System.out.print(" ");
//            }
//            System.out.print("\n");
//        }
//
//        int f = 0;
//        for (i=0; i< start.length();i++)
//        {
//            if (matrix[0][str.length() - 1].indexOf(start.charAt(i)) <= matrix[0][str.length() - 1].length()) //Checks if last element of first row contains a Start variable
//            {
//                System.out.print("String can be generated\n");
////                return 0;
//            }
//        }
//        System.out.print("String cannot be generated\n");
////        return 0;
//    }
//
//    private static String gen_comb(String a, String b)
//    {
//        int i;
//        int j;
//        String pri = a;
//        String re = "";
//        for (i = 0; i < a.length(); i++)
//        {
//            for (j = 0; j < b.length(); j++)
//            {
//                pri = "";
//                pri = pri + a.charAt(i) + b.charAt(j);
//                re = re + search_prod(pri); //searches if the generated productions can be created or not
//            }
//        }
//        return re;
//    }
//    private static String search_prod(String p) //returns a concatenated string of variables which can produce string p
//    {
//        int j;
//        int k;
//        String r = "";
//        for (j = 0; j < np; j++)
//        {
//            k = 1;
//            while (!gram[j][k].equals(""))
//            {
//                if (p.equals(gram[j][k]))
//                {
//                    r = concat(r, gram[j][0]);
//                }
//                k++;
//            }
//        }
//        return r;
//    }
//
//    private static int rchomsky(String a) //checks if RHS of grammar is in CNF
//    {
//        if (a.length() == 1 && a.charAt(0) >= 'a' && a.charAt(0) <= 'z')
//        {
//            return 1;
//        }
//        if (a.length() == 2 && a.charAt(0) >= 'A' && a.charAt(0) <= 'Z' && a.charAt(1) >= 'A' && a.charAt(1) <= 'Z')
//        {
//            return 1;
//        }
//        return 0;
//    }
//
//    public static void break_gram(String a) //seperates right hand side of entered grammar
//    {
//        int i;
////        int p;
//        p = 0;
////        String[] dpr = new String[DefineConstants.MAX];
//        while ( a.length() > 0 ){
//            dpr[p++] = a;
//            a = "";
//        }
//
////        dpr[p++] = a.substring(0, a.length());
////        while (a.length()>0)
////        {
////            i = a.indexOf("|");
////            if (i > a.length())
////            {
////                dpr[p++] = a;
////                a = "";
////            }
////            else
////            {
////                dpr[p++] = a.substring(0, i);
////                a = a.substring(i + 1,a.length());
////            }
////        }
//    }
//
//    private static int lchomsky(String a) //checks if LHS of entered grammar is in CNF
//    {
//        if (a.length() == 1 && a.charAt(0) >= 'A' && a.charAt(0) <= 'Z')
//        {
//            return 1;
//        }
//        return 0;
//    }
//
//    private static String concat(String a, String b) //concatenates unique non-terminals
//    {
//        int i;
//        String r = a;
//        for (i = 0; i < b.length(); i++)
//        {
//            r += b.charAt(i);
////            String q = String.valueOf(b.charAt(i));
////            if (r.indexOf(b.charAt(i)) > r.length())
////            {
////                r += b.charAt(i);
////            }
//        }
//        return (r);
//    }
//
//}