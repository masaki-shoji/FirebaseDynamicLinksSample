package com.badlogic.masaki.firebasesample.domain

enum class DynamicLinkRoute
    constructor(private val mDestination: String) {

    TOP("/top"),
    OSS("/oss"),
    WEB_VIEW("/webView"),
    MEANINGLESS("/meaningless"),
    DYNAMIC("/dynamic");

    fun getDestination() = mDestination

    companion object {
        @JvmStatic
        fun getEnum(str: String): DynamicLinkRoute? {
            val enumArray = DynamicLinkRoute.values()

            enumArray.forEach { enumStr ->
                if (str == enumStr.getDestination()) {
                    return enumStr
                }
            }
            return null
        }
    }
}
