package com.ggroup.greecle.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.ggroup.greecle.*
import com.ggroup.greecle.adapters.ItemAdapter
import com.ggroup.greecle.adapters.NewsAdapter
import com.ggroup.greecle.adapters.TopicItemAdapter
import com.ggroup.greecle.models.Item
import com.ggroup.greecle.models.News
import com.ggroup.greecle.models.TopicItem

class HomeActivity : AppCompatActivity() {

    private lateinit var notif:ConstraintLayout

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Item>
    private lateinit var itemAdapter: ItemAdapter

    private lateinit var recyclerView2: RecyclerView
    private lateinit var topicItemList: ArrayList<TopicItem>
    private lateinit var topicItemAdapter: TopicItemAdapter

    private lateinit var recyclerView3: RecyclerView
    private lateinit var newsList: ArrayList<News>
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        notif = findViewById(R.id.notif)
        notif.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        itemList = ArrayList()

        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        val snapHelper2: SnapHelper = LinearSnapHelper()
        snapHelper2.attachToRecyclerView(recyclerView2)
        topicItemList = ArrayList()

        recyclerView3 = findViewById(R.id.recyclerView3)
        recyclerView3.setHasFixedSize(true)
        recyclerView3.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val snapHelper3: SnapHelper = LinearSnapHelper()
        snapHelper3.attachToRecyclerView(recyclerView3)
        newsList = ArrayList()

        addDataToList()

        itemAdapter = ItemAdapter(itemList)
        recyclerView.adapter = itemAdapter

        topicItemAdapter = TopicItemAdapter(topicItemList)
        recyclerView2.adapter = topicItemAdapter

        newsAdapter = NewsAdapter(newsList)
        recyclerView3.adapter = newsAdapter

        newsAdapter.onItemClick = {
            val intent = Intent(this, ArticleDetailActivity::class.java)
            startActivity(intent)
        }

        topicItemAdapter.onItemClick = {
            val intent = Intent(this, TopicDetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addDataToList(){
        itemList.add(Item(R.drawable.stack_of_paper,"Paper",40))
        itemList.add(Item(R.drawable.water_bottle,"Bottle",20))
        itemList.add(Item(R.drawable.stack_of_paper,"Paper",40))
        itemList.add(Item(R.drawable.water_bottle,"Bottle",20))

        topicItemList.add(TopicItem(R.drawable._d_fantasy_forest_background))
        topicItemList.add(TopicItem(R.drawable._d_fantasy_forest_background__1_))
        topicItemList.add(TopicItem(R.drawable._d_fantasy_forest_background))

        newsList.add(
            News(
                R.drawable.jungle_forest_view_tropical_trees_generative_ai,
            "World Environment Day",
            "World Environment Day is an annual global event promoting environmental awareness.")
        )
        newsList.add(
            News(
                R.drawable.jungle_forest_view_tropical_trees_generative_ai,
            "World Environment Day",
            "World Environment Day is an annual global event promoting environmental awareness.")
        )
        newsList.add(
            News(
                R.drawable.jungle_forest_view_tropical_trees_generative_ai,
            "World Environment Day",
            "World Environment Day is an annual global event promoting environmental awareness.")
        )
    }
}