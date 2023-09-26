package APS;

import java.util.Scanner;

public class 특이한자석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int answer = 0;
			int k = sc.nextInt();
			int[][] rotate = new int[k][2];
			int[][] magnet = new int[5][8];
			for(int m = 1; m < 5; m++) {
				for(int i = 0; i < 8; i++) {
					magnet[m][i] = sc.nextInt();
				}
			}
			for(int r = 0; r < k; r++) {
				rotate[r][0] = sc.nextInt();
				rotate[r][1] = sc.nextInt();
			}
			//1-4 자석 포인트들 1 : N, W / 2 : N, E, W / 3 : N, E, W / 4 : N, W
			int[][] magnetPoint = {{}, {0, 2}, {0, 2, 6}, {0, 2, 6}, {0, 6}};
			
			for(int r = 0; r < k; r++) {
				if(rotate[r][1] == 1) {
					if(rotate[r][0] == 1) {
						int first = magnet[1][magnetPoint[1][1]]; //magnet1 E
						for(int i = 0; i < 2; i++) {
							magnetPoint[1][i]--;
							if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
						}
						if(first != magnet[2][magnetPoint[2][2]]) {
							int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]++;
								if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
							}
							if(second != magnet[3][magnetPoint[3][2]]) {
								int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
								for(int i = 0; i < 3; i++) {
									magnetPoint[3][i]--;
									if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
								}
								if(third != magnet[4][magnetPoint[4][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[4][i]++;
										if(magnetPoint[4][i]> 7) magnetPoint[4][i] = 0;
									}
								}
							}
						}
					} else if(rotate[r][0] == 2) {
						int first = magnet[2][magnetPoint[2][2]]; //magnet2 W
						int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
						for(int i = 0; i < 3; i++) {
							magnetPoint[2][i]--;
							if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
						}
						if(first != magnet[1][magnetPoint[1][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[1][i]++;
								if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
							}
						}
						if(second != magnet[3][magnetPoint[3][2]]) {
							int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]++;
								if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
							}
							if(third != magnet[4][magnetPoint[4][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[4][i]--;
									if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
								}
							}
						}
					} else if(rotate[r][0] == 3) {
						int first = magnet[3][magnetPoint[3][1]]; //magnet3 E
						int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
						for(int i = 0; i < 3; i++) {
							magnetPoint[3][i]--;
							if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
						}
						if(first != magnet[4][magnetPoint[4][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[4][i]++;
								if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
							}
						}
						if(second != magnet[2][magnetPoint[2][1]]) {
							int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]++;
								if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
							}
							if(third != magnet[1][magnetPoint[1][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[1][i]--;
									if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
								}
							}
						}
					} else {
						int first = magnet[4][magnetPoint[4][1]]; //magnet4 W
						for(int i = 0; i < 2; i++) {
							magnetPoint[4][i]--;
							if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
						}
						if(first != magnet[3][magnetPoint[3][1]]) {
							int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]++;
								if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
							}
							if(second != magnet[2][magnetPoint[2][1]]) {
								int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
								for(int i = 0; i < 3; i++) {
									magnetPoint[2][i]--;
									if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
								}
								if(third != magnet[1][magnetPoint[1][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[1][i]++;
										if(magnetPoint[1][i]> 7) magnetPoint[1][i] = 0;
									}
								}
							}
						}
					}
				} else { //시계 반대방향
					if(rotate[r][0] == 1) {
						int first = magnet[1][magnetPoint[1][1]]; //magnet1 E
						for(int i = 0; i < 2; i++) {
							magnetPoint[1][i]++;
							if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
						}
						if(first != magnet[2][magnetPoint[2][2]]) {
							int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]--;
								if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
							}
							if(second != magnet[3][magnetPoint[3][2]]) {
								int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
								for(int i = 0; i < 3; i++) {
									magnetPoint[3][i]++;
									if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
								}
								if(third != magnet[4][magnetPoint[4][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[4][i]--;
										if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
									}
								}
							}
						}
					} else if(rotate[r][0] == 2) {
						int first = magnet[2][magnetPoint[2][2]]; //magnet2 W
						int second = magnet[2][magnetPoint[2][1]]; //magnet2 E
						for(int i = 0; i < 3; i++) {
							magnetPoint[2][i]++;
							if(magnetPoint[2][i] > 7) magnetPoint[2][i] = 0;
						}
						if(first != magnet[1][magnetPoint[1][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[1][i]--;
								if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
							}
						}
						if(second != magnet[3][magnetPoint[3][2]]) {
							int third = magnet[3][magnetPoint[3][1]]; //magnet3 E
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]--;
								if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
							}
							if(third != magnet[4][magnetPoint[4][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[4][i]++;
									if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
								}
							}
						}
					} else if(rotate[r][0] == 3) {
						int first = magnet[3][magnetPoint[3][1]]; //magnet3 E
						int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
						for(int i = 0; i < 3; i++) {
							magnetPoint[3][i]++;
							if(magnetPoint[3][i] > 7) magnetPoint[3][i] = 0;
						}
						if(first != magnet[4][magnetPoint[4][1]]) {
							for(int i = 0; i < 2; i++) {
								magnetPoint[4][i]--;
								if(magnetPoint[4][i] < 0) magnetPoint[4][i] = 7;
							}
						}
						if(second != magnet[2][magnetPoint[2][1]]) {
							int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[2][i]--;
								if(magnetPoint[2][i] < 0) magnetPoint[2][i] = 7;
							}
							if(third != magnet[1][magnetPoint[1][1]]) {
								for(int i = 0; i < 2; i++) {
									magnetPoint[1][i]++;
									if(magnetPoint[1][i] > 7) magnetPoint[1][i] = 0;
								}
							}
						}
					} else {
						int first = magnet[4][magnetPoint[4][1]]; //magnet4 W
						for(int i = 0; i < 2; i++) {
							magnetPoint[4][i]++;
							if(magnetPoint[4][i] > 7) magnetPoint[4][i] = 0;
						}
						if(first != magnet[3][magnetPoint[3][1]]) {
							int second = magnet[3][magnetPoint[3][2]]; //magnet3 W
							for(int i = 0; i < 3; i++) {
								magnetPoint[3][i]--;
								if(magnetPoint[3][i] < 0) magnetPoint[3][i] = 7;
							}
							if(second != magnet[2][magnetPoint[2][1]]) {
								int third = magnet[2][magnetPoint[2][2]]; //magnet2 W
								for(int i = 0; i < 3; i++) {
									magnetPoint[2][i]++;
									if(magnetPoint[2][i]> 7) magnetPoint[2][i] = 0;
								}
								if(third != magnet[1][magnetPoint[1][1]]) {
									for(int i = 0; i < 2; i++) {
										magnetPoint[1][i]--;
										if(magnetPoint[1][i] < 0) magnetPoint[1][i] = 7;
									}
								}
							}
						}
					}
				}
			}
			//여기까지 회전
			//값 출력하기
			for(int i = 1; i < 5; i++) {
				if(magnet[i][magnetPoint[i][0]] == 1) {
					if(i == 1) answer += 1;
					if(i == 2) answer += 2;
					if(i == 3) answer += 4;
					if(i == 4) answer += 8;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
