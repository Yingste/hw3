package hw3;

/**
 * Scoring category for a "large straight".  A hand
 * with N dice satisfies this category only if there are
 * N distinct consecutive values.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class LargeStraight implements hw3.api.Category
{
  /**
   * Constructs a LargeStraight category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
  public LargeStraight(String displayName, int points)
  {
    // TODO
  }

@Override
public boolean isFilled() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int getScore() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Hand getHand() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getDisplayName() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void fill(Hand dice) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isSatisfiedBy(Hand dice) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public int getPotentialScore(Hand dice) {
	// TODO Auto-generated method stub
	return 0;
}
}
