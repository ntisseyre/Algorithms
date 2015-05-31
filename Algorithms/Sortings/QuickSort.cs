using System;

namespace Algorithms.Sortings
{
    class QuickSort : IAlgorithm
    {
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var result = Algorithm(this.items, 0, this.items.Length - 1);

            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(int[] items, int left, int right)
        {
            int i = left;
            int j = right;

            // calculate pivot number, I am taking pivot as middle index number
            int pivot = items[left + (right - left) / 2];
            // Divide into two arrays
            while (i <= j)
            {
                /**
                 * In each iteration, we will identify a number from left side which
                 * is greater then the pivot value, and also we will identify a number
                 * from right side which is less then the pivot value. Once the search
                 * is done, then we exchange both numbers.
                 */
                while (items[i] < pivot) i++;
                while (items[j] > pivot) j--;

                if (i <= j)
                {
                    //swap
                    var tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;

                    //move index to next position on both sides
                    i++;
                    j--;
                }
            }

            // call quickSort() method recursively
            if (left < j)
                Algorithm(items, left, j);
            if (i < right)
                Algorithm(items, i, right);

            return items;
        }
    }
}
