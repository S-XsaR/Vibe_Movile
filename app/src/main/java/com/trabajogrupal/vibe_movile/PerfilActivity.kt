package com.trabajogrupal.vibe_movile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class PerfilActivity : AppCompatActivity(){


    private lateinit var instgTextView: TextView
    private lateinit var faceTextView: TextView
    private lateinit var yoututextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)



        instgTextView = findViewById<TextView>(R.id.InstgtextView)
        faceTextView = findViewById<TextView>(R.id.FacetextView)
        yoututextView = findViewById<TextView>(R.id.YoututextView)

        val Edit = findViewById<Button>(R.id.EditartextView)
        Edit.setOnClickListener{
            Edit()
            val intent = Intent(this, EditPActivity::class.java)
            intent.putExtra("instagram", instgTextView.text.toString())
            intent.putExtra("facebook", faceTextView.text.toString())
            intent.putExtra("youtube", yoututextView.text.toString())

            startActivityForResult(intent, EDIT_REQUEST_CODE)
        }


        val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "")
        val email = sharedPref.getString("email", "")

        val userTextView = findViewById<TextView>(R.id.NametextView)
        val emailTextView = findViewById<TextView>(R.id.CorretextView)

        userTextView.text = username
        emailTextView.text = email

    }
    private fun Edit (){
        val i = Intent(this, EditPActivity::class.java)
        startActivity(i)
    }
    companion object {
        private const val EDIT_REQUEST_CODE = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == EDIT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val instagram = data?.getStringExtra("instagram")
            val facebook = data?.getStringExtra("facebook")
            val youtube = data?.getStringExtra("youtube")
        }
    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.despleg_menu,menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.Perf -> {

                    val intent = Intent(this, PerfilActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.vid -> {
                    val intent = Intent(this, VideosActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.web -> {
                    val intent = Intent(this, WebActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.img-> {
                    val intent = Intent(this, imagenActivity::class.java)
                    startActivity(intent)

                    true

                }

                R.id.mp3 -> {
                    val intent = Intent(this, Mp3Activity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.rep -> {
                    val intent = Intent(this, ReproductorActivity::class.java)
                    startActivity(intent)

                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

        }
    }