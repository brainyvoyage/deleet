package com.brainyvoyage.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeWeightedDigraphTest {
    public static final String data = "8\n" +
            "15\n" +
            "4 5 0.35\n" +
            "5 4 0.35\n" +
            "4 7 0.37\n" +
            "5 7 0.28\n" +
            "7 5 0.28\n" +
            "5 1 0.32\n" +
            "0 4 0.38\n" +
            "0 2 0.26\n" +
            "7 3 0.39\n" +
            "1 3 0.29\n" +
            "2 7 0.34\n" +
            "6 2 0.40\n" +
            "3 6 0.52\n" +
            "6 0 0.58\n" +
            "6 4 0.93";

    public final static EdgeWeightedDigraph weightedDigraph;

    static {
        String[] graphData = data.split("\n");
        weightedDigraph = new EdgeWeightedDigraph(Integer.parseInt(graphData[0]));
        for(int i = 2; i < graphData.length; i++) {
            String[] edgeComponent = graphData[i].split(" ");
            DirectedEdge edge = new DirectedEdge(Integer.parseInt(edgeComponent[0]),
                    Integer.parseInt(edgeComponent[1]),
                    Double.parseDouble(edgeComponent[2])
            );
            weightedDigraph.addEdge(edge);
        }
    }

    @Test
    public void testToString(){
        System.out.println(weightedDigraph);
        assertEquals(weightedDigraph.toString(), "8 vertices, 15 edges\n" +
                "0: < 0 -> 2 : 0.26> < 0 -> 4 : 0.38> \n" +
                "1: < 1 -> 3 : 0.29> \n" +
                "2: < 2 -> 7 : 0.34> \n" +
                "3: < 3 -> 6 : 0.52> \n" +
                "4: < 4 -> 7 : 0.37> < 4 -> 5 : 0.35> \n" +
                "5: < 5 -> 1 : 0.32> < 5 -> 7 : 0.28> < 5 -> 4 : 0.35> \n" +
                "6: < 6 -> 4 : 0.93> < 6 -> 0 : 0.58> < 6 -> 2 : 0.40> \n" +
                "7: < 7 -> 3 : 0.39> < 7 -> 5 : 0.28> \n");
    }
}
