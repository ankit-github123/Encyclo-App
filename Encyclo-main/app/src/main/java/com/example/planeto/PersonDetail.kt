package com.example.planeto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_person_detail.*

class PersonDetail : AppCompatActivity() {
    private lateinit var obj:CollegeData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        obj= intent.getParcelableExtra("planet")!!

        setData(obj)

        button_info.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL);
            var tele = obj.id.toString();
            intent.setData(Uri.parse("tel:"+tele))
//            val intent=Intent(this,finalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj:CollegeData)
    {
        title_info.text=obj.title
        distance_info.text=obj.designation
        type_info.text=obj.type
        overview_info.text=obj.overview
        identity_info.text=obj.identity
        person_img_info.setImageResource(obj.image!!)


    }
}