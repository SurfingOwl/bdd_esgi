package com.esgi.bdd.features;

import com.esgi.bdd.domain.Court;
import com.esgi.bdd.domain.Game;
import com.esgi.bdd.domain.Player;
import com.esgi.bdd.domain.ScoreEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.val;
import org.junit.Assert;

import static com.esgi.bdd.domain.GameStatus.ONGOING;
import static com.esgi.bdd.domain.ScoreEnum.LOVE;

public class GameSteps {

    private Game game;

    @Given("a tennis game")
    public void createGame() {
        val roger = new Player("Roger", LOVE, false);
        val rafael = new Player("Rafael", LOVE, false);
        val court = new Court(roger, rafael, ONGOING);
        game = new Game(court);
    }

    @Given("a tennis game where Player {string} and Player {string} are at {string}")
    public void aTennisGameWherePlayerAndPlayerAreAt(String player1, String player2, String scores) {
        val roger = new Player(player1, ScoreEnum.valueOf(scores), false);
        val rafael = new Player(player2, ScoreEnum.valueOf(scores), false);
        val court = new Court(roger, rafael, ONGOING);
        game = new Game(court);
    }

    @Given("a tennis game where Player {string} has {string} and Player {string} has {string}")
    public void aTennisGameWherePlayerHasAndPlayerHas(String player1, String scoreP1, String player2, String scoreP2) {
        val roger = new Player(player1, ScoreEnum.valueOf(scoreP1), false);
        val rafael = new Player(player2, ScoreEnum.valueOf(scoreP2), false);
        val court = new Court(roger, rafael, ONGOING);
        game = new Game(court);
    }

    @When("Player {int} scores {string}")
    public void scorePoint(int playerNumber, String score) throws Exception {
        Player scorer = (playerNumber == 1) ? game.getCourt().player1() : game.getCourt().player2();
        Player adversary = (playerNumber == 1) ? game.getCourt().player2() : game.getCourt().player1();

        switch (score) {
            case "LOVE" -> game.scoreUp(scorer.withScore(ScoreEnum.LOVE), adversary);
            case "FIFTEEN" -> game.scoreUp(scorer.withScore(ScoreEnum.FIFTEEN), adversary);
            case "THIRTY" -> game.scoreUp(scorer.withScore(ScoreEnum.THIRTY), adversary);
            case "FORTY" -> game.scoreUp(scorer.withScore(ScoreEnum.FORTY), adversary);
            case "DEUCE" -> game.scoreUp(scorer.withScore(ScoreEnum.DEUCE), adversary);
            case "ADVANTAGE" -> game.scoreUp(scorer.withScore(ScoreEnum.ADVANTAGE), adversary);
        }
    }

    @Then("the score should be {string}")
    public void verifyScore(String expectedScore) {
        String actualScore = game.getCourt().player1().getScore() + " - " + game.getCourt().player2().getScore();
        Assert.assertEquals(expectedScore, actualScore);
    }

    @Then("the game should be {string}")
    public void verifyGameStatus(String expectedStatus) {
        String actualStatus = game.getCourt().getGameStatus().toString();
        Assert.assertEquals(expectedStatus, actualStatus);
    }

    @Then("Player {int} should have won")
    public void verifyPlayerWon(int playerNumber) {
        Player player = (playerNumber == 1) ? game.getCourt().player1() : game.getCourt().player2();
        Assert.assertTrue(player.isWon());
    }

    @When("Player {int} has {string}")
    public void playerHas(int playerNumber, String score) {
        Player player = playerNumber == 1 ? game.getCourt().player1() : game.getCourt().player2();
        Assert.assertEquals(ScoreEnum.valueOf(score), player.score());
    }
}
