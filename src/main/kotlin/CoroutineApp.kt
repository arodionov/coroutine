import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Start main app")
    println(Thread.currentThread().name)

    for(i in 1..10) {
        launch {
            println(i.toString() + " " + Thread.currentThread().name)
            val res = long(i)
            println(i.toString() + " " + Thread.currentThread().name)
            println(res.toString() + " " + "Hello")
        }
    }

    Thread.sleep(20000) // wait for 2 seconds
    println("Stop main app")
}

suspend fun long(i: Int): Int {
    //delay(1000)
    val res = async {
        val (request, response, result) = "http://jug.ua/".httpGet().responseString()
        request
    }
    res.await()
    return i
}


