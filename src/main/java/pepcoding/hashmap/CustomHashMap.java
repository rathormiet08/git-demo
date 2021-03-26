package pepcoding.hashmap;

import java.util.LinkedList;

public class CustomHashMap<K, V> {

	private class HMNode {
		K key;
		V value;

		public HMNode(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}

	private LinkedList<HMNode>[] buckets;
	int size;

	public CustomHashMap() {
		initBucket(4);
		size = 0;
	}

	
	@SuppressWarnings("unchecked")
	private void initBucket(int N) {
		buckets = new LinkedList[N];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	void put(K key, V value) {
		int bi = getBucketIndex(key);
		int di = getBucketDataIndex(key, bi);
		if (di != -1) {
			HMNode hmNode = buckets[bi].get(di);
			hmNode.value = value;
		} else {
			HMNode hmNode = new HMNode(key, value);
			buckets[bi].add(hmNode);
			size++;
		}

		double lambda = size * 1.0 / buckets.length;
		if (lambda > 2.0) {
			System.out.println("calling rehashing---");
			rehash();
		}
	}

	
	V get(K key) {
		int bi = getBucketIndex(key);
		int di = getBucketDataIndex(key, bi);
		if (di != -1) {
			HMNode hmNode = buckets[bi].get(di);
			return hmNode.value;
		} else {
			return null;
		}

	}
	
	String remove(K key) {
		int bi = getBucketIndex(key);
		int di = getBucketDataIndex(key, bi);
		if (di != -1) {
			HMNode hmNode = buckets[bi].remove();
			return " successfully removed item :: "+hmNode.value;
		} else {
			return null;
		}

	}
	
	int getSize() {
		return size;
	}

	private void rehash() {
		LinkedList<HMNode>[] obl = buckets;
		initBucket(obl.length * 2);
		size = 0;
		for (int i = 0; i < obl.length; i++) {
			for (HMNode hmNode : obl[i]) {
				put(hmNode.key, hmNode.value);
			}
		}

	}

	private int getBucketDataIndex(K key, int bi) {
		int di = 0;
		for (HMNode node : buckets[bi]) {
			if (node.key.equals(key)) {
				return di;
			}
			di++;
		}
		return -1;
	}

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();

		return hashCode % buckets.length;
	}
void display(CustomHashMap<String, Integer> hm,String key) {
	int size2 = hm.getSize();
	while(size2>0) {
		System.out.println("==="+hm.get(key));
		size2--;
	}
}

/*List<K> keyList(CustomHashMap<String, Integer> hm){
	int size2 = hm.getSize();
	List<K> list=new ArrayList<>();
	
	while(size2>0) {
		System.out.println("==="+hm.get(key));
		//list.add(hm.ge);
		size2--;
	}
	return null;
}*/
	public static void main(String[] args) {
		CustomHashMap<String, Integer> hm = new CustomHashMap<>();
		hm.put("India", 200);
		hm.put("America", 20);
		hm.put("Pak", 50);
		hm.put("London", 20);
		hm.put("Aus", 50);
		hm.put("China", 50);
		hm.put("Brazil", 20);
		hm.put("Canada", 50);
		hm.put("Dubai", 50);
		System.out.println("size==="+hm.getSize());
		System.out.println(hm.get("Pak"));
		hm.remove("Pak");
		
		System.out.println("again fetching key after removing===="+hm.get("Pak"));
		//hm.display(hm, key);
	}

}
