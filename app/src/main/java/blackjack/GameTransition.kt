package blackjack

open class GameTransition(val game: Game) {
    open fun throwLoseDialog(): Boolean {
        return false
    }
}

class SettlementTransition(game: Game): GameTransition(game)
class DealTransition(game: Game): GameTransition(game)
class FlipTransition(game: Game): GameTransition(game)
class ResetTransition(game: Game): GameTransition(game)
class LoseTransition(game: Game): GameTransition(game) {
    override fun throwLoseDialog(): Boolean {
        return true
    }
}