
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int MAX = 1700;
    public static String[][] gram = new String[MAX][MAX];
    public static String[] dpr = new String[MAX];
    public static String[][] matrix = new String[MAX][MAX];
    public static String[][] matrix1 = new String[MAX][MAX];
    public static int np;
    public static String start;
    public static String rrule;
    public static String[] R = new String[2];
    public static String str;
    public static int p = 0;


    public static void main(String[] args) {
        for (int y = 0; y < MAX; y++) {
            for (int x = 0; x < MAX; x++) {
                gram[y][x] = "";
            }
        }
        for (int y = 0; y < MAX; y++) {
            dpr[y] = "";
        }
        int i;
        int j;
        int l;
        int k;
        String r;
        String pr;

        Scanner input = new Scanner(System.in);
        start = "S";
        np = Integer.parseInt(input.nextLine());
        String[][] rul = new String[np][2];
        for (i = 0; i < np; i++) {
            for (int b = 0; i < np; i++) {
                rrule = input.nextLine();
                R = rrule.split(" -> ");
                gram[i][0] = R[0];
                gram[i][1] = R[1];
                rul[i][0] = R[0];
                rul[i][1] = R[1];
            }
            for (j = 0; j < p; j++) {
                gram[i][j + 1] = dpr[j];
            }
        }
        for (int y = 0; y < MAX; y++) {
            for (int x = 0; x < MAX; x++) {
                matrix[y][x] = "";
                matrix1[y][x] = "";
            }
        }
        String st;
        str = input.nextLine();

        for (i = 0; i < str.length(); i++) {
            r = "";
            st = "";
            st += str.charAt(i);
            for (j = 0; j < np; j++) {
                k = 1;
                while ( ! gram[j][k].equals("") ) {
                    if (st.equals(gram[j][k])) {
                        r = concat(r, gram[j][0]);
                    }
                    k++;
                }
            }
            String rr = sortt(r);
            matrix[i][i] = rr;
        }
        for (k = 1; k < str.length(); k++) {
            for (j = k; j < str.length(); j++) {
                r = "";
                for (l = j - k; l < j; l++) {
                    pr = gen_comb(matrix[j - k][l], matrix[l + 1][j]);
                    r = concat(r, pr);
                }
                String rr = sortt(r);
                matrix[j - k][j] = rr;
            }
        }
        ArrayList str1 = new ArrayList(MAX);
        for (int ii = 0; ii <= str.length(); ii++) {
            for (int jj = ii; jj <= str.length(); jj++) {
                if (ii != jj) {
                    str1.add(str.substring(ii, jj));
                }
            }
        }
        int mm = 0;
        for (i = 0; i < str.length(); i++) {
            for (j = i; j < str.length(); j++) {
                matrix1[i][j] = str1.get(mm).toString();
                mm++;
            }
        }Boolean I = false;
        if (! testgrammer(rul)) {
            System.out.println("Wrong Grammar");
        }
        else{
            ArrayList T = new ArrayList();
            String[] t = new String[(matrix[0][str.length() - 1]).length()];
            t = (matrix[0][str.length() - 1]).split("");
            for (i = 0; i < t.length; i++){
                T.add(t[i]);
            }
            if (T.size() > 0){
                for (i = 0; i < T.size(); i++){
                    if (T.get(i).equals("S")) {
                        System.out.println("YES");
                        int mn;
                        I = true;
                        for (i = 0; i < str.length(); i++) {
                            mn = 0;
                            for (j = i; j < str.length(); j++) {
                                System.out.print(matrix1[mn][j]);
                                System.out.print(" : ");
                                System.out.print(matrix[mn++][j].replace(" ", ""));
                                if (j != str.length() - 1) {
                                    System.out.print(" , ");
                                }
                            }
                            System.out.println();
                        }
                        break;
                    }
                }
            }
        }
        if(!I){
            System.out.println("NO");
        }
    }
    public static Boolean testgrammer(String[][] rulee) {
        String[] c;
        Boolean T = true;
        for (int i = 0; i < np; i++) {
            c = new String[rulee[i][1].length()];
            for (int j = 0; j < np; j++) {
                c = (rulee[j][1].split(""));
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
                    }
                    else if ((int) (c[k]).charAt(0) > 96 && (int) (c[k]).charAt(0) < 123) {
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
    private static String gen_comb(String a, String b)
    {
        int i;
        int j;
        String pri = a;
        String re = "";
        for (i = 0; i < a.length(); i++)
        {
            for (j = 0; j < b.length(); j++)
            {
                pri = "";
                pri = pri + a.charAt(i) + b.charAt(j);
                re = re + search_prod(pri);
            }
        }
        return re;
    }
    private static String search_prod(String p)
    {
        int j;
        int k;
        String r = "";
        for (j = 0; j < np; j++)
        {
            k = 1;
            while (!gram[j][k].equals(""))
            {
                if ((gram[j][k]).equals(p))
                {
                    r = concat(r, gram[j][0]);
                }
                k++;
            }
        }
        return r;
    }
    private static String concat(String a, String b)
    {
        int i;
        String r = a;
        for (i = 0; i < b.length(); i++)
        {
            if (r.indexOf(b.charAt(i)) < r.length()) {
                r += b.charAt(i);
            }
        }
        return (r);
    }
    public static String sortt(String r){
        ArrayList S = new ArrayList();
        ArrayList E = new ArrayList();
        for (int i =0;i<r.length();i++){
            S.add(r.charAt(i));
        }
        for (int i =0;i<S.size();i++){
            for (int j =0;j<S.size();j++) {
                try {
                    if (str.length() < 100) {
                        if (S.get(i) == S.get(j) && i != j) {
                            S.remove(j);
                        }
                    }
                    else{
                        if (S.get(i) == S.get(j)) {
                            S.remove(j);
                        }
                    }
                }
                catch (Exception IndexOutOfBoundsException){
                    throw new IndexOutOfBoundsException();
                }
            }
        }
        String[] W = new String[S.size()];
        for (int i =0;i<S.size();i++){
            W[i] = S.get(i).toString();
        }
        Arrays.sort(W);
        for (int i =0;i<S.size();i++){
            E.add(W[i]);
        }
        String R = E.toString();
        R.replace(" ","");
        return R;
    }
}