package domain

import domain.status.Opened
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class MineMapTest : ShouldSpec({

    should("1보다 작은 높이와 너비를 입력하면 에러가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            MineMap(MineMapInfo(Point(1, 0), 0))
        }
        shouldThrow<IllegalArgumentException> {
            MineMap(MineMapInfo(Point(0, 1), 0))
        }
    }

    should("맵의 칸보다 더 많은 수의 지뢰를 입력하면 에러가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            MineMap(MineMapInfo(Point(2, 2), 5))
        }
    }

    context("10 X 10 map") {
        val point = Point(10, 10)
        should("MineMap은 높이와 너비를 가진다") {
            val mineMap = MineMap(MineMapInfo(point, 10))
            mineMap.height shouldBe 10
            mineMap.width shouldBe 10
        }

        should("MineMap에 지뢰 개수를 입력하면 입력한 수만큼의 지뢰가 있다") {
            val mineCount = 10
            val mineMap = MineMap(MineMapInfo(point, mineCount))
            var count = 0
            repeat(point.y) { y ->
                repeat(point.x) { x ->
                    if (mineMap.get(Point(y, x)).hasMine) {
                        count++
                    }
                }
            }

            count shouldBe mineCount
        }
    }

    context("고정된 맵을 생성 및 주입") {
        val point = Point(4, 3)
        val mineCount = 3
        val fixedMap =
            listOf(
                "0 1 0",
                "0 1 1",
                "0 0 0",
                "0 0 0"
            )

        should("좌표를 입력받아 해당 지점의 Spot을 오픈한다") {
            val mineMap = MineMap(MineMapInfo(point, mineCount), fixedMap.toArrayMap())
            mineMap.open(0, 1).shouldBeTypeOf<Opened.Mine>()
            mineMap.open(0, 0).shouldBeTypeOf<Opened.Two>()
            mineMap.open(0, 2).shouldBeTypeOf<Opened.Three>()
            mineMap.open(3, 0).shouldBeTypeOf<Opened.Zero>()
        }

        should("지뢰가 없는 칸을 오픈하면 인접한 다른 지뢰가 없는 칸이 모두 오픈된다") {
            val mineMap = MineMap(MineMapInfo(point, mineCount), fixedMap.toArrayMap())
            mineMap.open(3, 0).shouldBeTypeOf<Opened.Zero>()
            mineMap.isOpened(3, 1).shouldBeTrue()
            mineMap.isOpened(3, 2).shouldBeTrue()
            mineMap.isOpened(2, 0).shouldBeTrue()
            mineMap.isOpened(2, 1).shouldBeTrue()
            mineMap.isOpened(2, 2).shouldBeTrue()
            mineMap.isOpened(1, 0).shouldBeFalse()
            mineMap.isOpened(1, 1).shouldBeFalse()
            mineMap.isOpened(1, 2).shouldBeFalse()
        }

        should("지뢰가 있는 칸을 제외한 모든 칸이 열리면 게임이 종료된다") {
            val mineMap = MineMap(MineMapInfo(point, mineCount), fixedMap.toArrayMap())
            mineMap.open(0, 0)
            mineMap.open(0, 2)
            mineMap.open(1, 0)
            mineMap.open(3, 0)
            mineMap.isAllOpened().shouldBeTrue()
        }
    }
})
