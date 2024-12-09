package menu.presentation.vm

import menu.doamin.rule.NumericConstants.WORKDAY
import menu.doamin.rule.Output
import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.usecase.CheckNotEatMenuUseCase
import menu.doamin.usecase.PickCategoryUseCase
import menu.doamin.usecase.RecommendMenuUseCase
import menu.presentation.vm.model.State
import menu.presentation.vm.model.UiEvent

class ViewModel(
    private val coachNameUseCase: CheckCoachNameUseCase,
    private val notEatMenuUseCase: CheckNotEatMenuUseCase,
    private val pickCategoryUseCase: PickCategoryUseCase,
    private val recommendMenuUseCase: RecommendMenuUseCase
) {
    private var _state = State.create()
    val state get() = _state

    fun onCompleteInputPurchasePrice(input: String) {
        val coach = coachNameUseCase(input)
        _state = _state.copy(coach = coach)
        _state = _state.copy(
            uiEvent = UiEvent.OnUiEventUserInputNotEatMenu(
                msg = _state.notEatMenuMessage
            )
        )
    }

    fun onCompleteInputNotEatMenu(input: String, idx: Int) {
        val notEatMenu = notEatMenuUseCase(input)
        val coach = _state.coach[idx]
        val currentNotEatMenu = _state.notEatMenu.toMutableMap()
        currentNotEatMenu[coach] = _state.notEatMenu.getOrDefault(coach, emptyList()) + notEatMenu
        _state = _state.copy(notEatMenu = currentNotEatMenu)
    }

    fun setUiEventToRecommendMenu() {
        pickCategory()
        pickMenu()
        _state = _state.copy(
            uiEvent = UiEvent.OnUiEventSetRecommendMenu(
                Output.RESULT_HEADER.msg +
                        _state.categoryMessage +
                        _state.recommendMessage +
                        Output.COMPLETE
            )
        )
    }

    private fun pickCategory() {
        repeat(WORKDAY.value) {
            val category = pickCategoryUseCase(_state.category)
            val currentCategory = _state.category.toMutableList()
            currentCategory.add(category)
            _state = _state.copy(category = currentCategory)
        }
    }

    private fun pickMenu() {
        _state.category.forEach { category ->
            _state.coach.forEach { coach ->
                val ateMenu = _state.ateMenu[coach] ?: emptyList()
                val notEatMenu = _state.notEatMenu[coach] ?: emptyList()
                val menu = recommendMenuUseCase(category, ateMenu, notEatMenu)

                val currentAteMenu = _state.ateMenu.toMutableMap()
                currentAteMenu[coach] = _state.ateMenu.getOrDefault(coach, emptyList()) + menu
                _state = _state.copy(ateMenu = currentAteMenu)
            }
        }
    }
}