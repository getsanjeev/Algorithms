package sorting;

/**
 * Created by sanjeev on 21/12/16.
 */
public class heap_sort
{
    public static void main(String [] args)
    {
        int [] array = utility.input_for_sorting();
        new heap_sort().max_heapify(array);
    }

    public void max_heapify(int [] array)
    {
        int left,right,max,index;
        int no_of_nodes = array.length;
        int start_index_leaf = (no_of_nodes/2);
        for(int i = start_index_leaf-1;i>=0;i--)
        {
            left = array[2*i+1];

            if((2*i+2)<array.length)
            {
                right = array[2*i+2];
                if(left>right)
                {
                    max = left;
                    index = 2*i+1;
                }
                else
                {
                    max = right;
                    index = 2*i+2;
                }
            }
            else
            {
                max = left;
                index = 2*i+1;
            }
            if(max>array[i]) swap(array,index,i);
        }

    }
    public void swap(int [] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
