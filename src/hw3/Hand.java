  package hw3;

import java.util.Random;

/**
 * This class represents values of a group of dice for a dice game such as Yahtzee in which 
 * multiple rolls per turn are allowed. The number of faces on the dice, 
 * the number of dice in the Hand, and the maximum number of rolls are configurable 
 * via the constructor. At any time some of the dice may be <em>available</em>
 * to be rolled, and the other dice are <em>fixed</em>.  Calls to the 
 * <code>roll()</code> method will select new, random values for the available
 * dice only.  After the maximum number of rolls, all dice are automatically
 * fixed; before that, the client can select which dice to "keep" (change from
 * available to fixed) and which dice to "free" (change from fixed to
 * available).
 * <p>
 * Note that valid die values range from 1 through the given
 * <code>maxValue</code>. 
 */
public class Hand
{

	private int   mvalue;
	private int   mrolls;
	private int   mdice;
	private int   rolls = 0;
	private int[] dice;
	private int[] fixed;
  /**
   * Constructs a new Hand in which each die initially has 
   * the (invalid) value zero. 
   * @param numDice
   *   number of dice in this group
   * @param maxValue
   *   largest possible die value, where values range from 1
   *   through <code>maxValue</code>
   * @param maxRolls
   *   maximum number of total rolls
   */
  public Hand(int numDice, int maxValue, int maxRolls)
  {
    	mvalue = maxValue;
    	mrolls = maxRolls;
    	mdice = numDice;
    	
    	dice  = new int[mdice];
    	fixed = new int[mdice];
    	
    	int i = 0;
    	for (i = 0; i < mdice; i ++)
    	{
    		dice[i] = 0;
    		fixed[i] = 0;
    	}
    	
    	
  }   
  
  /**
   * Constructs a new Hand in which each die initially has 
   * the value given by the <code>initialValues</code> array.
   * If the length of the array is greater than the number of dice, the
   * extra values are ignored.  If the length of the array is smaller
   * than the number of dice, remaining dice
   * will be initialized to the (invalid) value 0.
   * <p>
   * This version of the constructor is primarily intended for testing.
   * @param numDice
   *   number of dice in this group
   * @param maxValue
   *   largest possible die value, where values range from 1
   *   through <code>maxValue</code>
   * @param maxRolls
   *   maximum number of total rolls
   * @param initialValues
   *   initial values for the dice
   */
  public Hand(int numDice, int maxValue, int maxRolls, int[] initialValues)
  {
    mvalue = maxValue;
	mrolls = maxRolls;
	mdice = numDice;
	
	dice  = new int[mdice];
	fixed = new int[mdice];
	
	if(initialValues.length < dice.length)
	{
		int i = 0;
		for (i = 0; i < mdice; i ++)
		{
			if(i > initialValues.length)
			{
				dice[i] = 0;
			}else
			{
				dice[i] = initialValues[i];
			}
			
			fixed[i] = 0;
		}
	}else
	{
		int i = 0;
		for (i = 0; i < mdice; i ++)
		{
			dice[i] = initialValues[i];
			fixed[i] = 0;
		}
	}
	
  }  
  
  /**
   * Returns the number of dice in this group.
   * @return
   *   number of dice in this group
   */
  public int getNumDice()
  {
    
    return mdice;
  }
  
  /**
   * Returns the maximum die value in this group.
   * Valid values start at 1.
   * @return
   *   maximum die value
   */
  public int getMaxValue()
  {
	  int max = 0;
	  int i = 0;
	  
	  for(i = 0; i < dice.length - 1; i ++)
	  {
		  max = Math.max(dice[i], max);
	  }
	  
	  
	  return max;
  }
  
  /**
   * Rolls all available dice; that is, each available
   * die value in this group is replaced by a randomly generated
   * value produced by the given random number generator.
   * @param rand
   *   random number generator to be used for rolling dice
   */
  public void roll(Random rand)
  {
	  
	  int i = 0;
	  
	  for(i = 0; i < dice.length - 1; i ++)
	  {
		  if(fixed[i] == 0)
		  {
			  dice[i] = rand.nextInt(mvalue);
		  }
		  
	  }
	  rolls ++;
    
  }

  /**
   * Selects a die value to be moved from the available dice to the
   * fixed dice. Has no effect if the given value is 
   * not among the values in the available dice. Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be moved from available to fixed
   */
  public void keep(int value)
  {
	  int i = 0;
	  
	  for(i = 0; i < dice.length - 1; i++)
	  {
		  if (dice[i] == value)
		  {
			  fixed[i] = 1;
		  }
	  }
  }

  /**
   * Selects a die value to be moved from the fixed dice to
   * the available dice, so it will be re-rolled in the
   * next call to <code>roll()</code>. Has no effect if the given value is 
   * not among the values in the fixed dice. Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be moved
   */
  public void free(int value)
  {
	  int i = 0;
	  
	  for(i = 0; i < dice.length - 1; i++)
	  {
		  if (dice[i] == value)
		  {
			  fixed[i] = 0;
		  }
	  }
  }
  
  /**
   * Causes all die values be moved from the available dice to the
   * fixed dice. Has no effect if
   * the number of rolls has reached the maximum.
   */
  public void keepAll()
  {
	  if(rolls >= mrolls)
	  {
		  int i = 0;
		    
		  for(i = 0; i < dice.length - 1; i ++)
		  {
			  fixed[i] = 1;
		  }
	  }
	  
  }
  
  /**
   * Causes all die values be moved from the fixed dice to the
   * available dice. Has no effect if
   * the number of rolls has reached the maximum.
   */
  public void freeAll()
  {
	  if(rolls < mrolls)
	  {
		  int i = 0;
		    
		  for(i = 0; i < dice.length - 1; i ++)
		  {
			  fixed[i] = 0;
		  }
	  }
  }
  
  /**
   * Determines whether there are any dice available to be 
   * rolled in this group.
   * @return
   *   true if there are no available dice, false otherwise
   */
  public boolean isComplete()
  {
    Boolean check = false;
    
    int i = 0; 
    for (i = 0; i < dice.length - 1; i++)
    {
    	if (fixed[i] == 0)
    	{
    		check = true;
    	}
    }
    return check;
  }

  /**
   * Returns the values of the dice that are currently fixed (not
   * available to be rerolled) in ascending order.
   * @return
   *   values of the dice that are currently fixed
   */
  public int[] getFixedDice()
  {
	  int[] gfix;
	  int num = 0;
	  int i = 0;
	  for (i = 0; i < dice.length - 1; i++)
	  {
		  if(fixed[i] == 1)
		  {
			  num++;
		  }
	  }
	  int k = 0;
	  gfix = new int[num];
	  for(i = 0; i < dice.length - 1; i++)
	  {
		  if(fixed[i] == 1)
		  {
			  gfix[k] = dice[i];
			  k++;
		  }
	  }
    // TODO
    return null;
  }
  
  /**
   * Returns the values of the dice that are currently available to
   * be rerolled by a subsequent call to <code>roll()</code>,
   * in ascending order.
   * @return
   *   dice that are available to be rerolled
   */
  public int[] getAvailableDice()
  {
    // TODO
    return null;
  }
 
  /**
   * Returns all die values in this group, in ascending order.
   * @return
   *   all die values in this group
   */
  public int[] getAll()
  {
    // TODO
    return null;
  }
  
  /**
   * Returns a string representation of the die values in
   * this hand, in the form <em>available</em>(<em>fixed</em>).
   * (For example, if there are two fixed dice with values 2
   * and 4, and there are 3 available dice with values 1, 1, and 6,
   * then the method returns the string
   * <pre>
   * 1 1 6 (2 4)
   * </pre>
   * If all dice are available, the parentheses should be empty.
   * @return 
   *   string representation of the available and completed dice,
   *   with the completed values in parentheses
   */
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    int[] availableDice = getAvailableDice();
    for (int value : availableDice)
    {
      sb.append(value + " ");
    }

    sb.append("(");
    int[] fixedDice = getFixedDice();
    if (fixedDice.length > 0)
    {
      // use an index so we can add the first one without a leading space
      sb.append(fixedDice[0]);
      for (int i = 1; i < fixedDice.length; ++i)
      {
        sb.append(" " + fixedDice[i]);
      }
    }
    sb.append(")");
    return sb.toString();
  } 
}
