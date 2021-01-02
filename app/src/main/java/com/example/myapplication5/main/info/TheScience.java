package com.example.myapplication5.main.info;

public class TheScience  implements  Info{

    String header = "THE SCIENCE";

    String paragraph="Suspendisse odio neque, viverra quis maximus a, rhoncus at ligula. Proin iaculis tincidunt eros eget posuere. Fusce lacinia egestas vulputate. Praesent posuere justo eu maximus condimentum. Etiam ac magna ac ipsum fringilla lacinia vel molestie dui. Vivamus pretium urna quis arcu pretium, in imperdiet lectus euismod. Donec lobortis eget nisi vitae consequat. Aenean erat massa, facilisis eget mauris vel, finibus rhoncus arcu. In sollicitudin lacus et neque ullamcorper convallis. Nulla et mollis urna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam lacus orci, dignissim quis ex vel, rutrum eleifend ante.";
    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getParagraph() {
        return paragraph;
    }

    @Override
    public int[] getImages() {
        return new int[0];
    }
}
