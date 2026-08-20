package com.example.model

import androidx.compose.runtime.Composable

data class CaseStep(
    val stepNum: Int,
    val question: String,
    val actionNeeded: String,
    val correctAnswer: String,
    val options: List<String>,
    val hint: String
)

data class ChatMessage(
    val sender: String,
    val text: String,
    val time: String,
    val isMe: Boolean = false
)

data class WhatsAppChat(
    val contactName: String,
    val avatarUrl: String? = null,
    val lastMessage: String,
    val lastTime: String,
    val messages: List<ChatMessage>,
    val isArchived: Boolean = false,
    val isSilent: Boolean = false
)

data class GalleryPhoto(
    val id: Int,
    val imageDescription: String,
    val details: String,
    val isDeleted: Boolean = false,
    val isFavorite: Boolean = false,
    val requiresPin: Boolean = false,
    val vectorResType: String = "default"
)

data class WalletTransaction(
    val merchant: String,
    val amount: String,
    val date: String,
    val description: String = ""
)

data class GmailMessage(
    val sender: String,
    val subject: String,
    val snippet: String,
    val date: String,
    val body: String,
    val isUnread: Boolean = false
)

data class NoteEntry(
    val id: Int,
    val title: String,
    val content: String,
    val isLocked: Boolean = false,
    val pinCode: String = ""
)

data class HingeProfile(
    val name: String,
    val age: Int,
    val bio: String,
    val mainPhoto: String,
    val chatHistory: List<ChatMessage>
)

data class MapPinDefinition(
    val title: String,
    val address: String,
    val latLng: String,
    val details: String
)

data class GeminiQuery(
    val prompt: String,
    val response: String,
    val time: String
)

data class CasePhoneData(
    val wallpaperType: String,
    val wifiNetwork: String = "Starbucks_Free",
    val batteryPct: Int = 85,
    val currentNetworkTime: String = "14:20",
    val galleryPhotos: List<GalleryPhoto> = emptyList(),
    val whatsappChats: List<WhatsAppChat> = emptyList(),
    val walletCardType: String = "Visa Platinum",
    val walletCardNumber: String = "**** 8842",
    val walletTransactions: List<WalletTransaction> = emptyList(),
    val paypalNotifications: List<String> = emptyList(),
    val paypalBalance: String = "R$ 15,42",
    val linkedinInMailChats: List<WhatsAppChat> = emptyList(),
    val linkedinProfileStatus: String = "Ativo",
    val healthSteps: Int = 14200,
    val healthHeartLogs: List<String> = emptyList(),
    val gmailInboxes: List<GmailMessage> = emptyList(),
    val notes: List<NoteEntry> = emptyList(),
    val matches: List<HingeProfile> = emptyList(),
    val mapPins: List<MapPinDefinition> = emptyList(),
    val geminiQueries: List<GeminiQuery> = emptyList(),
    val employeeCode: String = "4099"
)

data class CaseDefinition(
    val id: Int,
    val theme: String,
    val title: String,
    val clientName: String,
    val targetName: String,
    val clientBriefingMessages: List<String>,
    val phoneData: CasePhoneData,
    val steps: List<CaseStep>
)

data class GameState(
    val currentCaseId: Int? = null,
    val currentScreen: String = "menu",
    val unlockedCaseIds: Set<Int> = setOf(1),
    val completedCaseIds: Set<Int> = emptySet(),
    val currentStepIndex: Int = 0,
    val activeApp: String? = null,
    val isOverlayOpen: Boolean = false,
    val wrongAttempts: Int = 0,
    val scoreHintPennies: Int = 50,
    val showCheatConfirm: Boolean = false
)
