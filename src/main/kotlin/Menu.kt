import java.util.Scanner

class Menu { companion object {

    fun archiveMainMenu() {
        val scanner = Scanner(System.`in`) // Создаем Scanner один раз

        while (true) {
            println()
            println("\n--Главное меню--\n" +
                    "Выберите: \n" +
                    "0. Создать архив \n" +
                    "1. Посмотреть архив \n" +
                    "2. Выход")

            val check = scanner.nextLine() // Считываем строку
            if (check.isNotEmpty() && check.toIntOrNull() != null) {
                val checkInt: Int = check.toInt()

                when (checkInt) {
                    0 -> { Archive.createArchive() }
                    1 -> { Archive.chooseArchive() }
                    2 -> { return }
                    else -> { println("\nОшибка! Такого пункта не существует!") }
                }
            }
            else {
                println("\nОшибка! Некорректный ввод!")
            }
        }
    }

    fun noteMenu(archiveTitle: String) {
        val scanner = Scanner(System.`in`)

        while (true) {
            println("\nАрхив '$archiveTitle'")
            println("Выберите действие из меню заметок: " +
                    "\n0. Создать заметку " +
                    "\n1. Посмотреть заметки " +
                    "\n2. Назад")

            val noteCheck = scanner.nextLine()
            if (noteCheck.isNotEmpty() && noteCheck.toIntOrNull() != null) {
                val noteNum: Int = noteCheck.toInt()

                when (noteNum) {
                    0 -> { Note.createNote(Archive.archiveAndNotes.getValue(archiveTitle)) }
                    1 -> { Note.checkNote(archiveTitle) }
                    2 -> { return }
                    else -> { println("\nОшибка! Такого пункта не существует!") }
                }
            }
            else { println("\nОшибка! Введите корректное число!") }
        }
    }
}}