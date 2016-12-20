package sorting;

/**
 * Created by sanjeev on 19/12/16.
 */
public class insertion_sort
{
    public static void main(String args [])
    {
        int [] array = utility.input_for_sorting();
        new insertion_sort().insertion_sorting(array);
    }

    public void insertion_sorting(int [] array)
    {
        int key,j;
        for(int i = 1;i<array.length;i++)
        {
            key = array[i];
            j = i-1;
            while((j>=0)&&(key <array[j]))
            {
                System.out.println("abc");
                array[j+1] = array[j];
                utility.print_array(array);
                j--;
            }
            array[j+1] = key;
        }
        utility.print_array(array);
    }

}
