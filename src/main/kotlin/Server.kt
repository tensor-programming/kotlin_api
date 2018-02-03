import io.ktor.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

val portArgName = "--server.port"
val defaultPort = 7000

fun main(args: Array<String>) {
    val portConfigured = args.isNotEmpty() && args[0].startsWith(portArgName)

    val port = if (portConfigured) {
        args[0].split("=").last().trim().toInt()
    } else defaultPort

    embeddedServer(Netty, port, module = Application::main).start(wait = true)
}