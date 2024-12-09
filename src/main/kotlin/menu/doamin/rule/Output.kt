package menu.doamin.rule

enum class Output(val msg: String) {
    WELCOME("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)"),
    NOT_EAT_MENU("%s(이)가 못 먹는 메뉴를 입력해 주세요.");
    override fun toString(): String = msg

    companion object{
        fun notEatMenuFormat(name: String): String{
            return NOT_EAT_MENU.msg.format(name)
        }
    }
}