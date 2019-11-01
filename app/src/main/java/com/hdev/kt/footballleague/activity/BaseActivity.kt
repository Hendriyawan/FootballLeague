package com.hdev.kt.footballleague.activity

import android.support.v7.app.AppCompatActivity
import com.hdev.kt.footballleague.R
import com.hdev.kt.footballleague.model.League
import org.json.JSONArray
import org.json.JSONObject

open class BaseActivity : AppCompatActivity() {

    protected fun initActionBar(uiClass: String?) {
        supportActionBar?.apply {
            title = resources.getString(R.string.app_name)
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            if (uiClass.equals("main")) {
                setHomeAsUpIndicator(resources.getDrawable(R.drawable.ic_trophy_white_24dp))
            }
        }
    }

    protected fun getLeagueData(): List<League> {
        val leagueList: MutableList<League> = mutableListOf()
        val jsonFile: String? = applicationContext.assets.open("league.json").bufferedReader().use { it.readText() }
        JSONObject(jsonFile).apply {
            JSONArray("league").apply {
                for (i in 0 until length()) {
                    getJSONObject(i).apply {
                        leagueList.add(League(getString("logo"), getString("name"), getString("description")))
                    }
                }
            }
        }
        return leagueList
    }
}
