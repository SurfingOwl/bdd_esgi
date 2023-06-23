package com.esgi.bdd.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.esgi.bdd.domain.ScoreEnum.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Court court;

    public void scoreUp(Player scorer, Player adversary) throws Exception {
        if (scorer.name().equals(court.player1().name())) {
            switch (scorer.score()) {
                case LOVE -> this.setCourt(court.withPlayer1(scorer.withScore(FIFTEEN)).withPlayer2(adversary));
                case FIFTEEN -> this.setCourt(court.withPlayer1(scorer.withScore(THIRTY)).withPlayer2(adversary));
                case THIRTY -> {
                    if (FORTY.equals(adversary.score())) {
                        this.setCourt(court.withPlayer1(scorer.withScore(DEUCE)).withPlayer2(adversary.withScore(DEUCE)));
                    } else {
                        this.setCourt(court.withPlayer1(scorer.withScore(FORTY)).withPlayer2(adversary));
                    }
                }
                case FORTY -> {
                    if (ADVANTAGE.equals(adversary.score())) {
                        this.setCourt(court.withPlayer1(scorer.withScore(DEUCE)).withPlayer2(adversary.withScore(DEUCE)));
                    } else {
                        this.setCourt(court.withGameStatus(GameStatus.ENDED).withPlayer1(scorer.withWon(true)).withPlayer2(adversary));
                    }
                }
                case DEUCE ->
                        this.setCourt(court.withPlayer1(scorer.withScore(ADVANTAGE)).withPlayer2(adversary.withScore(FORTY)));
                case ADVANTAGE ->
                        this.setCourt(court.withGameStatus(GameStatus.ENDED).withPlayer1(scorer.withWon(true)).withPlayer2(adversary));
                default -> throw new Exception("Unknown Error");
            }
        } else if (scorer.name().equals(court.player2().name())) {
            switch (scorer.score()) {
                case LOVE -> this.setCourt(court.withPlayer1(adversary).withPlayer2(scorer.withScore(FIFTEEN)));
                case FIFTEEN -> this.setCourt(court.withPlayer1(adversary).withPlayer2(scorer.withScore(THIRTY)));
                case THIRTY -> {
                    if (FORTY.equals(adversary.score())) {
                        this.setCourt(court.withPlayer1(scorer.withScore(DEUCE)).withPlayer2(adversary.withScore(DEUCE)));
                    } else {
                        this.setCourt(court.withPlayer1(adversary).withPlayer2(scorer.withScore(FORTY)));
                    }
                }
                case FORTY -> {
                    if (ADVANTAGE.equals(adversary.score())) {
                        this.setCourt(court.withPlayer1(adversary.withScore(DEUCE)).withPlayer2(scorer.withScore(DEUCE)));
                    } else {
                        this.setCourt(court.withGameStatus(GameStatus.ENDED).withPlayer1(adversary).withPlayer2(scorer.withWon(true)));
                    }
                }
                case DEUCE ->
                        this.setCourt(court.withPlayer1(adversary.withScore(FORTY)).withPlayer2(scorer.withScore(ADVANTAGE)));
                case ADVANTAGE ->
                        this.setCourt(court.withGameStatus(GameStatus.ENDED).withPlayer1(adversary).withPlayer2(scorer.withWon(true)));
                default -> throw new Exception("Unknown Error");
            }
        }
    }
}