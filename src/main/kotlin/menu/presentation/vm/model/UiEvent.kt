package menu.presentation.vm.model

sealed interface UiEvent {
    val msg: String
    data class OnUiEvent(override val msg: String): UiEvent
}