package co.uk.thewirelessguy.androidsubredditcompose.navigation.model

import timber.log.Timber

enum class NavGraph {
    Home,
    Posts,
    PostDetail(Posts.name+"/detail/{param}"),
    ;

    var route: String = this.name

    constructor()

    constructor(route: String) {
        this.route = route
    }

    val topLevelRoute: String = "${route}/$route"

    fun createRoute(param: String): String {
        Timber.d("createRoute ${route}/$param")
        return "${route}/$param"
    }
}