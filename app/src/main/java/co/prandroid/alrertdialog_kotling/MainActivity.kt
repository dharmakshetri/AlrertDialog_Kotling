package co.prandroid.alrertdialog_kotling

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.text.InputType
import android.support.v4.widget.SearchViewCompat.setInputType



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun displayAlert(view: View){
        val alert = AlertDialog.Builder(this)
        var editTextAge:EditText?=null

        // Builder
        with (alert) {
            setTitle("Title of Alert")
            var name=editTextName.text.toString()
            setMessage("${name} \n\nEnter your Age Here!!")

            // Add any  input field here
             editTextAge=EditText(context)
             editTextAge!!.hint="age"
             editTextAge!!.inputType = InputType.TYPE_CLASS_NUMBER

            setPositiveButton("OK") {
                dialog, whichButton ->
                //showMessage("display the game score or anything!")
                dialog.dismiss()
                var age=editTextAge!!.text.toString()
                textViewOutput.text=" Name: ${name} and Age:  ${age}"
            }

            setNegativeButton("NO") {
                dialog, whichButton ->
                //showMessage("Close the game or anything!")
                dialog.dismiss()
            }
        }

        // Dialog
        val dialog = alert.create()
        dialog.setView(editTextAge)
        dialog.show()
    }
}

