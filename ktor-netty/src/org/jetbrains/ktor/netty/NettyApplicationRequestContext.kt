package org.jetbrains.ktor.netty

import io.netty.channel.*
import io.netty.handler.codec.http.*
import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.interception.*

class NettyApplicationRequestContext(override val application: Application,
                                     val context: ChannelHandlerContext,
                                     val httpRequest: FullHttpRequest) : ApplicationRequestContext {
    val httpResponse = DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK)

    override val close = Interceptable0<Unit> {
        context.writeAndFlush(httpResponse)
        context.close()
    }

    override val request: NettyApplicationRequest = NettyApplicationRequest(httpRequest)
    override val response: NettyApplicationResponse = NettyApplicationResponse(httpResponse)
}