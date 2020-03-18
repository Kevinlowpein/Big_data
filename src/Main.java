
public class Main {

	public static void main(String[] args) {
		HashLinearProbing test = new HashLinearProbing(11);
		// initialisation du tableau A
		char A[] = new char[test.getM() -1];
		A[0] = 'B';
		A[1] = 'O';
		A[2] = 'E';
		A[3] = 'P';
		A[4] = 'V';
		A[5] = 'L';
		A[6] = 'X';
		A[7] = 'N';
		A[8] = 'K';
		A[9] = 'M';
		for(int i = 0; i< A.length; i++) {
			test.put(A[i], i);
		}
		System.out.println("** Put de la table A **");
		test.diplay();
		System.out.println(" ");
		System.out.println("** Get de tous les elements **");
		System.out.println("B: "+test.get('B'));
		System.out.println("O: "+test.get('O'));
		System.out.println("E: "+test.get('E'));
		System.out.println("P: "+test.get('P'));
		System.out.println("V: "+test.get('V'));
		System.out.println("L: "+test.get('L'));
		System.out.println("X: "+test.get('X'));
		System.out.println("N: "+test.get('N'));
		System.out.println("K: "+test.get('K'));
		System.out.println("M: "+test.get('M'));
		System.out.println(" ");
		System.out.println("** clé absent dans la table **");
		System.out.println(test.get('Y'));
		System.out.println(" ");
		System.out.println("** test suppression cle absent **");
		test.remove('Y');
	}

}
