package com.badlogic.masaki.firebasesample.presentation.dynamiclink.item

import com.google.android.gms.tasks.Task
import com.google.firebase.dynamiclinks.PendingDynamicLinkData

class DynamicLinkItem(val deepLinkTask: Task<PendingDynamicLinkData>) : Item
