import java.util.*;

public class TicTacToe {
    static int changeTurn(int currentChar) {
        if (currentChar == 0) return 1;
        if (currentChar == 1) return 0;
        return currentChar;
    }

    static void printBoard(char[][] board){
        for (int rowData = 0; rowData < board.length; rowData++){
            for (int cellData = 0; cellData < board[rowData].length; cellData++){
                System.out.print(" " + board[rowData][cellData] + " ");
                if (cellData != board[rowData].length - 1){
                    System.out.print("|");
                }
            }
            if (rowData != board.length - 1){
                System.out.println("\n---+---+---");
            }
        }
    }

    static boolean checkWinner(char[][] board) {
        String boardStr = "";
        for (char[] value : board) {
            for (char c : value) {
                boardStr += c;
            }
        }
        if (!(boardStr.contains("1") || boardStr.contains("2") || boardStr.contains("3") || boardStr.contains("4") || boardStr.contains("5") || boardStr.contains("6") || boardStr.contains("7") || boardStr.contains("8") || boardStr.contains("9"))){
            System.out.println("Remis!");
            return false;
        }

        String rowStr = "";
        for (char[] chars : board) {
            for (char aChar : chars) {
                rowStr += aChar;
            }
            if (rowStr.equals("xxx")){
                System.out.println("Krzyzyk wygrywa!");
                return false;
            } else if (rowStr.equals("ooo")){
                System.out.println("Kolko wygrywa!");
                return false;
            }
            rowStr = "";
        }
        for(int i = 0; i < board[0].length; i++){
            for (char[] chars : board) {
                rowStr += chars[i];
            }
            if (rowStr.equals("xxx")){
                System.out.println("Krzyzyk wygrywa!");
                return false;
            } else if (rowStr.equals("ooo")){
                System.out.println("Kolko wygrywa!");
                return false;
            }
        }
        rowStr = "";
        for(int i = 0; i < board.length; i++){
            rowStr += board[i][i];
        }
        if (rowStr.equals("xxx")){
            System.out.println("Krzyzyk wygrywa!");
            return false;
        } else if (rowStr.equals("ooo")){
            System.out.println("Kolko wygrywa!");
            return false;
        }
        rowStr = "";
        for(int i = 0; i < board.length; i++){
            rowStr += board[i][(board.length - 1) - i];
        }
        if (rowStr.equals("xxx")){
            System.out.println("Krzyzyk wygrywa!");
            return false;
        } else if (rowStr.equals("ooo")){
            System.out.println("Kolko wygrywa!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        int index = 1, choice;
        boolean gameInProgress = true;
        ArrayList<Character> chars = new ArrayList<>();
        chars.add('x');
        chars.add('o');
        int currentChar = 0; // 0=x || 1=y

        HashMap<Integer, ArrayList<Integer>> boardIndexes = new HashMap<>();

        for (int rowData = 0; rowData < board.length; rowData++){
            for (int cellData = 0; cellData < board[rowData].length; cellData++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(rowData);
                list.add(cellData);

                boardIndexes.put(index, list);

                board[rowData][cellData] = (char)(index + '0');
                index++;
            }
        }

        while (gameInProgress){
            printBoard(board);

            System.out.print("\nRuch " + chars.get(currentChar));
            System.out.print("\nPodaj pole z zakresu <1, 9>: ");
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 9){
                if (board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] != 'x' && board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] != 'o'){
                    board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] = chars.get(currentChar);

                    currentChar = changeTurn(currentChar);

                    gameInProgress = checkWinner(board);
                } else{
                    currentChar = changeTurn(currentChar);

                    System.out.println("To pole jest juz zajete! Tracisz kolejke");
                }
            } else {
                System.out.println(choice + " nie należy do zakresu <1, 9>");
            }
        }
    }
}
