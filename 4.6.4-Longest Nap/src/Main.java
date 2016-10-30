import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static final boolean DEBUG = true;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Day = 1;
		while (sc.hasNextLine()) {
			int numAppointments = Integer.parseInt(sc.nextLine());

			ArrayList<Appointment> schedule = new ArrayList<>();

			for (int eachAppointment = 0; eachAppointment < numAppointments && sc.hasNextLine(); eachAppointment++) {
				String input = sc.nextLine().replace(':', ' ');
				Scanner numScan = new Scanner(input);
				schedule.add(new Appointment(numScan.nextInt(), numScan.nextInt(), numScan.nextInt(), numScan.nextInt(),
						input.substring(12)));
				numScan.close();
			}
			Collections.sort(schedule);

			pSchedule(schedule);
			
			//checkOverlaps(schedule);
			//checkOverlaps(schedule);
			Collections.sort(schedule);

			pSchedule(schedule);

			// Make sure day starts at 10:00
			if (!schedule.get(0).getStartTime().equals(new KTime(10, 0)))
				schedule.add(0, new Appointment(new KTime(10, 0), schedule.get(0).getStartTime(), "Nap"));
			// Make sure day ends at 18:00
			if (!schedule.get(schedule.size() - 1).getEndTime().equals(new KTime(18, 0)))
				schedule.add((schedule.size()),
						new Appointment(schedule.get(schedule.size() - 1).getEndTime(), new KTime(18, 0), "Nap"));

			Collections.sort(schedule);
			
			// Fill In Scheduling Gaps (With Naps of Course)
			for (int i = 0; i < schedule.size() - 1 && i < 1000; i++) {
				Appointment next = schedule.get(i + 1);
				Appointment curr = schedule.get(i);
				if (!curr.getEndTime().equals(next.getStartTime()) && next.getStartTime().compareTo(curr.getEndTime()) > 0) {
					boolean shouldAdd = true;
					for (int j = 0; j < i; j++)
						if (schedule.get(j).endTime.toMinutes() >= next.getStartTime().toMinutes())
							shouldAdd = false;
					if (shouldAdd){					
						schedule.add(i, new Appointment(curr.getEndTime(), next.getStartTime(), "Nap"));
						Collections.sort(schedule);
						i++;
					}
				}
				// System.out.println(i);
			}

			// Find the Longest Nap
			Appointment LongestNap = new Appointment(0, 0, 0, 0, "No Naps Today");
			for (Appointment A : schedule)
				if (A.getTitle().equals("Nap") && A.getDurationInMin() > LongestNap.getDurationInMin())
					LongestNap = A;

			// Output

			System.out.println("Day #" + Day++ + ": the longest nap starts at " + LongestNap.getStartTime().toString()
					+ " and will last for " + (LongestNap.getDuration().getHour() > 0 ? LongestNap.getDuration().getHour() + " hours and " :
						"" )
					+ LongestNap.getDuration().getMin() + " minutes.");

			pSchedule(schedule);
		}
		sc.close();
	}

	private static void pSchedule(ArrayList<Appointment> schedule) {
		if (DEBUG) {
			for (Appointment A : schedule)
				System.out.println(A.toString());
			System.out.println("--------------------------------");
		}
	}
	
	private static void checkOverlaps(ArrayList<Appointment> schedule){
		// Check for overlapping
		Appointment Last = schedule.get(0);
		for (int i = 1; i < schedule.size(); i++) {
			Appointment curr = schedule.get(i);
			if (curr.getStartTime().equals(Last.getStartTime())) { // Start at same time
				if (curr.getDurationInMin() > Last.getDurationInMin())
					schedule.remove(i - 1);
				else
					schedule.remove(i);
				//i--;
			} else if (curr.getStartTime().compareTo(Last.getEndTime()) < 0 && curr.getStartTime().compareTo(Last.getStartTime()) > 0) {
				schedule.get(i - 1).setEndTime(curr.getEndTime());
				schedule.remove(i);
				//checkOverlaps(schedule);
			} else if (curr.getEndTime().compareTo(Last.getEndTime()) < 0) {
				schedule.remove(i);
			}
			Last = curr;
		}
	}

}
