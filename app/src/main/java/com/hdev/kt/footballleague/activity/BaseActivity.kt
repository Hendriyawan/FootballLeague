package com.hdev.kt.footballleague.activity

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hdev.kt.footballleague.R
import com.hdev.kt.footballleague.model.League
import org.json.JSONObject

open class BaseActivity : AppCompatActivity() {

    protected fun initActionBar(uiClass: String?) {
        supportActionBar?.apply {
            title = resources.getString(R.string.app_name)
            this.setDisplayShowHomeEnabled(true)
            this.setDisplayHomeAsUpEnabled(true)
            if (uiClass.equals("main")) {
                this.setHomeAsUpIndicator(resources.getDrawable(R.drawable.ic_trophy_white_24dp))
            }
        }
    }

    protected fun getLeagueData(): List<League> {
        val leagueList: MutableList<League> = mutableListOf()
        val jsonFile: String = applicationContext.assets.open("league.json").bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonFile)
        val jsonArray = jsonObject.getJSONArray("league")
        for (i in 0 until jsonArray.length()) {
            val value = jsonArray.getJSONObject(i)
            leagueList.apply {
                add(League(value.getString("logo"), value.getString("name"), value.getString("description")))
                Log.d("debug", value.getString("logo"))
                Log.d("debug", value.getString("name") + "\n")
            }
        }
        return leagueList
    }
}
