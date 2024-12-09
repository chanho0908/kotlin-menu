package menu.app.di

import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.usecase.CheckNotEatMenuUseCase
import menu.doamin.usecase.PickCategoryUseCase
import menu.doamin.usecase.RecommendMenuUseCase
import menu.presentation.controller.ViewController
import menu.presentation.view.InputView
import menu.presentation.view.OutputView
import menu.presentation.vm.ViewModel

class DependencyInjector {

    fun injectViewController(): ViewController {
        val inputView = injectInputView()
        val outputView = injectOutPutView()
        val viewModel = injectViewModel()
        return ViewController(inputView, outputView, viewModel)
    }

    private fun injectViewModel(): ViewModel {
        val checkCoachNameUseCase = CheckCoachNameUseCase()
        val checkNotEatMenuUseCase = CheckNotEatMenuUseCase()
        val pickCategoryUseCase = PickCategoryUseCase()
        val recommendMenuUseCase = RecommendMenuUseCase()
        return ViewModel(
            checkCoachNameUseCase,
            checkNotEatMenuUseCase,
            pickCategoryUseCase,
            recommendMenuUseCase
        )
    }

    private fun injectInputView() = InputView()
    private fun injectOutPutView() = OutputView()
}