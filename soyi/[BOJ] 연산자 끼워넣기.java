package 연산자끼워넣기;

import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] nums;
    public static int[] operator;
    public static int[] opTurns;
    public static int min;
    public static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        N = scanner.nextInt(); // 수의 개수
        nums = new int[N]; // 수
        for(int i = 0; i < N; i++){
            nums[i] = scanner.nextInt();
        }
        operator = new int[4]; // 연산자
        for(int i = 0; i < 4; i++){ // 0덧셈, 1뺄셈, 2곱셈, 3나눗셈
            operator[i] = scanner.nextInt();
        }
        // 계산
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        opTurns = new int[operator[0] + operator[1] + operator[2] + operator[3]];
        makeTurn(0);
        // 출력
        System.out.println(max + "\n" + min);
        scanner.close();
    }

    public static void makeTurn(int lev){
        if(lev == N-1){ // 계산 하기
            calculate();
            return;
        }
        for(int i = 0; i < 4; i++){ // 연산자 순서 정하기
            if(operator[i] == 0) continue;
            opTurns[lev] = i;
            operator[i]--;
            makeTurn(lev+1);
            operator[i]++;
        }
    }

    public static void calculate(){
        int num = nums[0];
        for(int i = 0; i < N-1; i++){
            switch (opTurns[i]){
                case 0: // 덧셈
                    num += nums[i+1];
                    break;
                case 1: // 뺄셈
                    num -= nums[i+1];
                    break;
                case 2: // 곱셈
                    num *= nums[i+1];
                    break;
                case 3: // 나눗셈
                    num /= nums[i+1];
                    break;
            }
        }
        min = Integer.min(min, num);
        max = Integer.max(max, num);
    }
}
