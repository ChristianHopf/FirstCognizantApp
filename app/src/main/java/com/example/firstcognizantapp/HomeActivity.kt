package com.example.firstcognizantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ContextMenu
import android.view.MenuItem
import android.view.Menu
import android.provider.AlarmClock
import android.util.Log
import android.widget.*

class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText;
    lateinit var contactTextView: TextView;
    lateinit var languagesListView: ListView;
    lateinit var buttonGallery: Button;
    var languages = arrayOf("English", "German", "French", "Japanese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        contactEditText = findViewById(R.id.etContact)
        contactTextView = findViewById(R.id.tvContact)
        languagesListView = findViewById(R.id.lvLanguages)
        buttonGallery = findViewById(R.id.btnGallery)
        registerForContextMenu(buttonGallery);
       /* var adapter = ArrayAdapter<String>(this,
                R.layout.listview_row,
                R.id.tvRow,
                languages)
        languagesListView.adapter = adapter

        var myStudent: Student? = intent.getParcelableExtra<Student>("student")
        Log.i(TAG, myStudent.toString())

        var name = intent.extras?.getString("keyn")
        contactTextView.text = name*/
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mi = menuInflater
        mi.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.settingsmi -> {
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            }
            R.id.logoutmi -> {
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.btn_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when(item.itemId){
            R.id.editmi -> {
                Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show()
            }
            R.id.delmi -> {
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show()
            }
            R.id.sharemi -> {
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    companion object{
        var TAG = HomeActivity::class.java.simpleName
    }
}