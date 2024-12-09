package menu.doamin.model

enum class Category(val key: Int, val kind: String) {
    Japanese(1, "일식"),
    KOREAN(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    companion object {
        fun of(value: Int): Int{
            return Category.values().find { it.key == value }?.key ?: 0
        }

        fun getCategoryKind(value: Int): String {
            return Category.values().find { it.key == value }?.kind ?: ""
        }
    }
}