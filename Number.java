public abstract class Number{
  public abstract double getValue();
  /*return 0 when this Number equals the other Number
  return a negative value when this Number is smaller than the other Number
  return a positive value when this Number is larger than the other Number
  */
  public int compareTo(Number other){
    return (int) Math.round(getValue() - other.getValue());
  }

  /*
  *Return true when the % difference of the values
  *are within 0.00001 of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(Number other){
    if(getValue() == 0 || other.getValue()== 0){
      return getValue() == other.getValue();
    }
    return Math.abs((other.getValue() - getValue()) / getValue()) < 0.00001;
}
}
