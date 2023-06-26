Feature: Game Definition
# Trying definitions
  Scenario: Game on a Court between Player Rafael Nadal and Player Roger Federer in one set
    Given Court has two Player
    And Court has GameStatus ONGOING
    Then Player1 should have name RAFAEL
    Then Player1 should have score of LOVE
    Then Player2 should have name ROGER
    Then Player2 should have score of LOVE
    Then Court's player1 should be Player1
    Then Court's player2 should be Player2

  Scenario: Player 1 wins the game
    Given a tennis game
    When Player 1 scores "15"
    And Player 1 scores "30"
    And Player 1 scores "40"
    Then the score should be "40 - love"
    And the game should be "ENDED"
    And Player 1 should have won

  Scenario: Players are at deuce
    Given a tennis game
    When Player 1 scores "deuce"
    And Player 2 scores "deuce"
    Then the score should be "deuce - deuce"

  Scenario: Player 2 has advantage
    Given a tennis game
    When Player 1 scores "30"
    And Player 2 scores "40"
    Then the score should be "30 - 40"
    And the game should be "ONGOING"

  Scenario: Player 2 wins after advantage
    Given a tennis game
    When Player 1 scores "30"
    And Player 2 scores "40"
    And Player 1 scores "deuce"
    And Player 2 scores "advantage"
    And Player 2 scores "game"
    Then the score should be "deuce - game"
    And the game should be "ENDED"
    And Player 2 should have won
