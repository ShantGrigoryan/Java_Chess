import java.util.*;
import Chess.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Chess ask cordinate
        int x;
        int y;
        while (true) {
            System.out.print("Enter cordinate x (1-8) -> ");
            y = scanner.nextInt();
            if (y > 8) {
                continue;
            } else {
                y = y - 1;
                break;
            }
        }
        while (true){
            System.out.print("Enter cordinate y (1-8) -> ");
            x = scanner.nextInt();
            if (x > 8){
                continue;
            }
            else {
                x = x - 1;
                break;
            }
        }
        //Chess ask cordinate end

        String[][] arr = Chess.board(x,y);

        //Print board
        for(String[] str1 : arr){
            for(String str : str1){
                System.out.print(str);
            }
            System.out.println();
        }
        //Print end
    }
}