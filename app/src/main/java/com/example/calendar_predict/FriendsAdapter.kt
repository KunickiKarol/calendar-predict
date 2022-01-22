package com.example.calendar_predict

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.DataBase.Objective.ObjectiveWithCategory
import java.time.LocalDate
import java.time.LocalTime

class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {
    var context: Context? = null
    private var friendsList = emptyList<Friend>()
//    private lateinit var agregationList: Map<Int, Int>

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val friendNameTextView: TextView = itemView.findViewById<TextView>(R.id.goalNameTextView)
//        val amountDoneTextView: TextView = itemView.findViewById<TextView>(R.id.amountDoneTextView)
//        val nextDueTextView: TextView = itemView.findViewById<TextView>(R.id.nextDueTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val taskView = inflater.inflate(R.layout.goal, parent, false)

        return ViewHolder(taskView)
    }

    override fun onBindViewHolder(viewHolder: FriendsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val friend = friendsList[position]
        // Set item views based on your views and data model
        val title = viewHolder.friendNameTextView
        title.text = friend.name
//        val amount = viewHolder.amountDoneTextView

//        amount.text = "" + agregationList[goal.category.id] + " / " + goal.objective.targetAmount
//        if (15 < goal.objective.targetAmount) {
//            amount.setTextColor(Color.RED)
//        }
//        else {
//            amount.setTextColor(Color.GREEN)
//        }

//        val nextDue = viewHolder.nextDueTextView
//
//        val secsTillDayEnd = getSecsTillDayEnd()
//        val daysTillWeekEnd = getDaysTillWeekEnd()
//        pierwszy dzień następnego miesiąca - minus dziś - 1
//        val daysTillMonthEnd = getDaysTillMonthEnd()
//
//        nextDue.text = when(goal.objective.kind) {
//            GoalKind.DAY.string -> "Pozostało ${secsTillDayEnd / 3600} godzin i ${(secsTillDayEnd % 3600) / 60} minut"
//            GoalKind.WEEK.string -> "Pozostało $daysTillWeekEnd dni i ${secsTillDayEnd / 3600} godzin"
//            GoalKind.MONTH.string -> "Pozostało $daysTillMonthEnd dni i ${secsTillDayEnd / 3600} godzin"
//            else -> ""
//        }

//        viewHolder.itemView.setOnLongClickListener {
//            Goals.showPopup(it, goal)

//            return@setOnLongClickListener true
//        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return friendsList.size
    }

//    fun getSecsTillDayEnd(): Int {
//        return LocalTime.of(23, 59, 59).toSecondOfDay() - LocalTime.now().toSecondOfDay()
//    }
//
//    fun getDaysTillWeekEnd(): Int {
//        return  7 - LocalDate.now().dayOfWeek.value
//    }
//
//    fun getDaysTillMonthEnd(): Long {
//        val date = LocalDate.now()
//        return LocalDate.of(date.year + date.monthValue / 12, (date.monthValue) % 12 + 1, 1).toEpochDay() - date.toEpochDay() - 1
//    }

    fun getFriend(position: Int): Friend {
        return friendsList[position]
    }

    fun setData(friends: List<Friend>){
        this.friendsList = friends
//        this.agregationList = aggregated

        notifyDataSetChanged()
    }
}