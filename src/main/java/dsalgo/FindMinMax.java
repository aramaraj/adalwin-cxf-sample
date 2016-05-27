package dsalgo;
public class FindMinMax
{

 public static void main(String[] args)
 {
  int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11,12};
  int max = arr[0];
  int min = arr[0];
  int i = 0;
  for (; i < arr.length / 2; i++){
   int num1 = arr[i * 2];
   int num2 = arr[i * 2 + 1];
   if (arr[i * 2] >= arr[i * 2 + 1])
   {
    if (num1 > max)
     max = num1;
    if (num2 < min)
     min = num2;
   }
   else
   {
    if (num2 > max)
     max = num2;
    if (num1 < min)
     min = num1;
   }
   System.out.println("i= " + i);
   System.out.println("num1= " + num1);
   System.out.println("num2= " + num2);
   System.out.println("max= " + max);
   System.out.println("min= " + min);
   
   
  }
  if (i * 2 < arr.length){
	  System.out.println("inside the loop= " + arr.length+"--"+i * 2);
	  
   int num = arr[i * 2];
   
   if (num > max)
    max = num;
   if (num < min)
    min = num;
  }
  
  System.out.println("maximum= " + max);
  System.out.println("minimum= " + min);
 }

}
        