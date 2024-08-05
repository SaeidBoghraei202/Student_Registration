


var dataSudents = mutableListOf<Student>()


fun main() {



    while (true){

        try {
            when(menu()){
                1->singUp()
                2->checkInformationStudent()
                3->removeInformationStudent()
                4->break
            }
        }catch (e:Exception){
            println("Invalid Input Type")
            println(e.message)
        }

    }


}

fun menu():Int{
    println("[1] sing Up Student")
    println("[2] check Information Student")
    println("[3] remove Information Student")
    println("[4] exit App")
    println("==============================")
    println("please Enter Your Choice")
    val request = readLine()?.toInt()!!
    return  request
}
fun singUp() {
    println("Enter your national code")
    val code = readLine()!!
    println("Enter your student code")
    val studentCode = readLine()!!
    val checkingNationalCode = dataSudents.filter { it.nationalCode == code}
    val checkingStudentCode = dataSudents.filter { it.nationalCode == code}
    if (checkingNationalCode.isNotEmpty()){
        println("National code has already been registered in the system!")
        return
    }
    if (checkingStudentCode.isNotEmpty()){
        println("student code has already been registered in the system!")
        return
    }
    println("Enter your name")
    val firstName = readLine()!!
    println("Enter your lastName")
    val lastName = readLine()!!
    println("Enter your Grade")
    val grade = readLine()!!
    println("Enter your Age")
    val age = readLine()?.toInt()!!
    var studentInformation = Student(code,studentCode,firstName,lastName,grade,age)
    dataSudents.add(studentInformation)
    println("Your information has been successfully registered")
}
fun checkInformationStudent(){
    println("Enter your student code")
    val studentCode = readLine()!!
    var checkvalid = dataSudents.filter { it.studentID == studentCode }
    if (checkvalid.isNotEmpty()){
        checkvalid.forEach { println(it) }
    }else{
        println("User with this national code was not found")
    }

}
fun removeInformationStudent(){
    println("Enter your student code")
    val studentCode = readLine()!!
    var checkvalid = dataSudents.filter { it.studentID == studentCode }
    if (checkvalid.isNotEmpty()){
        dataSudents.removeIf { it.studentID == studentCode }
        println("User information has been successfully deleted")
    }else{
        println("The entered national code was not found in the system!")
    }
}




