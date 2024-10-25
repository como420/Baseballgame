package Project_B;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

public class BG {
    public void startGame(Scanner scanner) {
        int[] computerNumbers = generateRandomNumbers();
        System.out.println("숫자를 입력하세요 : ");

        boolean isCorrect = false;
        int attempts = 0;

        while (!isCorrect) {
            String userInput = scanner.nextLine();

            // 입력 검증
            if (userInput.length() != 3 || !isValidInput(userInput)) {
                System.out.println("잘못된 입력입니다. 중복되지 않는 3자리 숫자를 입력하세요.");
                continue;
            }

            int[] userNumbers = convertToIntArray(userInput);
            int[] result = checkNumbers(computerNumbers, userNumbers);

            int strikes = result[0];
            int balls = result[1];
            attempts++;

            System.out.println(strikes + " 스트라이크, " + balls + " 볼");

            if (strikes == 3) {
                isCorrect = true;
                System.out.println("축하합니다! " + attempts + "번 만에 숫자를 맞추셨습니다!");
            }
        }
        scanner.close();
    }

    // 중복되지 않는 3자리 숫자를 생성하는 메소드
    private static int[] generateRandomNumbers() {
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();
        int[] numbers = new int[3];
        int index = 0;

        while (numberSet.size() < 3) {
            int num = random.nextInt(9) + 1;  // 1부터 9까지의 숫자
            if (!numberSet.contains(num)) {
                numberSet.add(num);
                numbers[index++] = num;
            }
        }
        return numbers;
    }

    // 사용자 입력을 숫자 배열로 변환하는 메소드
    private static int[] convertToIntArray(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    // 숫자가 중복되지 않는지 확인하는 메소드
    private static boolean isValidInput(String input) {
        Set<Character> digitSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (digitSet.contains(c)) {
                return false;  // 중복된 숫자
            }
            digitSet.add(c);
        }
        return true;
    }

    // 컴퓨터 숫자와 사용자 숫자를 비교하는 메소드
    private static int[] checkNumbers(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                balls++;
            }
        }

        return new int[] {strikes, balls};
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메소드
    private static boolean contains(int[] array, int number) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }
}