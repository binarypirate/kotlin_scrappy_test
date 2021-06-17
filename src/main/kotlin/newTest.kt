import java.io.File

fun main() {
    MyFragmentText(File("C:\\Users\\Rizwan Aslam\\Downloads\\Compressed\\kotlin_scrappy_test-main\\src\\main\\kotlin\\trapezium.txt").readText(Charsets.UTF_8)).onCreate()
}

class MyFragmentText(val response: String) {
    fun onCreate() {

        val parts = response.split("...")
        val  part0 = parts[0]
        val part1 = parts[1]

        val part0Splitting = part0.replace(".","").replace("\n","").replace("Hi!","")
        println(part0Splitting)


        val part1Splitting = part1.split("..")
        val greet = part1Splitting[0]
        val kick_out = part1Splitting[1]



        val greetSplitting = greet.replace("-","").replace("greet","").replace(":","").trim()
        println(greetSplitting)


        val kickOutSplitting = kick_out.split("|")
        val kick = kickOutSplitting[0]
        val color = kickOutSplitting[1]

        val kickSpliting = kick.replace("-","").replace("kick_out","").replace(":","").trim()
        println(kickSpliting)


        val myColorSplitting = color.split("}").toTypedArray()
        val colors = myColorSplitting[0]
        val genderGroup = myColorSplitting[1]

        var splitted = colors.split(":")
        val list = mutableListOf<String>()
        val splitted_length = splitted.size - 1
        for (i in 1..splitted_length) {
            list.add(splitted[i])
        }
        var newString = list.joinToString(":")
        newString = newString.replace("{", "").replace("}", "").trim()

        splitted = newString.split(",")
        val l2 = mutableListOf<String>()
        for (item in splitted) {
            l2.add(item.split(":")[1].trim())
        }
        val arr = l2.toTypedArray()
        for (i in arr) {
            println(i)
        }

        val gender = genderGroup.split("`").toTypedArray()
        val allGender = gender[0]
        val nounsGroup = gender[1]

        val genderSplitting = allGender.replace("-","").replace("genders","").replace(":","").trim()
        println(genderSplitting)

        val myNoun = nounsGroup.split("$").toTypedArray()
        val noun = myNoun[0]
        val programing = myNoun[1]

        val nounSplitting = noun.replace("-","").replace("nouns","").replace(":","").trim()
        println(nounSplitting)

        val programingLanguages = programing.split("!").toTypedArray()
        val programingLan = programingLanguages[0]
        val complex = programingLanguages[1]

        val programingSplit = programingLan.replace("-","").replace("programing language","").replace(":","").trim()
        println(programingSplit)

        val complexity = complex.split(":").toTypedArray()
        val com = complexity[0]
        val title = complexity[1]

        val comSpliting = com.replace("-","").trim()
        println(comSpliting)

        val titlePlan = title.split("---").toTypedArray()
        val myTitle = titlePlan[0]
        val vichles = titlePlan[1]

        val titleSpliting = myTitle.replace("#","").trim()
        println(titleSpliting)

        val vichlesSpliting = vichles.replace("-","").replace(",","\n").trim()
        println(vichlesSpliting)




//        val ns = ns.replace("-","").replace("{","").replace("}","").trim()
//        val newSplit = colorSplitting.split(",")
//        val l2 = mutableListOf<String>()
//        for (item in newSplit) {
//            l2.add(item.split(":")[1].trim())
//        }

//        val kickSplitting = kick.replace("-","").replace("kick_out","").replace(":","").trim()
//        println(kickSplitting)


    }

}