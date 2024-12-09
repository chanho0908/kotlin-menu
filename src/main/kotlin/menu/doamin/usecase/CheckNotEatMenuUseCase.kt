package menu.doamin.usecase

import menu.doamin.rule.Exception

class CheckNotEatMenuUseCase {

    operator fun invoke(input: String): List<String> {
        if (input.isEmpty()) return emptyList()
        defaultValidate(input)
        val spliterator = input.split(",")
        spliteratorValidate(spliterator)
        return spliterator
    }

    private fun defaultValidate(input: String) {
        isValidForm(input)
    }

    private fun isValidForm(input: String) {
        val regex = Regex("^[a-zA-Z가-힣0-9,]+")
        require(regex.matches(input)) { Exception.INVALID }
    }

    private fun spliteratorValidate(spliterator: List<String>) {
        isInvalidCoachSize(spliterator)
        isDuplicated(spliterator)
    }

    private fun isInvalidCoachSize(spliterator: List<String>) {
        val max = 2
        require(spliterator.size <= max) { Exception.INVALID_NOT_EAT_MENU_SIZE }
    }

    private fun isDuplicated(spliterator: List<String>) {
        val map = spliterator.groupingBy { it }.eachCount()
        require(map.all { it.value == 1 }) { Exception.DUPLICATE_NOT_EAT_MENU }
    }
}