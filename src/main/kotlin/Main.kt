import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import java.util.*

fun main() {
    val bot = bot {
        token = "anyToken"
        dispatch {
            text("Запускаю короля крыс") {
                fun doRandom(array: Array<String>) = array[(Math.random() * array.size).toInt()]
                val randomUser = doRandom(arrayOf("@User1", "@User22", "@User3"))
                val randomAction =
                    doRandom(arrayOf("присылает селфи", "расказывает анекдот", "воет как псина в аудиосообщении"))
                Timer().scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "$randomUser крыса")
                        bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Сегодня $randomAction")
                    }
                }, 1, 86400000)
            }
        }
    }
    bot.startPolling()
}
