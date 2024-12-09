package menu.doamin.rule

import menu.doamin.model.Category.Companion.getCategoryKind
import menu.doamin.rule.NumericConstants.MONDAY
import menu.doamin.rule.NumericConstants.TUESDAY
import menu.doamin.rule.NumericConstants.WEDNESDAY
import menu.doamin.rule.NumericConstants.THURSDAY
import menu.doamin.rule.NumericConstants.FRIDAY


enum class Output(val msg: String) {
    WELCOME("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
    NOT_EAT_MENU("%s(이)가 못 먹는 메뉴를 입력해 주세요."),
    RESULT_HEADER("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n"),
    CATEGORY("[ 카테고리 | %s | %s | %s | %s | %s ]\n"),
    RECOMMEND("[ %s | %s | %s | %s | %s | %s ]"),
    COMPLETE("\n추천을 완료했습니다.");

    override fun toString(): String = msg

    companion object {
        fun notEatMenuFormat(name: String): String {
            return NOT_EAT_MENU.msg.format(name)
        }

        fun categoryFormat(
            weeklyCategory: List<Int>
        ): String {
            return CATEGORY.msg.format(
                getCategoryKind(weeklyCategory[MONDAY.value]),
                getCategoryKind(weeklyCategory[TUESDAY.value]),
                getCategoryKind(weeklyCategory[WEDNESDAY.value]),
                getCategoryKind(weeklyCategory[THURSDAY.value]),
                getCategoryKind(weeklyCategory[FRIDAY.value])
            )
        }

        fun recommendFormat(name: String, recommend: List<String>): String {
            return RECOMMEND.msg.format(
                name,
                recommend[MONDAY.value],
                recommend[TUESDAY.value],
                recommend[WEDNESDAY.value],
                recommend[THURSDAY.value],
                recommend[FRIDAY.value],

            )
        }
    }
}