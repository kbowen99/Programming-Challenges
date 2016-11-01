import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class Team implements Comparator, Comparable{
	/**
	 * +3 for each win, +1 for each Tie, +0 for each loss
	 */
	int totalPoints;
	int gamesPlayed;
	int wins;
	int ties;
	int losses;
	int goalsScored;
	int goalsLost;
	int teamRank;
	String name;
	
	public Team(String name){
		this.name = name;
		this.totalPoints = 0;
		this.gamesPlayed = 0;
		this.wins = 0;
		this.ties = 0;
		this.losses = 0;
		this.goalsScored = 0;
		this.goalsLost = 0;
		this.teamRank = -1;
	}
	
	/**
	 * Records a game to a teams record (Updates All Appropriate Variables)
	 * @param goalScored - Goals Scored by [team]
	 * @param goalLost - Goals Scored by [other team]
	 */
	public void recordGame(int goalScored,int goalLost){
		this.goalsScored += goalScored;
		this.goalsLost += goalLost;
		this.gamesPlayed++;
		if (goalScored > goalLost)
			wins++;
		if (goalScored == goalLost)
			ties++;
		if (goalScored < goalLost)
			losses++;
		updatePoints();
	}
	
	/**
	 * Laziness
	 */
	private void updatePoints(){
		this.totalPoints = (3 * wins) + ties;
	}
	
	public void setRank(int newRank){
		this.teamRank = newRank;
	}
	
	/**
	 * The most complicated toString ever
	 */
	public String toString(){
		return this.teamRank + ") " + this.name + " " + this.totalPoints + "p, " + 
				this.gamesPlayed + "g (" + this.wins + "-" + this.ties + "-" + this.losses + 
				"), " + (this.goalsScored - this.goalsLost) + "gd (" + this.goalsScored +"-" +
				this.goalsLost + ")";
	}

	@Override
	public int compareTo(Object arg0) {
		//if (this.totalPoints > )
		return 0;
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getWins() {
		return wins;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public int getGoalsLost() {
		return goalsLost;
	}

	public String getName() {
		return name;
	}
}
