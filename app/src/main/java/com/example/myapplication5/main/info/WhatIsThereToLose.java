package com.example.myapplication5.main.info;

public class WhatIsThereToLose  implements Info{


    String header = "WHAT IS THERE TO LOSE";

    String paragraph="n nec tincidunt ligula. Nulla non turpis cursus, pulvinar magna non, rhoncus augue. Curabitur ac ligula a mauris cursus congue in a est. Integer turpis quam, malesuada quis ligula venenatis, dictum porttitor felis. Phasellus mi sem, congue non eleifend id, pulvinar ut nunc. Sed nunc augue, porta ut lacinia sed, laoreet a elit. Mauris felis tortor, congue vitae felis et, suscipit maximus sem. Ut efficitur, augue at finibus suscipit, tellus orci vestibulum magna, a aliquam mi quam eget tellus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi non enim ligula. Phasellus a dui elementum, sodales dolor et, convallis lorem. Nam finibus lorem et augue lacinia porta. Phasellus ut rhoncus dolor, ut sollicitudin libero. Praesent maximus eros enim, quis rutrum lorem posuere vitae. Cras massa ipsum, vulputate eget sem at, tempus condimentum urna.\n" +
            "\n" +
            "Nulla urna arcu, hendrerit ut metus vel, lobortis vulputate risus. Ut ultrices ullamcorper purus ac rutrum. Donec in augue velit. Integer bibendum et erat vitae congue. Praesent egestas blandit euismod. Cras sed enim maximus, vulputate est non, hendrerit neque. Praesent vitae iaculis nisi. Fusce vel maximus orci. Integer luctus magna ipsum, ac pulvinar tortor interdum id. Donec arcu orci, vestibulum a elementum ultricies, lobortis a sapien. Nunc ut ligula porttitor, pellentesque risus placerat, viverra dui. Curabitur dapibus eu mauris at malesuada. Pellentesque ultricies consequat viverra.";
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
