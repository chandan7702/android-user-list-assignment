package com.chandan.userapp.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.chandan.userapp.R

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_AGE = "extra_age"
    }

    private lateinit var textViewDetailName: TextView
    private lateinit var textViewDetailEmail: TextView
    private lateinit var textViewDetailAge: TextView
    private lateinit var buttonSendEmail: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbarDetail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "User Details"

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        textViewDetailName = findViewById(R.id.textViewDetailName)
        textViewDetailEmail = findViewById(R.id.textViewDetailEmail)
        textViewDetailAge = findViewById(R.id.textViewDetailAge)
        buttonSendEmail = findViewById(R.id.buttonSendEmail)

        val name = intent.getStringExtra(EXTRA_NAME) ?: "N/A"
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: "N/A"
        val age = intent.getIntExtra(EXTRA_AGE, -1)

        textViewDetailName.text = name
        textViewDetailEmail.text = email
        textViewDetailAge.text = if (age >= 0) age.toString() else "N/A"

        buttonSendEmail.setOnClickListener {
            if (email != "N/A") {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$email")
                    putExtra(Intent.EXTRA_SUBJECT, "Hello $name")
                }
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                }
            }
        }
    }

    override fun finish() {
        super.finish()
        // Custom back transition
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right)
    }
}
