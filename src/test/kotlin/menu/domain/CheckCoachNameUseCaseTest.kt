package menu.domain

import org.assertj.core.api.Assertions
import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.rule.Exception
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CheckCoachNameUseCaseTest {
    private lateinit var checkCoachNameUseCase: CheckCoachNameUseCase

    @BeforeEach
    fun setUp(){
        checkCoachNameUseCase = CheckCoachNameUseCase()
    }

    @Test
    fun `입력값이 비어있을 때 예외 테스트`(){
        Assertions.assertThatThrownBy {
            checkCoachNameUseCase("  ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.EMPTY}")
    }

    @Test
    fun `코치 이름이 중복일 때 예외 테스트`(){
        Assertions.assertThatThrownBy {
            checkCoachNameUseCase("chan,ho,pob,pob")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.DUPLICATED_NAME}")
    }

    @ParameterizedTest
    @ValueSource(strings = ["poby;chan;ho", "ch@,ho;,co"])
    fun `코치 이름 입력 형식이 잘못되었을 때 테스트`(value: String){
        Assertions.assertThatThrownBy {
            checkCoachNameUseCase(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.INVALID}")
    }

    @ParameterizedTest
    @ValueSource(strings = ["poby,cha,a,a,b,c,d", "chan,poby,a,b,c,d"])
    fun `코치의 인원수가 잘못되었을 때 테스트`(value: String){
        Assertions.assertThatThrownBy {
            checkCoachNameUseCase(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.INVALID_SIZE}")
    }

    @ParameterizedTest
    @ValueSource(strings = ["poby,chaaaaaaa", "c,poby"])
    fun `코치의 이름 길이가 잘못되었을 때 테스트`(value: String){
        Assertions.assertThatThrownBy {
            checkCoachNameUseCase(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("${Exception.INVALID_RANGE}")
    }
}