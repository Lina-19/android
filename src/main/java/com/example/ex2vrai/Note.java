package com.example.ex2vrai;

public class Note {
private String label;
private double score;

    public Note(String lebel,double score) {
        this.label = lebel;
        this.score=score;
    }

    public String getLebel() {
        return label;
    }

    public void setLebel(String lebel) {
        this.label = lebel;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
