package menu.domain

import menu.doamin.usecase.PickCategoryUseCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PickCategoryUseCaseTest {
    private lateinit var pickCategoryUseCase: PickCategoryUseCase

    @BeforeEach
    fun setUp(){
        pickCategoryUseCase = PickCategoryUseCase()
    }

    @Test
    fun `한식_중식_아시안_양식을 2회먹으면 일식을 반환한다`(){
        val category = pickCategoryUseCase(
            listOf(2,2,3,3,4,4,5,5)
        )
        Assertions.assertEquals(category, 1)
    }

    @Test
    fun `한식_중식_양식_일식을 2회먹으면 아시안을 반환한다`(){
        val category = pickCategoryUseCase(
            listOf(2,2,3,3,5,5,1,1)
        )
        Assertions.assertEquals(category, 4)
    }
}