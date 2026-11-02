
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
        println("4. Edit Note")
        print("Choose an option: ")

        when (readln()) {

            "1" -> createNote()

            "2" -> viewNotes()

            "3" -> {
                println("Goodbye!")
                running = false
            }

            "4" -> editNote()

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

// Function to edit an existing note
fun editNote() {

    if (notes.isEmpty()) {
        println("No notes available to edit.")
        return
    }

    println("\n===== EDIT NOTE =====")

    // Display all available notes
    for ((index, note) in notes.withIndex()) {
        println("${index + 1}. ${note.title}")
    }

    // Ask the user which note to edit
    print("Enter the note number to edit: ")

    val selection = readln().toIntOrNull()

    // Validate the selected note number
    if (selection == null || selection < 1 || selection > notes.size) {
        println("Invalid note number.")
        return
    }

    // Get the selected note
    val note = notes[selection - 1]

    println("\nEditing: ${note.title}")

    // Ask for the new title
    print("Enter new title: ")
    val newTitle = readln()

    // Ask for the new content
    print("Enter new content: ")
    val newContent = readln()

    // Update the existing note
    note.title = newTitle
    note.content = newContent

    println("Note updated successfully!")
}
