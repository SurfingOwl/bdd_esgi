package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

import static domain.GameStatus.ENDED;
import static domain.ScoreEnum.*;

@Data
@AllArgsConstructor
public class Game {

    private Court court;

    public void scoreUp(Player player, Player adversary) throws Exception {
        switch (player.score()) {
            case LOVE -> this.setCourt(court.withPlayers(Map.of("p1", player.withScore(FIFTEEN), "p2", adversary)));
            case FIFTEEN -> this.setCourt(court.withPlayers(Map.of("p1", player.withScore(THIRTY), "p2", adversary)));
            case THIRTY -> this.setCourt(court.withPlayers(Map.of("p1", player.withScore(FORTY), "p2", adversary)));
            case FORTY -> {
                if (FORTY.equals(adversary.score())) {
                    this.setCourt(court.withPlayers(Map.of("p1", player.withScore(DEUCE), "p2", adversary.withScore(DEUCE))));
                } else {
                    this.setCourt(court.withGameStatus(ENDED));
                }
            }
            case DEUCE ->
                    this.setCourt(court.withPlayers(Map.of("p1", player.withScore(ADVANTAGE), "p2", adversary.withScore(FORTY))));
            case ADVANTAGE -> this.setCourt(court.withGameStatus(ENDED));
            default -> throw new Exception("Unknown Error");
        }
    }
}
