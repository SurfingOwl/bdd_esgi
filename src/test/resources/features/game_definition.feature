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
