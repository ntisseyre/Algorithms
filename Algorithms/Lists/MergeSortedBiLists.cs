using Algorithms.Lists.Domain;
using System;

namespace Algorithms.Lists
{
    class MergeSortedBiLists : IAlgorithm
    {
        private TwoWayList<int> first = null;
        private TwoWayList<int> second = null;

        public void Execute()
        {
            var result = Algorithm(this.first, this.second);

            Console.ForegroundColor = IOHelper.ColorResult;
            Console.WriteLine("Merged result:");

            TwoWayList<int>.Print(result);

            Console.WriteLine();
            Console.WriteLine();
        }

        public void ReadInput()
        {
            this.first = TwoWayList<int>.Create();
            this.second = TwoWayList<int>.Create();

            Console.WriteLine();
        }

        private static TwoWayList<int> Algorithm(TwoWayList<int> first, TwoWayList<int> second)
        {
            TwoWayList<int> result = null;
            TwoWayList<int> prev = null;

            if (first == null)
                return second;

            if (second == null)
                return first;

            while (first != null && second != null)
            {
                if (first.Data < second.Data)
                    MoveNext(ref result, ref prev, ref first);
                else
                    MoveNext(ref result, ref prev, ref second);
            }

            if (second != null)
            {
                prev.Next = second;
                second.Previous = prev;
            }

            if (first != null)
            {
                prev.Next = first;
                first.Previous = prev;
            }

            return result;
        }

        private static void MoveNext(ref TwoWayList<int> result, ref TwoWayList<int> prev, ref TwoWayList<int> current)
        {
            if (result == null)
                result = current;

            if (prev != null)
            {
                prev.Next = current;
                current.Previous = prev;
            }

            prev = current;
            current = current.Next;
        }
    }
}
