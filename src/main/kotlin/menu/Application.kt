package menu

import menu.app.di.DependencyInjector

fun main() {
    val di = DependencyInjector()
    di.injectViewController()
}