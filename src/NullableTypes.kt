fun main(args: Array<String>) {
    testSendMessageToClient(null,"Hello World")
}

fun testSendMessageToClient(client: Client?, expectedMessage: String?, expectedEmail: String? = null) {
    sendToClient(client, expectedMessage, object : Mailer {
        override fun sendMessage(email: String, message: String) {
            println(email)
            println(message)
        }
    })
}

fun sendToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}