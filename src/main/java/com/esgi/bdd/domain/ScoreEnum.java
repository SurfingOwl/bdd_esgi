package com.esgi.bdd.domain;

import lombok.Getter;

@Getter
public enum ScoreEnum {
    LOVE("LOVE"),
    FIFTEEN("FIFTEEN"),
    THIRTY("THIRTY"),
    FORTY("FORTY"),
    DEUCE("DEUCE"),
    ADVANTAGE("ADVANTAGE");

    private final String score;

    ScoreEnum(String score) {
        this.score = score;
    }
}
