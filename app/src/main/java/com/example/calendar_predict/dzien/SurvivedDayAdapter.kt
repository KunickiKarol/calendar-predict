package com.example.calendar_predict.dzien

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.DataBase.Activity.ActivityWithCategory
import com.example.calendar_predict.R
import java.util.Calendar

class SurvivedDayAdapter(): RecyclerView.Adapter<SurvivedDayAdapter.ViewHolder>() {



    private var DayEditActivitiesList = emptyList<ActivityWithCategory>()
    var context: Context?= null
    var calendarium = Calendar.getInstance()
    var calendarium2 = Calendar.getInstance()

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var poczatek: TextView =itemView.findViewById(R.id.poczatek)
        var koniec: TextView = itemView.findViewById(R.id.zakonczenie)
        var nazwa: TextView = itemView.findViewById(R.id.nazwa)

    }





    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SurvivedDayAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)

        val DayView = inflater.inflate(R.layout.today_layout,parent,false)
        return ViewHolder(DayView)
    }

    override fun onBindViewHolder(holder: SurvivedDayAdapter.ViewHolder, position: Int) {


        val activity: ActivityWithCategory= DayEditActivitiesList[position]
        val name = holder.nazwa
        val start = holder.poczatek
        val end = holder.koniec

        val od = activity.activity.hour_from
        val od2 = activity.activity.hour_to
        calendarium.time=od
        calendarium2.time = od2

        var time1 = displayCorrectTime(calendarium.get(Calendar.HOUR_OF_DAY), calendarium.get(Calendar.MINUTE))
        var time2 = displayCorrectTime(calendarium2.get(Calendar.HOUR_OF_DAY), calendarium2.get(Calendar.MINUTE))
        name.text = activity.activity.name
        start.text = time1
        end.text = time2
        var backgroundColor = Integer.toHexString(activity.category.colour)
        holder.itemView.setBackgroundColor(Color.parseColor("#"+ backgroundColor))






    }

    fun displayCorrectTime(hour : Int,minute : Int): String{

        var minuteString = minute.toString()
        var hourString = hour.toString()

        if(minute<10){
            minuteString = "0$minute"
        }
        when {
            hour<10 -> hourString = "0$hour"
            hour>23 -> {
                hourString = "00"
            }
        }
        return "$hourString:$minuteString"
    }












    override fun getItemCount(): Int {
        return DayEditActivitiesList.size
    }

    fun setData(data: List<ActivityWithCategory>){
        this.DayEditActivitiesList = data
        notifyDataSetChanged()
    }

    fun getData(position: Int): ActivityWithCategory {
        return DayEditActivitiesList[position]
    }


}