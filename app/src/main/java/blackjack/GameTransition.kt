package blackjack

open class GameTransition(val game: Game)

class SettlementTransition(game: Game): GameTransition(game)
class DealTransition(game: Game): GameTransition(game)
class FlipTransition(game: Game): GameTransition(game)
class ResetTransition(game: Game): GameTransition(game)