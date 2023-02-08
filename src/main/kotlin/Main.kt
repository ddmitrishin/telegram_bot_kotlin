import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import java.util.*

fun main() {
    val ratKingToken = "ratKingToken"
    val users = arrayOf("@User1", "@User2", "@User3")
    val actions = arrayOf("присылает селфи", "расказывает анекдот", "воет как псина в аудиосообщении")
    val randomUser = doRandom(users)
    val randomAction = doRandom(actions)

    val bot = bot {
        token = ratKingToken
        dispatch {
            text("апекс пидоры") {
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = users.joinToString(" ") + " готовность?"
                )
            }
            text("Запускаю короля крыс") {
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

fun doRandom(array: Array<String>) = array[(Math.random() * array.size).toInt()]