
public class HashLinearProbing {

	private final int M; // taille du bucket
	private char tKeys[]; 	// tableau de clés
	private int tValues[]; // tableau de valeurs
	public static final int EMPTY = 0;
	public int nbSlot; // nombre éléments insérés
	
	public HashLinearProbing(int max) {
		// TODO Auto-generated constructor stub
		M = max;
		tKeys = new char[M];
		tValues = new int[M];
		nbSlot = 0;
	}
	
	private int hash(char key) {
		int codeAscii = (int) key;
		return (codeAscii % M);
	}
	
	public int put(char key, int value) {
		int valueToReturn = -1;
		// test si le bucket est plein (avec la case libre pour la sortie)
		if(nbSlot == M-1) { 
			System.out.println("**Bucket is full!!");
			return valueToReturn;
		}
		else {
			int index = hash(key);
			while (tKeys[index] != EMPTY) {
				index = (index + 1) % M;
			}
			tKeys[index] = key;
			tValues[index] = value;
			nbSlot ++; // incrémente le nombre d'élément
			valueToReturn = index;
		}
		return valueToReturn;
	}
	
	public int get(char key) {
		int valueToReturn = -1;
		if(nbSlot == EMPTY) {
			System.out.println("** Bucket is empty");
			return valueToReturn;
		}
		else {
			int index = hash(key);
			while (tKeys[index] != key && tKeys[index] != EMPTY ) {
				index = (index +1) % M;
			}
			if(tKeys[index] == key) valueToReturn = tValues[index];
		}
		return valueToReturn;	
	}
	
	public boolean remove(char key) {
		boolean valueToReturn = false;
		// test si le bucket est vide
		if(nbSlot == EMPTY) {
			System.out.println("** Bucket is empty");
			return valueToReturn;
		}
		else {
			int index = hash(key);
			while (tKeys[index] != key && tKeys[index] != EMPTY ) {
				index = (index +1) % M;
			}
			if(tKeys[index] != key) {
				System.out.println("** key not found!!");
				return valueToReturn;
			}
			tKeys[index] = EMPTY;
			tValues[index] = EMPTY;
			nbSlot --; // décrémente le nombre d'élément
			valueToReturn = true;
			
			// rehash
			index = (index +1) % M;
			while (tKeys[index] != EMPTY) {
				char tempKey = tKeys[index];
				int tempValue = tValues[index];
				tKeys[index] = EMPTY;
				tValues[index] = EMPTY;
				nbSlot --; // décrémente après libération d'une case
				put(tempKey, tempValue);
				index = (index +1) % M;
			}
		}
		return valueToReturn;
	}
	
	public void diplay() {
		for(int index = 0; index < M; index++) {
			System.out.println(
				"["+index+"]: "+ "["+tKeys[index]+", "+tValues[index]+"]"		
			);
		}	
	}
	
	public int getM() {
		return M;
	}
	
	public int getNbSlot() {
		return this.nbSlot;
	}
	
}
