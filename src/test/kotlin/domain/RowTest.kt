package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RowTest {

    private val sampleList = listOf(1, 2, 3, 4, 5)
    private val row = Row(sampleList)

    @Test
    fun `Row의 크기를 가져온다`() {
        assertThat(row.size()).isEqualTo(5)
    }

    @Test
    fun `Row의 특정 위치의 값을 가져온다`() {
        val index = (0 until row.size()).random()
        assertThat(row[index]).isEqualTo(sampleList[index])
    }

    @Test
    fun `Row의 범위를 가져온다`() {
        assertThat(row.indices()).isEqualTo(0 until row.size())
    }

    @Test
    fun `범위를 넘어선 Row의 값을 가져오면 null을 반환한다`() {
        assertThat(row.getOrNull(-1)).isNull()
        assertThat(row.getOrNull(row.size())).isNull()
    }

    @Test
    fun `첫번째 값을 가져온다`() {
        assertThat(row.first()).isEqualTo(1)
    }
}