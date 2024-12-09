package menu.domain

import menu.doamin.rule.Exception
import menu.doamin.usecase.CheckNotEatMenuUseCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CheckNotEatMenuUseCaseTest {
    private lateinit var checkNotEatMenuUseCase : CheckNotEatMenuUseCase

    @BeforeEach
    fun setUp(){
        checkNotEatMenuUseCase = CheckNotEatMenuUseCase()
    }

    @Test
    fun `못 먹는 메뉴가 2개 초과일 때 에러 테스트`(){
        Assertions.assertThatThrownBy {
            checkNotEatMenuUseCase("오이,파프리카,시금치")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.INVALID_NOT_EAT_MENU_SIZE}")
    }

    @Test
    fun `못 먹는 메뉴가 중복일 때 에러 테스트`(){
        Assertions.assertThatThrownBy {
            checkNotEatMenuUseCase("오이,오이")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.DUPLICATE_NOT_EAT_MENU}")
    }
}