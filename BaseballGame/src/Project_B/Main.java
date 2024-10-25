package Project_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기" + " 2. 게임 기록 보기" + " 3. 종료하기");
            int inputValue = sc.nextInt();  // 입력값 생성
            switch (inputValue) {           // 입력값에 조건 부여
                case 1:
                    System.out.println("게임을 시작합니다.");
                    BG game = new BG();
                    game.startGame(sc);
                    break;
                case 2:
                    System.out.println("게임 기록을 보여줍니다.");
                    break;
                case 3:
                    System.out.println("게임을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");  // 다른 숫자나 문자를 입력 시 입력을 다시 진행하도록 함.
            }
        }
    }
}
