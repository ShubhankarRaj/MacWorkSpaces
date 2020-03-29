package Assignment3;


public class ArraysMergeSort {
	String[] Array1  = new String[]{"Raj","Aman","John","Ravi","Sam","Gauri", "Deepti","kangana", "Era", "Divya"};
	String[] Array2 = new String[]{"Swati","Soumya","Anuj","Shashi","Milky","Anmol","Mehak", "Komal", "Sharmila", "Marry", "Shubhankar", "Swapnil", "Priyanka", "Tanisha", "Yash"};
	
	int length;
	
	int Clength = (Array1.length) + (Array2.length);
	String[] C = new String[Clength];
	int tempArrlength = Clength;
	String[] tempArr = new String[tempArrlength];
	void merge()
	{
		int j = 0;
		for(int i=0; i<Clength; i++)
		{
			if (i<10)
			{
				C[i] = Array1[i];
			}
			else
			{
				C[i] = Array2[j];
				j++;
			}
			
		}
		doMergeSort(0, Clength-1);
		for(int i=0; i<Clength; i++)
		{
			System.out.println(C[i]+  " ");
		}
	}

	public void doMergeSort(int lowerIndex, int higherIndex) 
	{ //System.out.println(higherIndex);
		if (lowerIndex < higherIndex) 
		{
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	public void mergeParts(int lowerIndex, int middle, int higherIndex)
	{
		for (int i = lowerIndex; i <= higherIndex; i++) 
		{
			tempArr[i] = C[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex)
		{
			if (tempArr[i].compareTo(tempArr[j])<0)

			{
				System.out.println(tempArr[i]);
				C[k] = tempArr[i];
				i++;
			} else {
				C[k] = tempArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle)
		{
			C[k] = tempArr[i];
			k++;
			i++;
		}

	}
	public static void main(String[] args)
	{
		ArraysMergeSort obj = new ArraysMergeSort();
		obj.merge();
		
	}
}

