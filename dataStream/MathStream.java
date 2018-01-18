package dataStream;

public class MathStream {

	private String probArray[] = new String[5];
	private int answerArray[] = new int[5];
	
	public void initializeArrays() {
		probArray[0] = "8 + (-12) = ?";
		probArray[1] = "6 + (-4) = ?";
		probArray[2] = "8 + (-7) = ?";
		probArray[3] = "24 / 3 = ?";
		probArray[4] = "4 * (-4) = ?";

		answerArray[0] = -4;
		answerArray[1] = 2;
		answerArray[2] = 1;
		answerArray[3] = 8;
		answerArray[4] = -16;
		
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