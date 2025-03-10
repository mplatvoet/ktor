package org.jetbrains.ktor.samples.async

import kotlinx.html.*
import kotlinx.html.stream.*
import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.http.*
import org.jetbrains.ktor.routing.*
import java.util.*
import java.util.concurrent.*

class AsyncApplication(config: ApplicationConfig) : Application(config) {
    val executor: ScheduledExecutorService by lazy { Executors.newScheduledThreadPool(4) }

    init {
        routing {
            get("/{...}") {
                val start = System.currentTimeMillis()
                executor.submit { handleLongCalculation(start) }
                ApplicationRequestStatus.Asynchronous
            }
        }
    }

    private fun ApplicationRequestContext.handleLongCalculation(start: Long) {
        val queue = System.currentTimeMillis() - start
        var number = 0
        val random = Random()
        for (index in 0..300) {
            Thread.sleep(10)
            number += random.nextInt(100)
        }

        val time = System.currentTimeMillis() - start

        response.contentType(ContentType.Text.Html)
        response.write {
            appendHTML().html {
                head {
                    title { +"Async World" }
                }
                body {
                    h1 {
                        +"We calculated this after ${time}ms (${queue}ms in queue): $number"
                    }
                }
            }
        }
        close()
    }
}
