import kotlinx.coroutines.*

fun main() {
     runBlocking {
//         launch(Dispatchers.Main) {
//             println("Main dispatcher. Thread: ${Thread.currentThread().name}")
//         }
         launch {
             println("Unconfined. Thread: ${Thread.currentThread().name}")
             delay(100L)
             println("Unconfirmed2. Thread: ${Thread.currentThread().name}")
         launch(Dispatchers.Default) {
             println("Default. Thread: ${Thread.currentThread().name}")
         }
             launch(Dispatchers.IO) {
                println("IO. Thread: ${Thread.currentThread().name}")
             }
             launch(newSingleThreadContext("myThread")) {
                 println("newSingleThreadContext. Thread: ${Thread.currentThread().name}")
             }
         }
     }
}