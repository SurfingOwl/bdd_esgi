package com.esgi.bdd.domain.context;

import com.esgi.bdd.domain.Game;

public record TestContext(Game game) {

    public TestContext() {
        this(new Game());
    }
}
