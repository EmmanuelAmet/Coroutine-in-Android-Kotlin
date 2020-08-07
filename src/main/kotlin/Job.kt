import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            //delay(3000L)
            println("Job1 launch")
            val job2 = launch {
                println("job2 launched")
                delay(3000L)
                println("job2 is finishing.")
            }
            job2.invokeOnCompletion { println("job2 completed.") }
            val job3 = launch {
                println("job3 launched")
                delay(3000L)
                println("job3 finishing")
            }
        }
        job1.invokeOnCompletion {
            println("job1 completed")
        }
        delay(500L)
        println("job1 will be cancelled")
        job1.cancel()
    }
}