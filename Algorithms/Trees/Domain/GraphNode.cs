using System.Collections.Generic;

namespace Algorithms.Trees.Domain
{
    class GraphNode<TData>
    {
        public TData Data { get; set; }

        public State State { get; set; }

        public IList<GraphNode<TData>> AdjacentNodes { get; set; }
    }

    enum State
    {
        Unvisited = 0,
        Visiting,
        Visited
    }
}
