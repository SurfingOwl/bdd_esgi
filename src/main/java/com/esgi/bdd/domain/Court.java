package com.esgi.bdd.domain;

import lombok.With;

public record Court(@With Player player1, @With Player player2, @With GameStatus gameStatus) {
    public Object getGameStatus() {
        return  this.gameStatus;
    }
}
