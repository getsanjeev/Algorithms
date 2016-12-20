package sorting;

import java.util.Scanner;

/**
 * Created by sanjeev on 19/12/16.
 */
public class utility
{
    public static void print_array(int [] array)
    {
        for(int i= 0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


    public static void print_array(String [] array)
    {
        for(int i= 0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }

    public static int [] input_for_sorting()
    {
        System.out.println("Enter the size of array.");
        Scanner alpha = new Scanner(System.in);
        int size = alpha.nextInt();
        int [] array = new int [size];
        System.out.println("Enter the numbers.");
        for(int i = 0;i<size;i++)
        {
            array[i] = alpha.nextInt();
        }
        return array;
    }
}
