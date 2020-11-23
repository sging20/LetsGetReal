public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    numerator= nume;
    denominator = deno;
    if(deno == 0){
      numerator = 0;
      denominator = 1;
    }
    reduce();
    if (denominator < 0){
      numerator *= -1;
      denominator *= -1;
    }
  }
  public double getValue(){
    return (double) getNumerator() / getDenominator(); 
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return null;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return false;
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return "0";
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if(a < b){
      int c= b;
      b= a;
      a=c;
    }
    if(b== 0) return a;
    if(a % b == 0) return b;

    int remainder = a % b;
    while(remainder != 0) {
      remainder = a%b;
      a = b;
      b= remainder;
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
      int gcd= gcd(getNumerator(), getDenominator() );
      numerator= getNumerator() / gcd;
      denominator= getDenominator() / gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getNumerator(), getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
      return new RationalNumber(getNumerator()*other.getDenominator(), getDenominator()*other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getDenominator() + other.getNumerator()* getDenominator(), getDenominator()*other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getDenominator() - other.getNumerator()* getDenominator(), getDenominator()*other.getDenominator());
  }
}
