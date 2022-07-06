package com.example.firstcognizantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.provider.AlarmClock

class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText;
    lateinit var contactTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        contactEditText = findViewById(R.id.etContact)
        contactTextView = findViewById(R.id.tvContact)
        var name = intent.extras?.getString("keyn")
        contactTextView.text = name
    }

    fun contactHandler(clickedView: View) {
        // kotlin switch statement
        when(clickedView.id){
            R.id.btnContact -> {
                setContactText()
            }
            R.id.btnGallery -> {
                startTimer("milk boiled", 10)
            }
        }
    }

    private fun setContactText(){
        var contact = contactEditText.text.toString()
        var intent = Intent()
        intent.putExtra("contactKey", contact)
        setResult(RESULT_OK, intent)
        contactTextView.text = contact
        finish()
    }

    fun startTimer(message: String, seconds: Int){
        // create alarm intent with given message and seconds
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply{
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        // start activity if allowed
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}