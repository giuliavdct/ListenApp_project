package custom

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View


fun Context.inputDialog(title: String, layout: Int) =
    InputDialog(this, title, layout)

private const val DEFAULT_TEXT = "Title"

class InputDialog(context: Context, title: String = DEFAULT_TEXT, layout: Int
) : AlertDialog.Builder(context) {

    var view: View = LayoutInflater.from(getContext()).inflate(layout,null)
    var textPositive = "OK"
    var textNegative = "CANCEL"



    open var positiveListener = DialogInterface.OnClickListener { _, _ -> }
        set(value) {
            field = value
            setPositiveButton(textPositive, positiveListener)
        }
    open var negativeListener = DialogInterface.OnClickListener { _, _ -> }
        set(value) {
            field = value
            setNegativeButton(textNegative, negativeListener)
        }

    init {
        setTitle(title)
        setView(view)
        setPositiveButton(textPositive, positiveListener)
        setNegativeButton(textNegative, negativeListener)
    }

}