import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int CASES = sc.nextInt();
		for (int u = 0; u < CASES; u++){
			HashMap<Integer, HashMap<Integer, Double>> aList  = new HashMap<Integer, HashMap<Integer, Double>>();
			int nFreckles = sc.nextInt();
			ArrayList<Point2D> freckles = new ArrayList<>();
			int[] sets = new int[nFreckles];
			for (int i = 0; i < nFreckles; i++){
				freckles.add(new Point2D.Double(sc.nextDouble(),sc.nextDouble()));
				sets[i] = i;
			}
			for (int k = 0; k < freckles.size(); k++) {
				for (int l = 0; l < freckles.size(); l++) {
					if (l == k)
						continue;
					double distance = freckles.get(k).distance(freckles.get(l));
					addEdge(k, l, distance, aList);
					addEdge(l, k, distance, aList);
				}
			}
			System.out.printf("%.2f\n\n", BlackMagic(aList));
		}
		sc.close();
	}
	static void addEdge(int from, int to, double weight, HashMap<Integer, HashMap<Integer, Double>> aList) {
		if (aList.containsKey(from))
			aList.get(from).put(to, weight);
		else {
			HashMap<Integer, Double> edges = (new HashMap<Integer, Double>());
			edges.put(to, weight);
			aList.put(from, edges);
		}
	}
	
	static Set<Entry<Integer, Double>> findNeighbor(int node, HashMap<Integer, HashMap<Integer, Double>> aList) {
		Set<Entry<Integer, Double>> nWeight = new HashSet<Entry<Integer, Double>>();
		if (aList.containsKey(node)) 
			nWeight = aList.get(node).entrySet();
		return nWeight;
	}
	
	/**
	 * Prim's Algorithm. Painful. Sorta Works. Makes 0 Sense.
	 * @param start
	 * @return
	 */
	static double BlackMagic(HashMap<Integer, HashMap<Integer, Double>> aList) {
		HashSet<Integer> visited = new HashSet<Integer>();
		Integer lastInserted = 0;
		double total = 0;
		visited.add(0);

		PriorityQueue<Triple> possibleEdges = new PriorityQueue<Triple>();
		while (aList.size() != visited.size()) {
			for (Entry<Integer, Double> nw : findNeighbor(lastInserted,aList))
				possibleEdges.add(new Triple(lastInserted, nw.getKey(), nw.getValue()));
			if (possibleEdges.size() <= 0)
				break;
			Triple t = possibleEdges.poll();
			while (visited.contains(t.getTo())) 
				t = possibleEdges.poll();

			visited.add(t.getTo());
			lastInserted = t.getTo();
			total += t.getWeight();
		}

		return total;
	}
}
