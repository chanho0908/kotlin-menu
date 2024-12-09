package menu.presentation.controller

import menu.doamin.rule.Output
import menu.presentation.util.retryWhenNoException
import menu.presentation.view.InputView
import menu.presentation.view.OutputView
import menu.presentation.vm.ViewModel
import menu.presentation.vm.model.UiEvent

class ViewController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val viewModel: ViewModel
) {
    init {
        checkUiEvent()
    }

    private fun checkUiEvent() {
        when (val event = viewModel.state.uiEvent) {
            is UiEvent.OnUiEventUserInputCoachName -> onUiEventUserInputCoachName(event.msg)
            is UiEvent.OnUiEventUserInputNotEatMenu -> onUiEventUserInputNotEatMenu(event.msg)
            UiEvent.OnUiEventSetRecommendMenu -> onUiEventSetRecommendMenu()
        }
    }

    private fun onUiEventUserInputCoachName(msg: String) {
        outputView.printMessage(Output.WELCOME.toString())
        outputView.lineBreak()
        retryWhenNoException {
            outputView.printMessage(msg)
            val input = inputView.readItem()
            viewModel.onCompleteInputPurchasePrice(input)
        }
        checkUiEvent()
    }

    private fun onUiEventUserInputNotEatMenu(msg: List<String>) {
        msg.forEachIndexed{ i, v ->
            retryWhenNoException {
                outputView.lineBreak()
                outputView.printMessage(v)
                val input = inputView.readItem()
                viewModel.onCompleteInputNotEatMenu(input, i)
            }
        }
        viewModel.setUiEventToRecommendMenu()
        checkUiEvent()
    }

    private fun onUiEventSetRecommendMenu(){

    }
}