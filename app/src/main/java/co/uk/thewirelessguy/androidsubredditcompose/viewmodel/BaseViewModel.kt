package co.uk.thewirelessguy.androidsubredditcompose.viewmodel

import androidx.lifecycle.ViewModel
import co.uk.thewirelessguy.androidsubredditcompose.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val navigator: AppNavigator
) : ViewModel(), AppNavigator by navigator