package dataStream;

public class MathStream {

	private String probArray[] = new String[15];
	private int answerArray[] = new int[15];
	
	public void initializeArrays() {
		probArray[0] = "8 + (-12) = ?";
		probArray[1] = "6 + (-4) = ?";
		probArray[2] = "8 + (-7) = ?";
		probArray[3] = "24 / 3 = ?";
		probArray[4] = "4 * (-4) = ?";
		probArray[5] = "16 + 13 =?";
		probArray[6] = "10 * 5 = ?";
		probArray[7] = "19 - 16 = ?";
		probArray[8] = "13 * 9 = ?";
		probArray[9] = "17 * 6 = ?";
		probArray[10] = "14 + 10 = ?";
		probArray[11] = "11 + 10 = ?";
		probArray[12] = "16 + 14 = ?";
		probArray[13] = "18 * 1 = ?";
		probArray[14] = "14 - 13 = ?";
		
		answerArray[0] = -4;
		answerArray[1] = 2;
		answerArray[2] = 1;
		answerArray[3] = 8;
		answerArray[4] = -16;
		answerArray[5] = 29;
		answerArray[6] = 50;
		answerArray[7] = 3;
		answerArray[8] = 117;
		answerArray[9] = 102;
		answerArray[10] = 24;
		answerArray[11] = 21;
		answerArray[12] = 30;
		answerArray[13] = 18;
		answerArray[14] = 1;
		
		}

	public String getProb(int num) {
		if (num < probArray.length && num >= 0) {
			return probArray[num];
		}
		return "";
	}

	public boolean checkAnswer(int num, int answer) {
		if (answerArray[num] == answer) {
			return true;
		}
		return false;
	}

}