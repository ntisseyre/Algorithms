using System;

namespace Algorithms.Lists.Domain
{
    class OneWayList<TData>
    {
        public TData Data { get; set; }

        public OneWayList<TData> Next { get; set; }

        public static OneWayList<TData> Create()
        {
            OneWayList<TData> head = null;
            OneWayList<TData> tmp = null;

            var input = IOHelper.ReadArray<TData>();
            if (input == null)
                return null;

            foreach (var item in input)
            {
                if (tmp == null)
                {
                    head = new OneWayList<TData> { Data = item };
                    tmp = head;
                }
                else
                {
                    var next = new OneWayList<TData> { Data = item };
                    tmp.Next = next;
                    tmp = next;
                }
            }

            return head;
        }

        public static void Print(OneWayList<TData> head)
        {
            Console.ForegroundColor = IOHelper.ColorResult;

            while (head != null)
            {
                Console.Write(string.Format("{0}{1}",
                    head.Data,
                    head.Next == null ? "" : " -> "));

                head = head.Next;
            }
        }
    }
}
