package edu.farmingdale.alrajab.allplayerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import edu.farmingdale.alrajab.allplayerproject.Fragments.FriendsFragment
import edu.farmingdale.alrajab.allplayerproject.Fragments.HomeFragment
import edu.farmingdale.alrajab.allplayerproject.Fragments.MessagesFragment
import edu.farmingdale.alrajab.allplayerproject.Fragments.PostsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)


        setToolbarTitle("Home")
        changeFragment((HomeFragment()))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home->{
                setToolbarTitle("Home")
                changeFragment(HomeFragment())
            }
            R.id.posts->{
                setToolbarTitle("Posts")
                changeFragment(PostsFragment())
            }
            R.id.friends->{
                setToolbarTitle("Friends")
                changeFragment(FriendsFragment())
            }
            R.id.message->{
                setToolbarTitle("Messages")
                changeFragment(MessagesFragment())
            }

        }
        return true
    }
    fun setToolbarTitle(title:String){
        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()
    }

}