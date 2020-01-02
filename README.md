# Poker hand evaluator

* Accepts two **Hands** in the form of 5 number, suite values separated by spaces.
    
    *Example*:
    * White: 2S 3D 4D 5D 6d
    * Black: AS KD qh 9c 10C

## Missing features

* Need a feature to map input card values to list of valid values with appropriate error response. This would eliminate the chance of impossible hands like below.

    *Example*:
    * White: AH AH AH AH AH
    * Black: AO AC AB AA 10W
        * Output: Black wins. - with four of a kind

## Potential concerns

 * Uncertainty with statement with regards to straights, from the Kata: "Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.". The above definition would have *White* win; I've made the judgement to make *Black* the winner in this case.

    *Example*:
    * White: AH 2D 3H 4H 5H
    * Black: 9C 10D JC QS KC
        * Output: Black wins. - with straight

* Only specific hands will show more information on the outcome of the winner versus loser: hands with no actual poker hands, and full houses.

    *Example 1*:
    * White: 2H 3D 9S 4C 6D
    * Black: 2h 3H 4S 8C KH
        * Black wins. - with high card: King

    *Example 2*:
    * White: 9h 9d 9s qS qd
    * Black: 4D 5D 5C 5S 4C
        * White wins. - with full house: 9 over 5
