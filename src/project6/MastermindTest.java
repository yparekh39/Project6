package project6;

import static org.junit.Assert.*;

import org.junit.Test;

public class MastermindTest {

	@Test
	public void testTurnSize() {
		assertEquals(12, MastermindModel.GameState.length);
	}
	
	@Test
	public void testPegInvalid() {
		char[] test = {'R', 'R', 'G', 'H'};
		assertFalse(MastermindController.legalGuess(test));
	}

}
