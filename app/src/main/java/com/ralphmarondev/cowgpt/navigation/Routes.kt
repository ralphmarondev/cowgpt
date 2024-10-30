package com.ralphmarondev.cowgpt.navigation

import kotlinx.serialization.Serializable

object Routes {
    @Serializable
    data object OnBoarding

    @Serializable
    data object Home
}