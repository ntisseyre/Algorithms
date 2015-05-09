using Algorithms.Heaps.Domain;
using System;
using System.Collections.Generic;

namespace Algorithms.Heaps
{
    class MergeSortedArrays : IAlgorithm
    {
        private IList<IList<int>> arrays;

        public void Execute()
        {
            var result = Algorithm(this.arrays);
            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        public void ReadInput()
        {
            Console.ForegroundColor = IOHelper.ColorInput;
            Console.WriteLine("Enter the number of arrays to merge:");
            var count = Int32.Parse(Console.ReadLine());

            this.arrays = new List<IList<int>>(count);

            for (int c = 0; c < count; c++)
            {
                var array = IOHelper.ReadArray<int>();
                this.arrays.Add(array);
            }
        }

        private static IList<int> Algorithm(IList<IList<int>> arrays)
        {
            var result = new List<int>();

            var minHeap = new MinHeap<ItemValueAndIndex>(); //A min heap to select the minimum from "to be merged array" 
            var arraysCurrentIndexes = new int[arrays.Count]; //An array that contains current index of each "to be merged array"

            //Init data structures with the first elements from each "to be merged array"
            for (int c = 0; c < arrays.Count; c++)
            {
                minHeap.Insert(new ItemValueAndIndex { Value = arrays[c][0], ArrayNum = c });
                arraysCurrentIndexes[c] = 1;
            }

            //Scan all  "to be merged array"
            // O(n log k): where
            //  n - the total number of elements in each "to be merged array"
            //  k - the number of arrays
            while (!minHeap.IsEmpty)
            {
                var item = minHeap.Peek(); // O(1)
                result.Add(item.Value);

                var arrayCurrentIndex = arraysCurrentIndexes[item.ArrayNum];
                if (arrayCurrentIndex < arrays[item.ArrayNum].Count)
                {
                    // O(logK)
                    minHeap.PeekAndReplace(new ItemValueAndIndex { Value = arrays[item.ArrayNum][arrayCurrentIndex], ArrayNum = item.ArrayNum });
                    arraysCurrentIndexes[item.ArrayNum]++;
                }
                else
                {
                    // O(logK)
                    minHeap.Extract(); //remove from heap
                }
            }

            return result;
        }

        class ItemValueAndIndex : IComparable
        {
            public int Value { get; set; }

            public int ArrayNum { get; set; }

            public int CompareTo(object obj)
            {
                return this.Value.CompareTo(((ItemValueAndIndex)obj).Value);
            }
        }
    }
}
