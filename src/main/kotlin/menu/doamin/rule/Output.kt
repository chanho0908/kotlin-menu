package menu.doamin.rule

import menu.doamin.model.Category.Companion.getCategoryKind

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
                getCategoryKind(weeklyCategory[0]),
                getCategoryKind(weeklyCategory[1]),
                getCategoryKind(weeklyCategory[2]),
                getCategoryKind(weeklyCategory[3]),
                getCategoryKind(weeklyCategory[4])
            )
        }

        fun recommendFormat(name: String, recommend: List<String>): String {
            return RECOMMEND.msg.format(
                name,
                recommend[0],
                recommend[1],
                recommend[2],
                recommend[3],
                recommend[4],

            )
        }
    }
}