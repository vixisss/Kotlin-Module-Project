import java.util.*
import kotlin.collections.HashMap


class Archive { companion object {

    var archiveAndNotes = HashMap<String, MutableList<Notes>>()

    fun createArchive() {
        while (true) {
            println("\nВведите название архива")
            val scanner = Scanner(System.`in`)

            val archiveName = scanner.nextLine().trim()
            if (archiveName.isEmpty()) {
                println("\nОшибка! " +
                        "\nНазвание архива не может быть пустым.")
            }
            else {
                archiveAndNotes.put(archiveName, mutableListOf())
                println("\n'${archiveName}' успешно добавлен")
                return
            }
        }
    }

    fun chooseArchive(){
        while (true) {
            if (archiveAndNotes.keys.isEmpty()) {
                println("Список архивов пуст! " +
                        "Вам необходимо добавить хотя бы один архив")
                return
            }

            println("\n--Выберите архив или--:" +
                    "\n0. Выход в главное меню")

            //вывод архивов которые добавлены
            var k : Int = 1
            for (archive in archiveAndNotes.keys) {
                println("$k. $archive")
                k++
            }

            val archiveUserChoose = Scanner(System.`in`)
            val inputLine : String = archiveUserChoose.nextLine()

            if ((inputLine.toInt() > archiveAndNotes.keys.size) || (inputLine.toInt() < 0)) {
                println("Ошибка! Такого пункта нет!")
                continue
            }

            try {
                for(archive in archiveAndNotes.keys) {
                    val numberIndex = archiveAndNotes.keys.indexOf(archive) + 1
                    if(inputLine.toInt() == numberIndex) {
                        println("\nВыбран архив '$archive'")
                        Menu.noteMenu(archive)
                        break
                    }
                    else if (inputLine.toInt() == 0) {
                        return
                    }
                }
            }
            catch (e: NumberFormatException) {
                println("\nОшибка! Пожалуйста, введите корректный номер архива.")
            }
        }
    }
}}
