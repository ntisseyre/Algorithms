using System;
using System.Collections.Generic;

namespace Algorithms.Arrays
{
    class IntersectTwoSortedArrays : IAlgorithm
    {
        private int[] firstItems;
        private int[] secondItems;

        public void ReadInput()
        {
            this.firstItems = IOHelper.ReadArray<int>();
            this.secondItems = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var result = Algorithm(this.firstItems, this.secondItems);

            Console.WriteLine();
            Console.ForegroundColor = IOHelper.InputColor;
            Console.WriteLine("Intersection result:");
            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static IList<int> Algorithm(int[] items1, int[] items2)
        {
            var i1 = 0;
            var i2 = 0;
            var result = new List<int>();

            while (i1 < items1.Length && i2 < items2.Length)
            {
                if (items1[i1] == items2[i2] && (i1 == 0 || items1[i1] != items1[i1 - 1]))
                {
                    result.Add(items1[i1]);

                    i1++; i2++;
                }
                else if (items1[i1] > items2[i2])
                {
                    i2++;
                }
                else
                {
                    i1++;
                }
            }

            return result;
        }
    }
}
