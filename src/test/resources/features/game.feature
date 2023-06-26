Feature: Game Features

  Rule: When a player scores 40 and has 2 or more points over his adversary game should end and he should win
    Scenario: Player 1 wins the game
      Given a tennis game
      When Player 1 scores "FORTY"
      And Player 2 has "LOVE"
      Then the score should be "FORTY - LOVE"
      And the game should be "ENDED"
      And Player 1 should have won

  Rule: When a player scores 30 and his adversary has 40 both player's scores should be deuce
    Scenario: Players reach a deuce
      Given a tennis game
      When Player 1 scores "THIRTY"
      And Player 2 scores "THIRTY"
      Then the score should be "DEUCE - DEUCE"

  Rule: When a player scores while both players are at deuce player should have advantage
    Scenario: Player 2 gets the advantage
      Given a tennis game where Player "Raphael" and Player "Roger" are at "DEUCE"
      When Player 2 scores "DEUCE"
      Then the score should be "FORTY - ADVANTAGE"
      And the game should be "ONGOING"

  Rule: When player score while being at advantage player should win and game should end
    Scenario: Player 2 wins after advantage
      Given a tennis game where Player "Rapahel" has "FORTY" and Player "Roger" has "ADVANTAGE"
      When Player 2 scores "ADVANTAGE"
      Then the score should be "FORTY - ADVANTAGE"
      And the game should be "ENDED"
      And Player 2 should have won
