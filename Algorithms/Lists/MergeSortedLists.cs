using Algorithms.Lists.Domain;
using System;

namespace Algorithms.Lists
{
    class MergeSortedLists : IAlgorithm
    {
        private OneWayList<int> first = null;
        private OneWayList<int> second = null;

        public void ReadInput()
        {
            this.first = OneWayList<int>.Create();
            this.second = OneWayList<int>.Create();

            Console.WriteLine();
        }

        public void Execute()
        {
            var result = Algorithm(this.first, this.second);

            Console.ForegroundColor = IOHelper.ColorResult;
            Console.WriteLine("Merged result:");
            
            OneWayList<int>.Print(result);

            Console.WriteLine();
            Console.WriteLine();
        }

        private static OneWayList<int> Algorithm(OneWayList<int> first, OneWayList<int> second)
        {
            OneWayList<int> result = null;
            OneWayList<int> prev = null;

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
                prev.Next = second;

            if (first != null)
                prev.Next = first;

            return result;
        }

        private static void MoveNext(ref OneWayList<int> result, ref OneWayList<int> prev, ref OneWayList<int> current)
        {
            if (result == null)
                result = current;

            if (prev != null)
                prev.Next = current;

            prev = current;
            current = current.Next;
        }
    }
}
