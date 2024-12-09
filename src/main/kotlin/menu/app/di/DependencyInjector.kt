package menu.app.di

import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.usecase.CheckNotEatMenuUseCase
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
        return ViewModel(checkCoachNameUseCase, checkNotEatMenuUseCase)
    }

    private fun injectInputView() = InputView()
    private fun injectOutPutView() = OutputView()
}