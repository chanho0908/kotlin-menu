package menu.presentation.vm.model

import menu.doamin.rule.Output
import menu.doamin.rule.Output.Companion.categoryFormat
import menu.doamin.rule.Output.Companion.notEatMenuFormat
import menu.doamin.rule.Output.Companion.recommendFormat

data class State(
    val coach: List<String>,
    val ateMenu: Map<String, List<String>>,
    val notEatMenu: Map<String, List<String>>,
    val category: List<Int>,
    val uiEvent: UiEvent
) {

    val notEatMenuMessage
        get() = coach.map {
            notEatMenuFormat(it)
        }

    val categoryMessage
        get() = categoryFormat(category)

    val recommendMessage
        get() = coach.joinToString("\n") {
            recommendFormat(it, ateMenu[it] ?: emptyList())
        }

    companion object {
        fun create(): State {
            return State(
                emptyList(),
                emptyMap(),
                emptyMap(),
                emptyList(),
                UiEvent.OnUiEventUserInputCoachName(
                    Output.INPUT_COACH.toString()
                )
            )
        }
    }
}