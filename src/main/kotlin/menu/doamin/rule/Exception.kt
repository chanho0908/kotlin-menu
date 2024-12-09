package menu.doamin.rule

enum class Exception(private val msg: String) {
    EMPTY("빈 값이 입력 되었어요."),
    INVALID("잘못된 입력 형식입니다. 다시 입력해주세요."),
    DUPLICATED_NAME("코치의 이름은 중복될 수 없어요."),
    ONLY_DIGIT("0 이상의 정수만 입력해주세요."),
    INVALID_RANGE("코치의 이름은 최소 2글자, 최대 4글자 사이의 숫자로 입력해주세요."),
    INVALID_SIZE("코치는 최소 2명, 최대 5명까지 입력해주세요"),
    INVALID_NOT_EAT_MENU_SIZE("못 먹는 메뉴는 최대 두 개까지 입력해주세요.");

    override fun toString(): String = "$ERROR $msg"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}