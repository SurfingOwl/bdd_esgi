package com.esgi.bdd.domain.features;

import com.esgi.bdd.domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.val;
import org.junit.Assert;

import static com.esgi.bdd.domain.GameStatus.ONGOING;
import static com.esgi.bdd.domain.ScoreEnum.LOVE;

public class GameSteps {
    private Court court;
    private Game game;
    private Player player1;
    private Player player2;

    @Given("a tennis game")
    public void createGame() {
        val roger = new Player("Roger", LOVE, false);
        val rafael = new Player("Rafael", LOVE, false);
        court = new Court(roger, rafael,ONGOING);
        game = new Game(court);
        player1 = game.getCourt().player1();
        player2 = game.getCourt().player2();
    }

    @When("Player {int} scores {string}")
    public void scorePoint(int playerNumber, String score) throws Exception {
        Player scorer = (playerNumber == 1) ? player1 : player2;
        Player adversary = (playerNumber == 1) ? player2 : player1;

        switch (score) {
            case "love" -> scorer.withScore(ScoreEnum.LOVE);
            case "15" -> scorer.withScore(ScoreEnum.FIFTEEN);
            case "30" -> scorer.withScore(ScoreEnum.THIRTY);
            case "40" -> scorer.withScore(ScoreEnum.FORTY);
            case "deuce" -> scorer.withScore(ScoreEnum.DEUCE);
            case "advantage" -> scorer.withScore(ScoreEnum.ADVANTAGE);
        }

        game.scoreUp(scorer, adversary);
    }

    @Then("the score should be {string}")
    public void verifyScore(String expectedScore) {
        String actualScore = game.getCourt().player1().getScore().toString() + " - " +
                game.getCourt().player2().getScore().toString();
        Assert.assertEquals(expectedScore, actualScore);
    }

    @Then("the game should be {string}")
    public void verifyGameStatus(String expectedStatus) {
        String actualStatus = game.getCourt().getGameStatus().toString();
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Then("Player {int} should have won")
    public void verifyPlayerWon(int playerNumber) {
        Player player = (playerNumber == 1) ? player1 : player2;
        Assert.assertTrue(player.isWon());
    }
}
