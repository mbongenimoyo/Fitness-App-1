package com.example.myapplication5.main.info;

public class WhatElse implements Info {
    String header = "WHAT ELSE SHOULD I BE DOING?";

    String paragraph="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur dignissim sapien, at eleifend turpis luctus id. Curabitur fermentum velit dolor, tempus fringilla nisl pulvinar sed. Quisque sit amet congue urna, a vehicula turpis. Aliquam pretium sit amet erat sit amet fringilla. Sed dignissim dictum velit et sollicitudin. Donec bibendum mattis ultrices. Vivamus magna massa, euismod accumsan venenatis ac, scelerisque et justo. Curabitur quis turpis in tellus sollicitudin laoreet.";


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
