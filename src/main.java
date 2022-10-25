import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        int index = 1, choice;
        boolean gameInProgress = true;
        ArrayList<Character> chars = new ArrayList<Character>();
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
            for (int rowData = 0; rowData < board.length; rowData++){
                for (int cellData = 0; cellData < board[rowData].length; cellData++){
                    System.out.print(" " + board[rowData][cellData] + " ");
                    if (cellData != board[rowData].length - 1){
                        System.out.print("║");
                    }
                }
                if (rowData != board.length - 1){
                    System.out.println("\n═══╬═══╬═══");
                }
            }

            System.out.print("\nRuch " + chars.get(currentChar));
            System.out.print("\nPodaj pole z zakresu <1, 9>: ");
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 9){
                if (board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] != 'x' && board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] != 'o'){
//                    System.out.println("Umieszczono " + chars.get(currentChar) + " na polu " + boardIndexes.get(choice));
                    board[boardIndexes.get(choice).get(0)][boardIndexes.get(choice).get(1)] = chars.get(currentChar);

                    if (currentChar == 0){
                        currentChar = 1;
                    } else currentChar = 0;

                } else{
                    System.out.println("Pole jest już zajęte!");
                }
            } else {
                System.out.println(choice + " nie należy do zakresu <1, 9>");
            }
        }
    }
}
