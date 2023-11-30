package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class SpotTest : StringSpec({
    "Spot은 초기에 닫힌 상태이다" {
        val spot = Spot(false)
        spot.isOpen().shouldBeFalse()
    }

    "Spot을 열면 open 상태가 된다" {
        val spot = Spot(false)
        spot.open()
        spot.isOpen().shouldBeTrue()
    }

    "지뢰가 있는 Spot을 생성하면 지뢰가 있다" {
        val spot = Spot(true)
        spot.hasMine.shouldBeTrue()
    }

    "지뢰가 없는 Spot을 생성하면 지뢰가 없다" {
        val spot = Spot(false)
        spot.hasMine.shouldBeFalse()
    }
})
