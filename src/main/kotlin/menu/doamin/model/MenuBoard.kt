package menu.doamin.model

sealed interface MenuBoard {
    val primaryKey: Int
    val kind: String
    val menu: List<String>

    data class Japanese(
        override val primaryKey: Int = 1,
        override val kind: String = "일식",
        override val menu: List<String> = listOf(
            "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"
        ),
    ): MenuBoard

    data class Korean(
        override val primaryKey: Int = 2,
        override val kind: String = "한식",
        override val menu: List<String> = listOf(
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
        )
    ): MenuBoard

    data class China(
        override val primaryKey: Int = 3,
        override val kind: String = "중식",
        override val menu: List<String> = listOf(
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
        )
    ): MenuBoard

    data class Asian(
        override val primaryKey: Int = 4,
        override val kind: String = "아시안",
        override val menu: List<String> = listOf(
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
        )
    ): MenuBoard

    data class Western(
        override val primaryKey: Int = 5,
        override val kind: String = "양식",
        override val menu: List<String> = listOf(
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
        )
    ): MenuBoard

    companion object{
        private val entries = listOf(
            Japanese(), Korean(), China(), Asian(), Western()
        )

        fun getMenuBoard(category: Int): List<String> {
            return entries.find { it.primaryKey == category }?.menu ?: emptyList()
        }
    }
}