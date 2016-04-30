package hw3;

/**
 * Scoring category that is based on counting occurrences
 * of a particular target value (specified in the constructor).
 * This category is satisfied by any hand.  The score
 * is the sum of just the die values that match the target value.
 */
public class CountOccurrences implements hw3.api.Category
{
  /**
   * Constructs a CountOccurrences category with the given display name and 
   * target value.
   * @param displayName
   *   name for this category
   * @param whichValue
   *   target value that must be matched for a die to count toward the
   *   score
   */
	private Hand hcounto;
	private int dval;
	private String dname;
	private Boolean filled;
  public CountOccurrences(String displayName, int whichValue)
  {
	  filled = false;
	  dname = displayName;
	  dval = whichValue;
  }

@Override
public boolean isFilled() {
	
	return filled;
}

@Override
public int getScore() {
	int[] temp = getHand().getAll();
	int test = 0;
	int i = 0; 
	for(i = 0; i < temp.length - 1; i ++)
	{
		if(temp[i] == dval)
		{
			test++;
		}
	}
	
	
	return test * dval;
}

@Override
public Hand getHand() {
	
	return hcounto;
}

@Override
public String getDisplayName() {
	
	return dname;
}

@Override
public void fill(Hand dice) {
	hcounto = dice;
	filled = true;
}

@Override
public boolean isSatisfiedBy(Hand dice) {
	int[] temp = getHand().getAll();
	Boolean test = false;
	int i = 0; 
	for(i = 0; i < temp.length - 1; i ++)
	{
		if(temp[i] == dval)
		{
			test = true;
		}
	}
	
	return test;
}

@Override
public int getPotentialScore(Hand dice) {
	int[] temp = dice.getAll();
	int test = 0;
	int i = 0; 
	for(i = 0; i < temp.length - 1; i ++)
	{
		if(temp[i] == dval)
		{
			test++;
		}
	}
	
	
	return test * dval;
} 
}
