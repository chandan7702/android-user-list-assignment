package com.chandan.userapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chandan.userapp.R
import com.chandan.userapp.model.User
import com.chandan.userapp.ui.detail.UserDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbar)

        recyclerViewUsers = findViewById(R.id.recyclerViewUsers)

        setupSampleUsers()
        setupRecyclerView()
    }

    private fun setupSampleUsers() {
        users.add(User("Alice Johnson", "alice@example.com", 25))
        users.add(User("Bob Williams", "bob@example.com", 30))
        users.add(User("Charlie Brown", "charlie@example.com", 28))
        users.add(User("Diana Prince", "diana@example.com", 27))
        users.add(User("Ethan Hunt", "ethan@example.com", 35))
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(users) { selectedUser ->
            openUserDetailScreen(selectedUser)
        }

        recyclerViewUsers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter

            // Apply layout animation
            layoutAnimation = AnimationUtils.loadLayoutAnimation(
                this@MainActivity,
                R.anim.layout_animation_fall_down
            )
            scheduleLayoutAnimation()
        }
    }

    private fun openUserDetailScreen(user: User) {
        val intent = Intent(this, UserDetailActivity::class.java).apply {
            putExtra(UserDetailActivity.EXTRA_NAME, user.name)
            putExtra(UserDetailActivity.EXTRA_EMAIL, user.email)
            putExtra(UserDetailActivity.EXTRA_AGE, user.age)
        }
        startActivity(intent)
        // Screen transition animation
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out)
    }
}
