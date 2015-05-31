using System;

namespace Algorithms.Sortings
{
    class MergeSort : IAlgorithm
    {
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var tmpMergArr = new int[items.Length];
            var result = Algorithm(this.items, tmpMergArr, 0, this.items.Length - 1);

            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(int[] items, int[] tmpMergArr, int left, int right)
        {
            if (left >= right)
                return items;

            int middle = left + ((right - left) >> 1);
            // Below step sorts the left side of the array
            Algorithm(items, tmpMergArr, left, middle);
            // Below step sorts the right side of the array
            Algorithm(items, tmpMergArr, middle + 1, right);

            // Now merge both sides
            MergeParts(items, tmpMergArr, left, middle, right);

            return items;
        }

        private static void MergeParts(int[] items, int[] tmpMergArr, int left, int middle, int right)
        {
            for (var c = left; c <= right; c++)
                tmpMergArr[c] = items[c];

            int i = left;
            int k = left;
            int j = middle + 1;
            
            while (i <= middle && j <= right)
            {
                if (tmpMergArr[i] <= tmpMergArr[j])
                {
                    items[k++] = tmpMergArr[i++];
                }
                else
                {
                    items[k++] = tmpMergArr[j++];
                }
            }

            while (i <= middle)
            {
                items[k++] = tmpMergArr[i++];
            }
        }
    }
}
