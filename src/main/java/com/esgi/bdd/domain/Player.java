package com.esgi.bdd.domain;

import lombok.With;

public record Player(String name, @With ScoreEnum score, @With boolean won) {
    public Object getScore() {
        return this.score;
    }

    public boolean isWon() {
        return this.won;
    }
}
