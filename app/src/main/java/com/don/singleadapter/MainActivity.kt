package com.don.singleadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val className = MainActivity::class.java.simpleName
    val myData = listOf<Any>(
        NameMdl("vanya"),
        NameMdl("rachel"),
        NameMdl("sanggar"),
        OtherMdl("gideon","disini loh"),
        OtherMdl("Steven","masa sih"),
        OtherMdl("hahahhaa","lagi di mall")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val myAdapter = object : SingleAdapter<Any>(myData) {
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
}
