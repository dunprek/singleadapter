package com.don.singleadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    val className = MainActivity::class.java.simpleName
    val myData = listOf<Any>(
        NameMdl("John"),
        NameMdl("Doe"),
        NameMdl("Alex"),
        OtherMdl("Mark","New Valley"),
        OtherMdl("Lucas","New Jersey"),
        OtherMdl("Andrew White","Hot Tube")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val myAdapter = object : SingleAdapter<Any>(myData,this) {
            override fun getLayoutId(position: Int, obj: Any): Int {
                return when(obj){
                    is NameMdl->R.layout.item_list_user_name
                    is OtherMdl->R.layout.item_list_user_detail
                    else->R.layout.item_list_user_name
                }
            }


        }
        rv.layoutManager= LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter=myAdapter
    }

    fun showToast(position:Int){
        Toast.makeText(this,"Selected on : $position",Toast.LENGTH_SHORT).show()
    }
}
