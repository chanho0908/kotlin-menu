package menu.doamin.usecase

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import menu.doamin.model.Category

class PickCategoryUseCase {
    operator fun invoke(
        pickedCategory: List<Int>
    ): Int{
        val newCategory = pickValidCategory(pickedCategory)
        return newCategory
    }

    private fun pickValidCategory(pickedCategory: List<Int>): Int {
        var category = 0
        while (true) {
            category = Category.of(pickNumberInRange(1, 5))
            if (pickedCategory.filter { it == category }.size < 2) break
        }
        return category
    }
}