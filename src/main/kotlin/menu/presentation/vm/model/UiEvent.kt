package menu.presentation.vm.model

sealed interface UiEvent {
    data class OnUiEventUserInputCoachName(val msg: String): UiEvent
    data class OnUiEventUserInputNotEatMenu(val msg: List<String>): UiEvent
    data class OnUiEventSetRecommendMenu(val msg: String): UiEvent
}