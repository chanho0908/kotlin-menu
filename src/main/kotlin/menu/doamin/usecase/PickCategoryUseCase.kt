package menu.doamin.usecase

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import menu.doamin.model.Category
import menu.doamin.rule.NumericConstants.CATEGORY_KEY_MIN
import menu.doamin.rule.NumericConstants.CATEGORY_KEY_MAX

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
            category = Category.of(pickNumberInRange(CATEGORY_KEY_MIN.value, CATEGORY_KEY_MAX.value))
            if (pickedCategory.filter { it == category }.size < 2) break
        }
        return category
    }
}