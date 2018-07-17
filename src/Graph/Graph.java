package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import HashMap.HeapGeneric;

/**
 * @author Rishabh
 * 
 * @date 07-Jul-2018
 */

public class Graph {

	private class Vertex {
		// Neighbors
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vertices = new HashMap<>();

	// number of vertex/Nodes
	public int numVertex() {
		return vertices.size();
	}

	public boolean containsVertex(String vname) {
		return vertices.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (containsVertex(vname)) {
			return;
		}

		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);

	}

	public void removeVertex(String vname) {
		Vertex vtx = vertices.get(vname);

		for (String nbr : vtx.nbrs.keySet()) {
			Vertex nbrvtx = vertices.get(nbr);
			nbrvtx.nbrs.remove(vname);
		}

		vertices.remove(vname);
	}

	public int numEdge() {
		int sum = 0;
		for (String key : vertices.keySet()) {
			Vertex vtx = vertices.get(key);
			sum += vtx.nbrs.size();
		}
		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
	}

	public void display() {

		for (String vname : vertices.keySet()) {

			System.out.println(vname + "->" + vertices.get(vname).nbrs);
		}
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);
		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vertices.get(src);

		for (String nbrname : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbrname) && hasPath(nbrname, dst, processed)) {
				return true;
			}
		}
		return false;
	}

	private class Pair {
		String vname;
		String psf; // path so far
		Vertex vtx;
		String color;
	}

	// Breadth First Search-- shortest distance between two
	public boolean BFS(String src, String dst) {
		// processing then DE(direct edge) check then neighbors
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// 1. starting pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		queue.addLast(sp);

		// 2. while queue is not empty
		while (!queue.isEmpty()) {

			// 2.1 removing pair
			Pair rp = queue.removeFirst();

			// 2.2 processing
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 2.3 DE
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 3. Neighbors
			for (String nbr : rp.vtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					// new pair
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	// Depth First Search -- Doesn't guarantee shortest
	public boolean DFS(String src, String dst) {
		// processing then DE(direct edge) check then neighbors
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// 1. starting pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		sp.vtx = vertices.get(src);

		stack.addFirst(sp);

		// 2. while queue is not empty
		while (!stack.isEmpty()) {

			// 2.1 removing pair
			Pair rp = stack.removeFirst();

			// 2.2 processing
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 2.3 DE
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 3. Neighbors
			for (String nbr : rp.vtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					// new pair
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					np.vtx = vertices.get(nbr);

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	// Breadth First Traversal
	public void BFT() {
		// processing then DE(direct edge) check then neighbors
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 removing pair
				Pair rp = queue.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 2.3 DE
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}
			}
		}
	}

	// Depth First Traversal
	public void DFT() {
		// processing then DE(direct edge) check then neighbors
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			stack.addFirst(sp);

			// 2. while queue is not empty
			while (!stack.isEmpty()) {

				// 2.1 removing pair
				Pair rp = stack.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 2.3 DE
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						stack.addFirst(np);
					}
				}
			}
		}
	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 removing pair
				Pair rp = queue.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {
					// System.out.println("Cycle is Present");
					return true;
					// break;
				}
				processed.put(rp.vname, true);

				// 2.3 DE
				// System.out.println(rp.vname + " via " + rp.psf);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}
			}
		}
		return false;
	}

	public boolean isConnected() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();
		int count = 1;
		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			if (count >= 2) {
				if (!processed.containsKey(key)) {
					return false;
				}
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 removing pair
				Pair rp = queue.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				count++;
				// 2.3 DE
				// System.out.println(rp.vname + " via " + rp.psf);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}
			}
		}
		return true;
	}

	// get Connected Components
	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			ArrayList<String> subans = new ArrayList<>();
			if (processed.containsKey(key)) {
				continue;
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);

			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 removing pair
				Pair rp = queue.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 2.3 DE
				// System.out.println(rp.vname + " via " + rp.psf);
				subans.add(rp.vname);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);

						queue.addLast(np);
					}
				}
			}
			ans.add(subans);
		}
		return ans;
	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public boolean Bipartite() {
		HashMap<String, String> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. starting pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.vtx = vertices.get(key);
			sp.color = "red";
			queue.addLast(sp);

			// 2. while queue is not empty
			while (!queue.isEmpty()) {

				// 2.1 removing pair
				Pair rp = queue.removeFirst();

				// 2.2 processing
				if (processed.containsKey(rp.vname)) {

					// new and old color
					String nc = rp.color;
					String oc = processed.get(rp.vname);

					if (!nc.equals(oc)) {
						return false;
					}
					continue;
				}
				processed.put(rp.vname, rp.color);

				// 2.3 DE
				// System.out.println(rp.vname + " via " + rp.psf);

				// 3. Neighbors
				for (String nbr : rp.vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						// new pair
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.vtx = vertices.get(nbr);
						np.color = rp.color.equals("red") ? "green" : "red";

						queue.addLast(np);
					}
				}
			}
		}

		return true;
	}

	private class ppair implements Comparable<ppair> {
		// vertex and acquiring vertex name
		String vtxname;
		String acqrvtxname;
		int cost;

		@Override
		public int compareTo(ppair o) {
			return o.cost - this.cost;
		}
	}

	public Graph prims() {

		HeapGeneric<ppair> heap = new HeapGeneric<ppair>();

		HashMap<String, ppair> processed = new HashMap<>();

		Graph mst = new Graph();

		// make pairs and put in map
		for (String key : vertices.keySet()) {
			ppair np = new ppair();
			np.vtxname = key;
			np.acqrvtxname = null;
			np.cost = Integer.MAX_VALUE;

			// put in heap and hash map
			heap.add(np);
			processed.put(key, np);
		}

		// work till heap is not empty
		while (!heap.isempty()) {

			// remove a pair from heap and processed hash map
			ppair rp = heap.remove();
			processed.remove(rp.vtxname);

			// add to your mst
			if (rp.acqrvtxname == null) {
				mst.addVertex(rp.vtxname);
			} else {
				mst.addVertex(rp.vtxname);
				mst.addEdge(rp.acqrvtxname, rp.vtxname, rp.cost);
			}

			// do work for nbrs
			for (String nbr : vertices.get(rp.vtxname).nbrs.keySet()) {
				if (processed.containsKey(nbr)) {
					// find old and new cost
					int oc = processed.get(nbr).cost;
					int nc = vertices.get(nbr).nbrs.get(rp.vtxname);

					// update only when new cost > old cost
					if (nc < oc) {

						// update the pair of heap
						processed.get(nbr).cost = nc;
						processed.get(nbr).acqrvtxname = rp.vtxname;

						// heap update
						heap.UpdatePriority(processed.get(nbr));
					}
				}
			}
		}
		return mst;
	}
}