abstract class Widget(private val size: Int) {
    fun getMessage() = "Hello there!"
    fun getSize() = size
}

class ButtonWidget(private val size: Int) : Widget(size)

class ImageWidget(private val size: Int) : Widget(size), OnClickInterface {
    override fun onClick(lambda: (m: String) -> String): String = lambda(getMessage())
}

interface OnClickInterface {
    fun onClick(lambda: (m: String) -> String): String
}
fun main() {
    val buttonWidget = ButtonWidget(2)
    println(buttonWidget.getSize())
    println(buttonWidget.getMessage())
    val imageWidget = ImageWidget(3)
    println(imageWidget.onClick({it.reversed()}))
}