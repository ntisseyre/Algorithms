using System;

namespace Algorithms.Lists.Domain
{
    class TwoWayList<TData>
    {
        public TData Data { get; set; }

        public TwoWayList<TData> Next { get; set; }

        public TwoWayList<TData> Previous { get; set; }

        public static TwoWayList<TData> Create()
        {
            TwoWayList<TData> head = null;
            TwoWayList<TData> tmp = null;

            var input = IOHelper.ReadArray<TData>();
            if (input == null)
                return null;

            foreach (var item in input)
            {
                if (tmp == null)
                {
                    head = new TwoWayList<TData> { Data = item };
                    tmp = head;
                }
                else
                {
                    var next = new TwoWayList<TData> { Data = item, Previous = tmp };
                    tmp.Next = next;
                    tmp = next;
                }
            }

            return head;
        }

        public static void Print(TwoWayList<TData> head)
        {
            TwoWayList<TData> tail = null;

            while (head != null)
            {
                Console.Write(string.Format("{0}{1}",
                    head.Data,
                    head.Next == null ? "" : " -> "));

                tail = head;
                head = head.Next;
            }

            Console.WriteLine();
            Console.WriteLine("------ Reverse ------");

            while (tail != null)
            {
                Console.Write(string.Format("{0}{1}",
                    tail.Data,
                    tail.Previous == null ? "" : " -> "));

                tail = tail.Previous;
            }
        }
    }
}
