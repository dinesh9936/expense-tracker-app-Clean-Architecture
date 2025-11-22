package com.rama.expensetrackerapp.presentation.addexpense

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rama.expensetrackerapp.domain.model.Expense
import com.rama.expensetrackerapp.domain.usecase.ExpenseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val useCases: ExpenseUseCases
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveExpense(title: String, amount: Double, category: String, date: LocalDate) {
        val timestamp = date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000

        val expense = Expense(
            title = title,
            amount = amount,
            category = category,
            date = timestamp
        )

        viewModelScope.launch {
            useCases.addExpenseUseCase(expense)
        }
    }
}
