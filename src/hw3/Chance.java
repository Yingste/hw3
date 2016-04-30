package hw3;

/**
 * Scoring category that is satisfied by any hand.
 * The score is the sum of all die values.
 */
public class Chance implements hw3.api.Category
{
  /**
   * Constructs a Chance category with the given display name.
   * @param displayName
   *   name for this category
   */
	private Hand hcounto;
	
	private String dname;
	private Boolean filled;
  public Chance(String displayName)
  {
	  filled = false;
	  dname = displayName;
	  
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
  		test += temp[i];
  	}
  	
  	
  	return test;
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
  	
  	
  	return filled;
  }

  @Override
  public int getPotentialScore(Hand dice) {
  	int[] temp = dice.getAll();
  	int test = 0;
  	int i = 0; 
  	for(i = 0; i < temp.length - 1; i ++)
  	{
  		test += temp[i];
  	}
  	
  	
  	return test;
  } 
  }