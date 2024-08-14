import java.util.Scanner

class Note { companion object {

    fun createNote(list : MutableList<Notes>) {
        while (true) {
            println("Введите заголовок заметки:")
            val scanner = Scanner(System.`in`)
            val title = scanner.nextLine().trim()

            if (title.isEmpty()) {
                println("Ошибка! Заголовок заметки не может быть пустым.")
                continue
            }

            println("Введите содержание заметки:")

            val content = scanner.nextLine().trim()
            if (content.isEmpty()) {
                println("Ошибка! Содержание заметки не может быть пустым.")
                continue
            }

            list.add(Notes(title, content))
            println("Заметка '$title' создана и добавлена в архив ")
            return
        }
    }

    fun checkNote(archiveName: String) {
        val valuesArchiveList = Archive.archiveAndNotes.getValue(archiveName)

        if (valuesArchiveList.isEmpty()) {
            println("Список заметок пуст! " +
                    "Вам необходимо добавить хотя бы одну заметку")
            return
        }

        while (true) {
            println("\n--Выберите заметку, текст которой хотите увидеть или--" +
                    "\n0.Назад")

            var count: Int = 0
            for (value in valuesArchiveList) {
                count++
                println("$count. ${value.title}")
            }

            val noteUserChoose = Scanner(System.`in`)
            val inputLine : String = noteUserChoose.nextLine()

            try {
                for (valueE in valuesArchiveList) {
                    val numberIndex = valuesArchiveList.indexOf(valueE) + 1
                    if(inputLine.toInt() == numberIndex) {
                        println("Текст заметки '${valueE.title}':\n${valueE.text}")
                    }
                }
                if (inputLine.toInt() == 0) { return }
            }
            catch (e: NumberFormatException) {
                println("Ошибка! Пожалуйста, введите корректный номер заметки.")
                continue
            }
        }
    }
}}