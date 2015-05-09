using Algorithms.Heaps.Domain;
using System;

namespace Algorithms.Heaps
{
    class KIncreaseDecreaseArray
    {
        private int intervalsNum;
        private int[] items;

        public void ReadInput()
        {
            Console.ForegroundColor = IOHelper.ColorInput;
            Console.WriteLine("Enter the decrease/increase intervals number: ");
            this.intervalsNum = Int32.Parse(Console.ReadLine());

            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            if (this.items.Length < this.intervalsNum)
            {
                Console.ForegroundColor = IOHelper.ColorError;
                Console.WriteLine("Number of elements must be greater or equal to the intervals' number");
                Console.WriteLine();
                return;
            }

            var result = Algorithm(this.intervalsNum, this.items);

            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(int k, int[] items)
        {
            var maxHeap = new MaxHeap<int>();
            var result = new int[items.Length];
            int itemsInInterval = items.Length / k; //Items count must be greater or equal to k

            int c = 0;
            for (; c < k; c++)
            {
                maxHeap.Insert(items[c]);
            }

            c = 0;
            int itemNum = 0;
            bool isIncrease = true;

            while (!maxHeap.IsEmpty)
            {
                if (isIncrease)
                {
                    result[c++] = maxHeap.Extract();
                }

                if (++itemNum == itemsInInterval)
                {
                    itemNum = 0;
                    isIncrease = !isIncrease;
                }
            }

            return result;
        }
    }
}
