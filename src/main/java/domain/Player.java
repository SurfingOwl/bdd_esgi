package domain;

import lombok.With;

public record Player(String name, @With ScoreEnum score) {

}
