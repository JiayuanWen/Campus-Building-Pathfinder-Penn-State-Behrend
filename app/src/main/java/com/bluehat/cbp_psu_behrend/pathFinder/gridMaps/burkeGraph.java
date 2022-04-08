package com.bluehat.cbp_psu_behrend.pathFinder.gridMaps;

import android.widget.Button;
import android.widget.TextView;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

import javax.xml.transform.Source;

public class burkeGraph {
    public burkeGraph(int start, int end, Button text) {
        generatePath a = new generatePath(start, end, text);
    }
}

class Graph<T> {
    private Map<T, List<T> > map = new HashMap<>();
    private int startNode;
    private int endNode;
    private TextView path;

    public void addNewVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }

    Graph(int start, int end, TextView text) {
        startNode = start;
        endNode = end;
        path = text;
    }

    public void addEdge(T v, T w, boolean bidirectional)
    {

        if (!map.containsKey(v)) {
            addNewVertex(v);
        }
        if (!map.containsKey(w)) {
            addNewVertex(w);
        }
        map.get(v).add(w);
        if (bidirectional == true)
        {
            map.get(w).add(v);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet())
        {
            if (v.toString() == Integer.toString(startNode)) {
                builder.append(v.toString());
                for (T w : map.get(v))
                {
                    if (w.toString() != Integer.toString(endNode)) {
                        builder.append(" -> " + w.toString());
                    }
                    else {
                        builder.append(" -> " + w.toString());
                        break;
                    }
                }
                //builder.append("\n");
            }
        }
        return (builder.toString());
    }
}

class generatePath {

    public generatePath(int start, int end, Button text) {

        Graph g = new Graph(start, end, text);

        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 16, true);
        g.addEdge(3, 5, true);
        g.addEdge(3, 4, true);
        g.addEdge(3, 8, true);
        g.addEdge(4, 6, true);
        g.addEdge(3, 22, true);
        g.addEdge(3, 7, true);
        g.addEdge(8, 9, true);
        g.addEdge(8, 15, true);
        g.addEdge(8, 11, true);
        g.addEdge(8, 10, true);
        g.addEdge(8, 12, true);
        g.addEdge(11, 12, true);
        g.addEdge(10, 12, true);
        g.addEdge(10, 22, true);
        g.addEdge(22, 21, true);
        g.addEdge(22, 7, true);
        g.addEdge(9, 13, true);
        g.addEdge(14, 13, true);
        g.addEdge(9, 14, true);
        g.addEdge(16, 18, true);
        g.addEdge(16, 17, true);
        g.addEdge(16, 15, true);
        g.addEdge(16, 23, true);
        g.addEdge(16, 21, true);
        g.addEdge(20, 15, true);
        g.addEdge(19, 15, true);
        g.addEdge(24, 15, true);
        g.addEdge(11, 12, true);
        g.addEdge(10, 12, true);
        g.addEdge(10, 11, true);
        g.addEdge(5, 4, true);
        g.addEdge(19, 24, true);
        g.addEdge(20, 24, true);
        g.addEdge(19, 20, true);
        g.addEdge(17, 18, true);
        text.setText(g.toString());
    }
}

