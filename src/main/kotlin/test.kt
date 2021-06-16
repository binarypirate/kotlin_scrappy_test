import java.io.File

fun main() {
    MyFragment(File("/home/attaullah/IdeaProjects/TrapeziumPractice/src/main/kotlin/trapezium.txt").readText(Charsets.UTF_8)).onCreate()
}

class MyFragment(val response: String) {
    fun onCreate() {
        // println(response)


        val nr = " - colors: { color1: yellow, color2: green, color3: blue }"
        var splitted = nr.split(":")
        val list = mutableListOf<String>()
        val splitted_length = splitted.size - 1
        for (i in 1..splitted_length) {
            list.add(splitted[i])
        }
        var ns = list.joinToString(":")
        ns = ns.replace("{", "").replace("}", "").trim()
        // print(ns)

        splitted = ns.split(",")
        val l2 = mutableListOf<String>()
        for (item in splitted) {
            l2.add(item.split(":")[1].trim())
        }
        val arr = l2.toTypedArray()
        for (i in arr) {
            println(i)
        }


        //println("I Ran from adeel computer")
    }
}
