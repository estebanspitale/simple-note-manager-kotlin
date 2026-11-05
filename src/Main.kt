// Data class used to store note information
data class Note(
    var title: String,
    var content: String
)

// Collection that stores all notes
val notes = mutableListOf<Note>()

fun main() {
    var running = true
    while (running) {
        showMenu()
        when (readln()) {
            "1" -> createNote()
            "2" -> viewNotes()
            "3" -> editNote()
            "4" -> deleteNote()
            "5" -> {
                println("Goodbye!")
                running = false
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}

// Displays the main menu
fun showMenu() {

    println("\n===== SIMPLE NOTE MANAGER =====")
    println("1. Create Note")
    println("2. View Notes")
    println("3. Edit Note")
    println("4. Delete Note")
    println("5. Exit")
    print("Choose an option: ")
}

// Creates a new note and adds it to the collection
fun createNote() {

    print("Enter note title: ")
    val title = readln()
    if (title.isBlank()) {
        println("Title cannot be empty.")
        return
    }
    print("Enter note content: ")
    val content = readln()
    val note = Note(title, content)
    notes.add(note)
    println("Note created successfully!")
}

// Displays all notes with title and content
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

// Displays only note titles for selection purposes
fun displayNoteTitles() {

    for ((index, note) in notes.withIndex()) {
        println("${index + 1}. ${note.title}")
    }
}

// Allows the user to edit an existing note
fun editNote() {

    if (notes.isEmpty()) {
        println("No notes available to edit.")
        return
    }
    println("\n===== EDIT NOTE =====")
    displayNoteTitles()
    print("Enter the note number to edit: ")
    val selection = readln().toIntOrNull()
    if (selection == null || selection !in 1..notes.size) {
        println("Invalid note number.")
        return
    }
    val note = notes[selection - 1]
    println("\nEditing: ${note.title}")
    print("Enter new title: ")
    val newTitle = readln()
    print("Enter new content: ")
    val newContent = readln()
    note.title = newTitle
    note.content = newContent
    println("Note updated successfully!")
}
// Allows the user to delete an existing note
fun deleteNote() {
    if (notes.isEmpty()) {
        println("No notes available to delete.")
        return
    }
    println("\n===== DELETE NOTE =====")
    displayNoteTitles()
    print("Enter the note number to delete: ")
    val selection = readln().toIntOrNull()
    if (selection == null || selection !in 1..notes.size) {
        println("Invalid note number.")
        return
    }
    val note = notes[selection - 1]
    print("Are you sure you want to delete '${note.title}'? (yes/no): ")
    val confirmation = readln()
    if (confirmation.equals("yes", ignoreCase = true)) {
        notes.removeAt(selection - 1)
        println("Note deleted successfully!")
    } else {
        println("Note deletion cancelled.")
    }
}
