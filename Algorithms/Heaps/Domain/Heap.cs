using System.Collections.Generic;

namespace Algorithms.Heaps.Domain
{
    abstract class Heap<TValue>
    {
        private const string YES = "yes";

        private IList<TValue> items;

        public Heap()
        {
            this.items = new List<TValue>();
        }

        public TValue Peek()
        {
            return this.items[0];
        }

        public bool IsEmpty
        {
            get { return this.items.Count == 0; }
        }

        public void ReadFromInput()
        {
            foreach (var item in IOHelper.ReadArray<TValue>())
                this.Insert(item);
        }

        public void Print()
        {
            IOHelper.PrintArray(this.items);
        }

        public TValue Extract()
        {
            var result = this.items[0];

            this.items[0] = this.items[this.items.Count - 1];
            this.items.RemoveAt(this.items.Count - 1);

            this.Heapify(0);

            return result;
        }

        public TValue PeekAndReplace(TValue newValue)
        {
            var result = this.items[0];

            this.items[0] = newValue;
            this.Heapify(0);

            return result;
        }

        public void Insert(TValue item)
        {
            int index = this.items.Count;
            this.items.Add(item);

            while (index > 0)
            {
                var parentIndex = GetParentIndex(index);
                var parent = this.items[parentIndex];

                //Check elements
                if (!this.IfSwap(parent, item))
                    break;

                //Swap elements
                this.items[index] = parent;
                this.items[parentIndex] = item;

                index = parentIndex;
            }
        }

        protected abstract bool IfSwap(TValue parent, TValue child);

        private int GetParentIndex(int itemIndex)
        {
            var parentIndex = itemIndex >> 1;

            if ((itemIndex & 1) == 0)
                parentIndex--;

            return parentIndex;
        }

        private void Heapify(int itemIndex)
        {
            int swapIndex = itemIndex;
            var rightChildIndex = (itemIndex + 1) << 1;
            var leftChildIndex = rightChildIndex - 1;

            //Check if we need to swap a parent with left or right child
            if (leftChildIndex < this.items.Count &&
                this.IfSwap(this.items[itemIndex], this.items[leftChildIndex]))
            {
                swapIndex = leftChildIndex;
            }

            if (rightChildIndex < this.items.Count &&
                this.IfSwap(this.items[swapIndex], this.items[rightChildIndex]))
            {
                swapIndex = rightChildIndex;
            }

            //If we need to swap -> do it and keep checking down the tree
            if (swapIndex != itemIndex)
            {
                var tmp = this.items[itemIndex];
                this.items[itemIndex] = this.items[swapIndex];
                this.items[swapIndex] = tmp;
                this.Heapify(swapIndex);
            }
        }
    }
}
