import java.io.File

fun main() {
    MyFragment(
        File("C:\\Users\\Rizwan Aslam\\Downloads\\Compressed\\kotlin_scrappy_test-main\\src\\main\\kotlin\\fake_json.json").readText(
            Charsets.UTF_8
        )
    ).onCreate()
}

class UserAddressGeo {
    var lat = ""
    var lng = ""
}

class UserAddress {
    var street = ""
    var suite = ""
    var city = ""
    var zipCode = ""
    var geo = UserAddressGeo()
}

class Company {
    var name = ""
    var catchPhrase = ""
    var bs = ""
}

class User {
    var id = -1
    var name = ""
    var username = ""
    var email = ""
    var address = UserAddress()
    var phone = ""
    var website = ""
    var company = Company()
}

class MyFragment(var response: String) {

    fun getValue(delimiter: String = "\","): String {
        response = response.substringAfter(":").trim()
        val value = response.substringBefore(delimiter).replace("\"", "")
        response = response.substringAfter(",").trim()
        return value
    }

    fun onCreate() {

        var usersList = mutableListOf<User>()

        response = response.substringAfter("[").trim().replace("\n", "")
        while (response.isNotEmpty()) {
            if (response.startsWith("{")) {
                val user = User()
                response = response.substringAfter("{").trim()
                while (true) {
                    if (response.startsWith("\"")) {
                        response = response.substringAfter("\"")
                        when (response.substringBefore("\"")) {
                            "id" -> user.id = getValue(",").toInt()
                            "name" -> user.name = getValue()
                            "username" -> user.username = getValue()
                            "email" -> user.email = getValue()
                            "address" -> {
                                response = response.substringAfter("{").trim()
                                while (true) {
                                    if (response.startsWith("\"")) {
                                        response = response.substringAfter("\"")
                                        when (response.substringBefore("\"")) {
                                            "street" -> user.address.street = getValue()
                                            "suite" -> user.address.suite = getValue()
                                            "city" -> user.address.city = getValue()
                                            "zipcode" -> user.address.zipCode = getValue()
                                            "geo" -> {
                                                response = response.substringAfter("{").trim()
                                                while (true) {
                                                    if (response.startsWith("\"")) {
                                                        response = response.substringAfter("\"")
                                                        when (response.substringBefore("\"")) {
                                                            "lat" -> user.address.geo.lat = getValue()
                                                            "lng" -> {
                                                                user.address.geo.lng = getValue("},").replace("}", "").trim()
                                                                break
                                                            }
                                                        }
                                                    }
                                                }
                                                break
                                            }
                                        }
                                    }
                                }
                            }
                            "phone" -> user.phone = getValue()
                            "website" -> user.website = getValue()
                            "company" -> {
                                response = response.substringAfter("{").trim()
                                while (true) {
                                    if (response.startsWith("\"")) {
                                        response = response.substringAfter("\"")
                                        when (response.substringBefore("\"")) {
                                            "name" -> user.company.name = getValue()
                                            "catchPhrase" -> user.company.catchPhrase = getValue()
                                            "bs" -> {
                                                user.company.bs = getValue("},").replace("}", "").trim()
                                                break
                                            }
                                        }
                                    }
                                }
                                break
                            }
                        }
                    }
                }
                usersList.add(user)
            } else {
                break
            }
        }

        println("BS: ${usersList[7].company.name}")
        println("BS: ${usersList[7].company.catchPhrase}")
        println("BS: ${usersList[7].company.bs}")

    }
}
