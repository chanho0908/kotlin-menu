package menu.presentation.controller

import menu.presentation.util.retryWhenNoException
import menu.presentation.view.InputView
import menu.presentation.view.OutputView
import menu.presentation.vm.ViewModel

class ViewController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val viewModel: ViewModel
) {
    init {
        checkUiEvent()
    }

    private fun checkUiEvent(){
        //when(val event = viewModel.state.uiEvent){
        //}
    }

    private fun onUiEventUserInput(msg: String){
        retryWhenNoException {
            outputView.printMessage(msg)
            val input = inputView.readItem()
            //viewModel.
        }
        checkUiEvent()
    }
}