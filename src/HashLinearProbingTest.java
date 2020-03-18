import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HashLinearProbingTest {

	@Test
	@DisplayName("Put de la table A complète")
	void testPut() {
		HashLinearProbing linearProb = new HashLinearProbing(11);
		
		assertThat(linearProb.put('B',0)).isEqualByComparingTo(0);
		assertThat(linearProb.put('O',1)).isEqualByComparingTo(2);
		assertThat(linearProb.put('E',2)).isEqualByComparingTo(3);
		assertThat(linearProb.put('P',3)).isEqualByComparingTo(4);
		assertThat(linearProb.put('V',4)).isEqualByComparingTo(9);
		assertThat(linearProb.put('L',5)).isEqualByComparingTo(10);
		assertThat(linearProb.put('X',6)).isEqualByComparingTo(1);
		assertThat(linearProb.put('N',7)).isEqualByComparingTo(5);
		assertThat(linearProb.put('K',8)).isEqualByComparingTo(6);
		assertThat(linearProb.put('M',9)).isEqualByComparingTo(7);
	}

	@Test
	@DisplayName("Get de tous les éléments")
	void testGet() {
		HashLinearProbing linearProb = new HashLinearProbing(11);
		
		linearProb.put('B',0);
		assertThat(linearProb.get('B')).isEqualByComparingTo(0);
		linearProb.put('O',1);
		assertThat(linearProb.get('O')).isEqualByComparingTo(1);
		linearProb.put('E',2);
		assertThat(linearProb.get('E')).isEqualByComparingTo(2);
		linearProb.put('P',3);
		assertThat(linearProb.get('P')).isEqualByComparingTo(3);
		linearProb.put('V',4);
		assertThat(linearProb.get('V')).isEqualByComparingTo(4);
		linearProb.put('L',5);
		assertThat(linearProb.get('L')).isEqualByComparingTo(5);
		linearProb.put('X',6);
		assertThat(linearProb.get('X')).isEqualByComparingTo(6);
		linearProb.put('N',7);
		assertThat(linearProb.get('N')).isEqualByComparingTo(7);
		linearProb.put('K',8);
		assertThat(linearProb.get('K')).isEqualByComparingTo(8);
		linearProb.put('M',9);
		assertThat(linearProb.get('M')).isEqualByComparingTo(9);	
	}
	
	@Test
	@DisplayName("Recherche clé absente dans la table hachage")
	void testGetKeyMissing() {
		HashLinearProbing linearProb = new HashLinearProbing(3);
		
		linearProb.put('B',0);
		linearProb.put('O',1);
		
		assertThat(linearProb.get('Z')).isEqualByComparingTo(-1);
	}

	@Test
	@DisplayName("Suppression clé absente")
	void testRemoveKeyMissing() {
		HashLinearProbing linearProb = new HashLinearProbing(3);
		
		linearProb.put('B',0);
		linearProb.put('O',1);
		
		assertThat(linearProb.remove('Z')).isEqualTo(false);
	}

	
	/* partie pas demandée dans le devoir */
	@Test
	@DisplayName("Ne doit pas depasser la taille limite")
	void testPutAfterLimit() {
		HashLinearProbing linearProb = new HashLinearProbing(3);
		
		linearProb.put('B',0);
		linearProb.put('O',1);
		linearProb.put('E',2);
		
		assertThat(linearProb.get('E')).isEqualByComparingTo(-1);
	}
}
