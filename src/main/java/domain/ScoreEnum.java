package domain;

import lombok.Getter;

@Getter
public enum ScoreEnum {
    LOVE("love"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    DEUCE("deuce"),
    ADVANTAGE("advantage");

    private final String score;

    ScoreEnum(String score) {
        this.score = score;
    }
}
