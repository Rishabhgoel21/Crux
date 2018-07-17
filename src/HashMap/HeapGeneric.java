package HashMap;

import java.util.ArrayList;

/**
 * @author Rishabh
 * 
 * @date 03-Jul-2018
 */

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	// o(1)
	public int size() {
		return this.data.size();
	}

	// o(1)
	public boolean isempty() {
		return this.size() == 0;
	}

	// o(log n)
	public void add(T item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	// o(log n)
	private void upheapify(int ci) {
		// parent index using child index
		int pi = (ci - 1) / 2;

		if (islarger(this.data.get(ci), this.data.get(pi)) > 0) {

			swap(pi, ci);
			upheapify(pi);
		}
	}

	// o(1)
	private void swap(int i, int j) {

		T ith = this.data.get(i);
		T jth = this.data.get(j);

		this.data.set(i, jth);
		this.data.set(j, ith);

	}

	// o(log n)
	public T remove() {
		swap(0, this.data.size() - 1);
		T rv = this.data.remove(this.data.size() - 1);
		downheapify(0);

		return rv;
	}

	// o(log n)
	private void downheapify(int pi) {
		// left & right child index
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.data.size() && islarger(this.data.get(lci), this.data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && islarger(this.data.get(rci), this.data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	// o(1)
	public T getmin() {
		return this.data.get(0);
	}

	private int islarger(T t, T o) {
		return t.compareTo(o);
	}

	public void UpdatePriority(T pair) {
		
		int idx = 0;
		for(int i = 0 ; i<data.size() ; i++) {
			
			if(data.get(i) == pair) {
				idx = i;
			}
		}
		
		upheapify(idx);
	}
}