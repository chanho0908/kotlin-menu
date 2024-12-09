package menu.presentation.vm.model

data class State(
    val uiEvent: UiEvent
) {
    companion object {
        fun create(): State {
            return State(
                UiEvent.OnUiEvent("abc")
            )
        }
    }
}