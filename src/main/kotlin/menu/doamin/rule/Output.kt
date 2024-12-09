package menu.doamin.rule

enum class Output(val msg: String) {
    WELCOME("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH("코치의 이름을 입력해 주세요. (, 로 구분)");

    override fun toString(): String = msg

    companion object{

    }
}