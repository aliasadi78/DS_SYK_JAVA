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
        for (int i = 0; i < size; i++){
            System.out.print(rule[i][0]);
            System.out.print(rule[i][1]);
        }
    }
}
