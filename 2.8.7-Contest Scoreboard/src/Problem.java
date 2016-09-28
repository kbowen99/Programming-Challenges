
public class Problem {
	int problemNum;
	int problemTime;
	char Lstate;
	
	/**
	 * Generates a new Problem
	 * @param problem - Number of the problem
	 * @param ProblemTime - Amount of time it took
	 */
	public Problem(int problem, int ProblemTime, char L){
		this.problemNum = problem;
		this.problemTime = ProblemTime;
		this.Lstate = L;
	}

	public int getProblemTime() {
		return problemTime;
	}

	public void setProblemTime(int problemTime) {
		this.problemTime = problemTime;
	}

	public char getLstate() {
		return Lstate;
	}

	public void setLstate(char lstate) {
		Lstate = lstate;
	}

	public int getProblemNum() {
		return problemNum;
	}
	
}
