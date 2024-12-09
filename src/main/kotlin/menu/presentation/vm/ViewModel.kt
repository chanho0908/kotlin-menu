package menu.presentation.vm

import menu.doamin.usecase.CheckCoachNameUseCase
import menu.doamin.usecase.CheckNotEatMenuUseCase
import menu.presentation.vm.model.State
import menu.presentation.vm.model.UiEvent

class ViewModel(
    private val coachNameUseCase: CheckCoachNameUseCase,
    private val notEatMenuUseCase: CheckNotEatMenuUseCase
) {
    private var _state = State.create()
    val state get() = _state

    fun onCompleteInputPurchasePrice(input: String){
        val coach = coachNameUseCase(input)
        _state = _state.copy(coach = coach)
        _state = _state.copy(
            uiEvent = UiEvent.OnUiEventUserInputNotEatMenu(
                msg = _state.notEatMenuMessage
            )
        )
    }

    fun onCompleteInputNotEatMenu(input: String, idx: Int){
        val notEatMenu = notEatMenuUseCase(input)
        val coach = _state.coach[idx]
        val currentNotEatMenu = _state.notEatMenu.toMutableMap()
        currentNotEatMenu[coach] = _state.notEatMenu.getOrDefault(coach, emptyList()) + notEatMenu
        _state = _state.copy(notEatMenu = currentNotEatMenu)
    }

    fun setUiEventToRecommendMenu(){
        _state = _state.copy(uiEvent = UiEvent.OnUiEventSetRecommendMenu)
    }


}