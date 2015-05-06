using System;

namespace Algorithms.Heaps.Domain
{
    class MaxHeap<TValue> : Heap<TValue> where TValue : IComparable
    {
        protected override bool IfSwap(TValue parent, TValue child)
        {
            return parent.CompareTo(child) < 0;
        }
    }
}
