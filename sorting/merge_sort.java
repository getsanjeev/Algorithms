package sorting;

public class merge_sort
{
    public static void main(String args[])
    {
        // driver function
        int [] array = utility.input_for_sorting();
        new merge_sort().merge_sorting(array,0,array.length-1);
        System.out.println("The sorted array is: ");
        utility.print_array(array);
    }

    public void merge_sorting(int [] array, int start, int end)
    {
        if(start<end)
        {
            int mid = (start+end)/2;
            merge_sorting(array, start,mid);
            merge_sorting(array,mid+1,end);
            merge(array, start, mid,end);
        }
    }

    public void merge(int [] array, int start, int mid, int end)
    {
        int n1 = mid-start+1;
        int n2 = end-mid;

        int [] array1 = new int [n1+1];
        int [] array2 = new int [n2+1];

        array1[mid-start+1] = 10000;
        array2[end-mid] = 10000;

        int i,j,p;
        i =0;j=0;p=0;

        //copying the content of array in two sub arrays
        for(int k=0;k<n1;k++)
        {
            array1[p] = array[start+k];
            p++;
        }
        p = 0;
        for(int k=0;k<n2;k++)
        {
            array2[p] = array[k+mid+1];
            p++;
        }

        //merging the two arrays
        for(int k=0;k<end-start+1;k++)
        {
            if(array1[i]>array2[j])
            {
                array[start+k] = array2[j];
                j++;
            }
            else
            {
                array[start+k] = array1[i];
                i++;
            }
        }
    }
}
