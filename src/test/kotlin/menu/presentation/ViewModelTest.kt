package menu.presentation

import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.usecase.CheckNotEatMenuUseCase
import menu.doamin.usecase.PickCategoryUseCase
import menu.doamin.usecase.RecommendMenuUseCase
import menu.presentation.vm.ViewModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ViewModelTest {
    private lateinit var viewModel: ViewModel

    @BeforeEach
    fun setUp(){
        viewModel = ViewModel(
            CheckCoachNameUseCase(),
            CheckNotEatMenuUseCase(),
            PickCategoryUseCase(),
            RecommendMenuUseCase()
        )
    }

    @Test
    fun `카테고리를 최대 2번까지만 선택하는지 테스트`(){
        viewModel.setUiEventToRecommendMenu()
        val expected = viewModel.state.category.groupingBy { it }.eachCount().values.none { it > 2 }
        Assertions.assertTrue(expected)
    }
}