import domain.Court;
import domain.Game;
import domain.Player;
import lombok.val;

import java.util.Map;

import static domain.GameStatus.ENDED;
import static domain.GameStatus.ONGOING;
import static domain.ScoreEnum.LOVE;

public class App {
    public static void main(String[] args) throws Exception {

        val roger = new Player("Roger", LOVE);
        val rafael = new Player("Rafael", LOVE);
        Game game = new Game(new Court(Map.of("p1", roger, "p2", rafael), ONGOING));

        while (!ENDED.equals(game.getCourt().gameStatus())) {
            game.scoreUp(game.getCourt().players().get("p1"), game.getCourt().players().get("p2"));
            System.out.println(game);
        }
    }
}
