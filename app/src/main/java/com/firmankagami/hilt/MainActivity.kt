package com.firmankagami.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.firmankagami.hilt.adapter.UserAdapter
import com.firmankagami.hilt.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(mutableListOf())

        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter

        getUserList()
    }

    private fun getUserList() {
        viewModel.getUserList("1").observe(this, { result ->

            if (result != null) {
                when (result) {

                    is com.firmankagami.hilt.utils.Result.Success -> {
                        val data = result.data
                        data.data?.forEach {
                            adapter.addUser(it)
                        }
                    }

                    is com.firmankagami.hilt.utils.Result.Error -> {
                        Toast.makeText(
                            this,
                            "Terjadi kesalahan" + result.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }

}