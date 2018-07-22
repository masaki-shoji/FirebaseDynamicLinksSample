package com.badlogic.masaki.firebasesample.domain.model

import android.net.Uri

class DeepLink() {

    var scheme: String? = null
    var host: String? = null
    var port: Int? = null
    var path: String? = null

    constructor(
            scheme: String?,
            host: String?,
            port: Int?,
            path: String?
    ) : this() {
        this.scheme = scheme
        this.host = host
        this.port = port
        this.path = path
    }

    constructor(uri: Uri) : this() {
        this.scheme = uri.scheme
        this.host = uri.host
        this.port = uri.port
        this.path = uri.path
    }
}
