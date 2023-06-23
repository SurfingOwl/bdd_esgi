package com.esgi.bdd;

import com.esgi.bdd.domain.Court;
import com.esgi.bdd.domain.Game;
import com.esgi.bdd.domain.Player;
import lombok.val;

import static com.esgi.bdd.domain.GameStatus.ONGOING;
import static com.esgi.bdd.domain.ScoreEnum.LOVE;

public class App {
    public static void main(String[] args) throws Exception {

        val roger = new Player("Roger", LOVE, false);
        val rafael = new Player("Rafael", LOVE, false);
        Game game = new Game(new Court(roger, rafael, ONGOING));

        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
        game.scoreUp(game.getCourt().player2(), game.getCourt().player1());
        System.out.println(game);
        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
        game.scoreUp(game.getCourt().player2(), game.getCourt().player1());
        System.out.println(game);
        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
        game.scoreUp(game.getCourt().player2(), game.getCourt().player1());
        System.out.println(game);
        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
        game.scoreUp(game.getCourt().player2(), game.getCourt().player1());
        System.out.println(game);
        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
        game.scoreUp(game.getCourt().player1(), game.getCourt().player2());
        System.out.println(game);
    }
}
