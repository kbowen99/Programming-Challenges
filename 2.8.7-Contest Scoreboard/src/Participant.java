import java.util.ArrayList;
import java.util.Comparator;

public class Participant implements Comparator<Participant>,Comparable  {
	int contestantNum;
	int totalTime;
	int correctProbs;
	
	ArrayList<Problem> AttemptedProblems;
	
	public Participant(int contestant){
		this.AttemptedProblems = new ArrayList<>();
		this.correctProbs = 0;
		this.totalTime = 0;
		this.contestantNum = contestant;
	}
	
	public void addProblem(Problem p){
		if (AttemptedProblems.contains(p)){}
		else if (p.getLstate() == 'C'){
			for (Problem i : AttemptedProblems)
				if (i.problemNum == p.problemNum && i.getLstate() == 'I')
					this.totalTime += 20;//20 min for each prior submission
			this.totalTime += p.getProblemTime();
			this.AttemptedProblems.add(p);
			this.correctProbs++;
		} else {
			this.AttemptedProblems.add(p);
		}
	}
	
	public void addProblem(int num, int time, char L){
		addProblem(new Problem(num,time,L));
	}
	
	public int getContestantNum(){
		return this.contestantNum;
	}
	
	public int getTotalTime(){
		return this.totalTime;
	}
	
	public int getCorrectProbs(){
		return this.correctProbs;
	}

	@Override
	public int compare(Participant arg0, Participant arg1) {
		return arg0.compareTo(arg1);
	}
	
	public int compareTo(Participant arg1){
		if (this.getCorrectProbs() > arg1.getCorrectProbs()){
			return -1;
		} else if (this.getCorrectProbs() < arg1.getCorrectProbs()){
			return 1;
		} else {
			if (this.getTotalTime() < arg1.getTotalTime())
				return -1;
			if (this.getTotalTime() > arg1.getTotalTime())
				return 1;
		}
		return 0;
	}

	@Override
	public int compareTo(Object arg0) {
		return this.compareTo((Participant)arg0);
	}
	
}
