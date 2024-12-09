package menu.doamin.usecase

import menu.doamin.model.MenuBoard.Companion.getMenuBoard
import camp.nextstep.edu.missionutils.Randoms

class RecommendMenuUseCase {
    operator fun invoke(
        category: Int,
        ateMenu: List<String>,
        notEatMenu: List<String>,
    ): String {
        val menu = getMenu(ateMenu, notEatMenu, category)
        return menu
    }

    private fun getMenu(ateMenu: List<String>, notEatMenu: List<String>, category: Int): String {
        val menuBoard = getMenuBoard(category)
        var menu = ""
        while (true) {
            val newMenu = Randoms.shuffle(menuBoard)[0]
            if (
                ateMenu.contains(newMenu).not() &&
                notEatMenu.contains(newMenu).not()
            ) {
                menu = newMenu
                break
            }
        }
        return menu
    }
}