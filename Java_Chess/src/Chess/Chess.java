package Chess;

public class Chess {
    public static String[][] board(int x , int y){
        String[][] bord = new String[8][8];
        for(int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if(i % 2 == 0 ){
                    if(j  % 2 == 0) {
                        bord[i][j] = "⬜";
                    }
                    else{
                        bord[i][j] = "⬛";
                    }
                }
                else{
                    if(j % 2 == 0){
                        bord[i][j] = "⬛";
                    }
                    else {
                        bord[i][j] = "⬜";
                    }
                }
            }
        }

        return queen(bord , x , y);
    }
    public static String[][] queen(String[][] matrix , int cordinate_x , int cordinate_y){

        matrix[cordinate_x][cordinate_y] = "♟️";
        for(String[] str1 : matrix){
            for(String str : str1){
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println();
        return damage(matrix , cordinate_x , cordinate_y);
    }
    public static String[][] damage(String[][] matrix , int x , int y){
        final int bufer_x = x;
        final int bufer_y = y;
        while(true){
            for(int i = 0 ; i < matrix[y].length ; i++){
                if(matrix[i][y] == "♟️"){
                    continue;
                }
                else{
                    matrix[i][y] = "\uD83D\uDFE5";
                }
            }
            for(int i = 0 ; i < matrix.length ; i++){
                if(matrix[x][i] == "♟️"){
                    continue;
                }
                else{
                    matrix[x][i] = "\uD83D\uDFE5";
                }
            }
            x = bufer_x;
            y = bufer_y;

            while(true){
                x++;
                y++;
                if(x == 8 || y == 8 ){
                    break;
                }else {

                    matrix[x][y] = "🟥";
                }
            }
            x = bufer_x;
            y = bufer_y;
            while (true){
                x--;
                y--;
                if (x <= -1 || y <= -1) {
                    break;
                }
                else {
                    matrix[x][y] = "🟥";
                }
            }
            x = bufer_x;
            y = bufer_y;
            while(true){
                x++;
                y--;
                if (x >= 8 || y <= -1) {
                    break;
                }
                else {
                    matrix[x][y] = "🟥";
                }
            }
            x = bufer_x;
            y = bufer_y;
            while(true){
                x--;
                y++;
                if (x <= -1 || y >= 8) {
                    break;
                }
                else{
                    matrix[x][y] = "🟥";
                }
            }
            break;
        }
        return counter(matrix);
    }
    public static String[][] counter(String[][] matrix){
        int x = 0;
        int y = 0;
        int count = 0;
        for(int i = 0;  i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                if(matrix[i][j] == "♟️"){
                    count++;
                    x = i;
                    y = j;
                }
            }
        }
        return auto(matrix , count , x , y);
    }
    public static String[][] auto (String [][] matrix , int count , int x , int y){
        if(count == 8){
            return matrix;
        }
        else{
            for(int i = 0;  i < matrix.length ; i++){
                for(int j = y ; j < matrix[i].length ; j++){
                    if(matrix[i][j] == "🟥" || matrix[i][j] == "♟️"){
                        continue;
                    }
                    else {
                        queen(matrix , i , j);
                    }
                }
            }
            return matrix;
        }
    }
}
