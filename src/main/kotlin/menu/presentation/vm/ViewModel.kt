package menu.presentation.vm

import menu.presentation.vm.model.State

class ViewModel {
    private val _state = State.create()
    val state get() = _state

    fun onCompleteInputPurchasePrice(input: String){

    }
}