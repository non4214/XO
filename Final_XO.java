import java.util.*;

public class Final_XO {       
    static String[] board = {"0","1","2","3","4","5","6","7","8"} ; 
    static int turn = 0 ;
    static int pos;
    static String ox = "X"; 
    static int gamerun = 0;
    public static void main(String[] args) {            
        while(turn<9 && gamerun==0) {                       //ให้วน 9 รอบ 
            showBoard();
            System.out.println(ox + " ใส่ตำแหน่ง");
            Scanner input = new Scanner(System.in);    // รับค่า
            
            //เช็คการใส่ตำแหน่งที่ผิดพลาด
            try { 
                pos = input.nextInt();                  
                if (!(pos >= 0 && pos <= 8)) {     
                    System.out.println(
                        "การใส่ตำแหน่งผิดจ้า ");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("การใส่ตำแหน่งผิดจ้า");
                break;
            }
            //เช็คการใส่ซ้ำ
            if(board[pos] == "X" || board[pos] == "O") {  //ถ้าเคยใส่ตำแหน่งๆนี้ไปแล้ว 
                System.out.println("มีคนจองแน้วน้า");    //ใส่ซ้ำอีกครั้ง
                break;
                //pos = input.nextInt();
            }
            //สลับตา
            else {
                board[pos] = ox;
                turn++ ;
                //System.out.println(Arrays.toString(board));
                checkwinner();
                if (ox == "X") {
                    ox = "O";
                }
                else {
                    ox = "X";      
                }
            }
        }
        //เช็คการเสมอ
        if(gamerun == 0) {
            System.out.println("เสมอจ้า");
        }
        System.out.println("จบเกมแน้วน้าาา");
    }
    //แสดงบอร์ด
    static void showBoard()
	{
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "+ board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | "+ board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | "+ board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}
    //การเช็คผู้ชนะ
    static void checkwinner()
    
    {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                System.out.println("X ชนะ !!!");
                gamerun = 1;
            }

            else if (line.equals("OOO")) {
                System.out.println("O ชนะ !!!");
                gamerun = 1;
            }
        }
    }
}
