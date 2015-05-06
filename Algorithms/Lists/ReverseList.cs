using Algorithms.Core;
using Algorithms.Lists.Domain;
using System;

namespace Algorithms.Lists
{
    class ReverseList : IAlgorithm
    {
        private OneWayList<int> list = null;

        public void Execute()
        {
            var head = Algorithm(this.list);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine("Reversed:");
            Console.WriteLine();
            OneWayList<int>.Print(head);
            Console.WriteLine();
            Console.WriteLine();
        }

        public void ReadInput()
        {
            this.list = OneWayList<int>.Create();
            Console.WriteLine();
        }

        private OneWayList<int> Algorithm(OneWayList<int> list)
        {
            OneWayList<int> tmp = null;
            var first = list;
            var second = list.Next;
            first.Next = tmp;

            while (second != null)
            {
                //Move pointers
                tmp = second.Next;
                second.Next = first;

                //Shift cursors
                first = second;
                second = tmp;
            }

            return first;
        }
    }
}
