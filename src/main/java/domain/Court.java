package domain;

import lombok.With;

import java.util.Map;

public record Court(@With Map<String, Player> players, @With GameStatus gameStatus) {
}
