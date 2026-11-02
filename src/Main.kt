// Data class used to store note information
data class Note(
    var title: String,
    var content: String
)

// Collection that will store all notes
val notes = mutableListOf<Note>()

fun main() {

    var running = true

    while (running) {

        println("\n===== SIMPLE NOTE MANAGER =====")
        println("1. Create Note")
        println("2. View Notes")
        println("3. Exit")
        print("Choose an option: ")

        when (readln()) {

            "1" -> createNote()

            "2" -> viewNotes()

            "3" -> {
                println("Goodbye!")
                running = false
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}

// Function to create a note
fun createNote() {

    print("Enter note title: ")
    val title = readln()

    print("Enter note content: ")
    val content = readln()

    val note = Note(title, content)

    notes.add(note)

    println("Note created successfully!")
}

// Function to display all notes
fun viewNotes() {

    if (notes.isEmpty()) {
        println("No notes available.")
        return
    }

    println("\n===== NOTES =====")

    for ((index, note) in notes.withIndex()) {

        println("${index + 1}. ${note.title}")
        println("   ${note.content}")
        println()
    }
}