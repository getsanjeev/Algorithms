package sorting;

/**
 * Created by sanjeev on 21/12/16.
 */
public class quick_sort
{
    public static void main(String args [])
    {
        int [] array = utility.input_for_sorting();
        new quick_sort().quick_sorting(array,0,array.length-1);
        System.out.println("The sorted array is:" );
        utility.print_array(array);
    }

    public void quick_sorting(int [] array, int start, int end)
    {
        if(start<end)
        {
            int q = do_partition(array,start,end);
            quick_sorting(array,start,q-1);
            quick_sorting(array,q+1,end);
        }


    }
    public int do_partition(int [] array, int start, int end)
    {
        int i,temp;
        i=start-1;
        int key = array[end];
        System.out.println("start end " + start + " "+end);
        System.out.println("key is "+ key);
        for(int k = 0;k<end-start;k++)
        {

            if(array[start+k]<=key)
            {
                i++;
                System.out.println("value of i " + i);
                temp = array[i];
                array[i] = array[start+k];
                array[start+k] = temp;
            }
            utility.print_array(array);
        }
        array[end] = array[i+1];
        array[i+1] = key;
        System.out.println("returned value is: " + (i+1));
        return  i+1;
    }

}
