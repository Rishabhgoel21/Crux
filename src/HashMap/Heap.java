package HashMap;
/**
 * @author Rishabh
 * 
 * @date 03-Jul-2018
*/

import java.util.ArrayList;

public class Heap {

	ArrayList<Integer> data = new ArrayList<>();

	// o(1)
	public int size() {
		return this.data.size();
	}

	// o(1)
	public boolean isempty() {
		return this.size() == 0;
	}

	// o(log n)
	public void add(int item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	// o(log n)
	private void upheapify(int ci) {
		// parent index using child index
		int pi = (ci - 1) / 2;

		if (this.data.get(ci) < this.data.get(pi)) {

			swap(pi, ci);
			upheapify(pi);
		}
	}

	// o(1)
	private void swap(int i, int j) {

		int ith = this.data.get(i);
		int jth = this.data.get(j);

		this.data.set(i, jth);
		this.data.set(j, ith);

	}

	// o(log n)
	public int remove() {
		swap(0, this.data.size() - 1);
		int rv = this.data.remove(this.data.size() - 1);
		downheapify(0);

		return rv;
	}

	// o(log n)
	private void downheapify(int pi) {
		// left & right child index
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.data.size() && this.data.get(lci) < this.data.get(mini)) {
			mini = lci;
		}

		if (rci < this.data.size() && this.data.get(rci) < this.data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	// o(1)
	public int getmin() {
		return this.data.get(0);
	}

	public int getmax() {
		// checking all the leaf nodes

		int max = Integer.MIN_VALUE;

		for (int i = this.data.size() / 2; i < this.data.size(); i++) {
			if (this.data.get(i) > max) {
				max = this.data.get(i);
			}
		}
		return max;
	}
}