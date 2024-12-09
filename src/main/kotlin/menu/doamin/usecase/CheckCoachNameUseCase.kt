package menu.doamin.usecase

import menu.doamin.rule.Exception

class CheckCoachNameUseCase {
    operator fun invoke(input: String): List<String> {
        defaultValidate(input)
        val spliterator = input.split(",")
        spliteratorValidate(spliterator)
        return spliterator
    }

    private fun defaultValidate(input: String) {
        isEmpty(input)
        isValidForm(input)
    }

    private fun isEmpty(input: String) {
        require(input.isNotBlank()) { Exception.EMPTY }
    }

    private fun isValidForm(input: String) {
        val regex = Regex("^[a-zA-Z가-힣,]+")
        require(regex.matches(input)) { Exception.INVALID }
    }

    private fun spliteratorValidate(spliterator: List<String>) {
        isInvalidCoachSize(spliterator)
        isDuplicated(spliterator)
        isValidNameLength(spliterator)
    }

    private fun isInvalidCoachSize(spliterator: List<String>) {
        val range = 2..5
        require(spliterator.size in range) { Exception.INVALID_SIZE }
    }

    private fun isDuplicated(spliterator: List<String>) {
        val map = spliterator.groupingBy { it }.eachCount()
        require(map.all { it.value == 1 }) { Exception.DUPLICATED_NAME }
    }

    private fun isValidNameLength(spliterator: List<String>) {
        val range = 2..4
        require(spliterator.all { it.length in range }) {
            Exception.INVALID_RANGE
        }
    }
}