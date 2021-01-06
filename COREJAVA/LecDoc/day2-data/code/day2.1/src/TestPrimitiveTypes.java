class TestPrimitiveTypes
{
  public static void main(String[] args)
  {
    byte b1=10;
    byte b2=12;
    byte b3=(byte)(b1+b2);//javac autmatically promotes any arithmetic operation on bytes to int
    System.out.println(b3);
  }
}