package menu.presentation.vm.model

import menu.doamin.rule.Output
import menu.doamin.rule.Output.Companion.notEatMenuFormat

data class State(
    val coach: List<String>,
    val notEatMenu: Map<String, List<String>>,
    val uiEvent: UiEvent
) {
    val notEatMenuMessage
        get() = coach.map {
            notEatMenuFormat(it)
        }


    companion object {
        fun create(): State {
            return State(
                emptyList(),
                emptyMap(),
                UiEvent.OnUiEventUserInputCoachName(
                    Output.INPUT_COACH.toString()
                )
            )
        }
    }
}