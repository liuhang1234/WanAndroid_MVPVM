package com.lh.wanandroid.http

class HttpThrowable :Throwable {
    /**失败状态码 */
    var code = -1

    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(code: Int, message: String) : super(message) {
        this.code = code
    }
}