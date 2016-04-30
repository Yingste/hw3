package hw3;

/**
 * Scoring category for a "yahtzee".  A hand
 * with N dice satisfies this category only if all N
 * values are the same.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class AllOfAKind implements hw3.api.Category
{
  /**
   * Constructs an AllOfAKind with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
private Hand hcounto;
	
	private String dname;
	private Boolean filled;
	private int epoints;
  public AllOfAKind(String displayName, int points)
  {
	  dname = displayName;
	  epoints = points;
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
  	int k = 0;
  	int count = 0;
  	int val = 0;
  	for(k = 0; k < temp.length - 1; k ++)
  	{
  		for(i = 0; i < temp.length - 1; i ++)
  	  	{
  	  		if(temp[k] == temp[i])
  	  		{
  	  			test++;
  	  		}
  	  	}
  		count = Math.max(count, test);
  		if (count < test)
  		{
  			val = temp[k];
  		}
  			
  	}
  	
  	
  	
  	if (count == temp.length)
  	{
  		return epoints;
  	}
  	return 0;
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
	  	int k = 0;
	  	int count = 0;
	  	int val = 0;
	  	for(k = 0; k < temp.length - 1; k ++)
	  	{
	  		for(i = 0; i < temp.length - 1; i ++)
	  	  	{
	  	  		if(temp[k] == temp[i])
	  	  		{
	  	  			test++;
	  	  		}
	  	  	}
	  		count = Math.max(count, test);
	  		if (count < test)
	  		{
	  			val = temp[k];
	  		}
	  			
	  	}
	  	
	  	
	  	
	  	
	  	if (count == temp.length)
	  	{
	  		return epoints;
	  	}
	  	return 0;
  } 
  }
  

