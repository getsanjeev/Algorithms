package sorting;

/**
 * Created by sanjeev on 4/2/17.
 */
public class huffman
{
    public static void main(String [] args)
    {
        System.out.println("Welcome to Huffman");
        int [] array = utility.input_for_sorting();
        new huffman().get_huffman_codes(array);
        //utility.print_array(array);
    }

    int [] get_huffman_codes(int [] array)
    {
        int min1,min2,sum;
        boolean first = true;
        build_min_heap(array);
        System.out.println("The min heap is: ");
        utility.print_array(array);
        min1 = extract_min(array,true);
        first = false;
        min2 = extract_min(array,first);
        sum = min1+min2;
        insert(array,sum);
        utility.print_array(array);
        for(int i =1;i<array.length-1;i++)
        {
            min1 = extract_min(array,first);
            min2 = extract_min(array,first);
            sum = min1+min2;
            insert(array,sum);
            utility.print_array(array);
        }
        return array;
    }

    void insert(int [] array, int value)
    {
        int temp;
        int index = array[array.length -1];
        index++;
        array[index] = value;
        array[array.length -1]++;
        int parent = index;
        while(parent>0)
        {
            if (index%2==0) parent = (index -2)/2;
            else parent = (index-1)/2;
            //System.out.println("parent " + parent);
            if(array[parent] > array[index])
            {
                temp = array[parent];
                array[parent] = array[index];
                array[index] = temp;
                index = parent;
            }
            else break;
        }
    }

    int extract_min(int [] array, boolean first)
    {
        //System.out.println("PRINTING IN EXTRACT MIN");
        int temp = array[0];
        if(first)
        {
            array[0] = array[array.length-1];
            array[array.length -1] = array.length -2;
        }
        else
        {
            array[0] = array[array[array.length-1]];
          //  System.out.println(array[array.length-1] + "index prv for min haeaify");
            array[array.length-1] --;
            //System.out.println(array[array.length-1] + "index for min haeaify");
        }
        min_heapify(array,0,array[array.length-1]);
        return temp;
    }

    public void min_heapify(int [] array,int i, int j)
    {
        //System.out.println("incoming value " + i + " " + j);
        int min_index ;
        int left = 2*i+1;
        //System.out.println(left + "left" + (array.length - j));
        int right = 2*i+2;
        //System.out.println(right + "right" + (array.length - j));
        if(left <= j)
        {
            if(right <= j)
            {
                if(array[left] < array[right])  min_index = left;
                else min_index = right;
                if((array[i] < array[min_index])) min_index = i;
            }
            else
            {
                if (array[i] > array[left])
                min_index = left;
                else min_index = i;
            }
          //  System.out.println("values" + min_index + " " + i);
            if(min_index!=i)
            {
          //      System.out.println("in the not equal loop");
                int temp = array[i];
                array[i] = array[min_index];
                array[min_index] = temp;
                min_heapify(array,min_index,j);
            }
        }

    }

    public void min_heapify(int [] array,int i)
    {
        int min_index ;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < array.length)
        {
            if(right < array.length)
            {
                if(array[left] < array[right])  min_index = left;
                else min_index = right;
                if((array[i] < array[min_index])) min_index = i;
            }
            else
            {
                min_index = left;
            }
            if(min_index!=i)
            {
                int temp = array[i];
                array[i] = array[min_index];
                array[min_index] = temp;
                min_heapify(array,min_index);
            }
        }
    }

    public void build_min_heap(int [] array)
    {
        for(int i= (array.length/2) - 1;i>=0;i--)
        {
            min_heapify(array,i);
        }
    }


}
