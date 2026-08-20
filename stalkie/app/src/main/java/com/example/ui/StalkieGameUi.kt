package com.example.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.*
import com.example.model.*
import kotlinx.coroutines.delay
import kotlin.random.Random

val HackerBlack = Color(0xFF1A1C1E)
val HackerCardBg = Color(0xFF2D2E33)
val ImmersiveRed = Color(0xFFBA1A1A)
val NeonRed = Color(0xFFFF2E4C)
val NeonGreen = Color(0xFF2FFF2F)
val NeonBlue = Color(0xFF2FDFFF)
val SubtextGray = Color(0xFFA8ABB4)

@Composable
fun StalkieGameRoot() {
    var state by remember { mutableStateOf(GameState()) }
    val currentCase = if (state.currentCaseId != null) {
        StalkieCasesData.getOrGenerateCase(state.currentCaseId!!)
    } else null

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HackerBlack)
    ) {
        when (state.currentScreen) {
            "menu" -> DetectiveDeskScreen(
                state = state,
                onSelectCase = { caseId ->
                    state = state.copy(
                        currentCaseId = caseId,
                        currentStepIndex = 0,
                        currentScreen = "intro",
                        activeApp = null,
                        isOverlayOpen = false
                    )
                }
            )
            "intro" -> currentCase?.let { cCase ->
                BriefingScreen(
                    case = cCase,
                    onAccept = {
                        state = state.copy(currentScreen = "os")
                    },
                    onBack = {
                        state = state.copy(currentScreen = "menu", currentCaseId = null)
                    }
                )
            }
            "os" -> currentCase?.let { cCase ->
                VirtualOsScreen(
                    case = cCase,
                    state = state,
                    onUpdateState = { state = it }
                )
            }
        }
    }
}

@Composable
fun DetectiveDeskScreen(
    state: GameState,
    onSelectCase: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "STALKIE",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Monospace,
                    color = ImmersiveRed,
                    modifier = Modifier.shadow(8.dp, CircleShape)
                )
                Text(
                    text = "DEDUÇÃO & EXTRAÇÃO DIGITAL",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = NeonGreen
                )
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFF221111), RoundedCornerShape(8.dp))
                    .border(1.dp, ImmersiveRed, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Credits",
                        tint = ImmersiveRed,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${state.scoreHintPennies} CRÉDITOS",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = HackerCardBg),
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, ImmersiveRed.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Tips",
                    tint = NeonGreen,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "TERMINAL DE INVASÃO ATIVO",
                        color = NeonGreen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = "Selecione um dossiê alvo abaixo para descriptografar os sistemas, recolher dados e responder ao briefing do cliente.",
                        color = Color.White,
                        fontSize = 10.sp,
                        lineHeight = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "DOSSIÊS DOS CLIENTES (11 CASOS)",
            color = SubtextGray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(StalkieCasesData.dossierCasesList) { item ->
                val isUnlocked = item.id in state.unlockedCaseIds
                val isCompleted = item.id in state.completedCaseIds

                Card(
                    onClick = { if (isUnlocked) onSelectCase(item.id) },
                    colors = CardDefaults.cardColors(
                        containerColor = if (isUnlocked) HackerCardBg else Color(0xFF15151C)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize()
                        .border(
                            width = if (isCompleted) 1.5.dp else 1.dp,
                            color = when {
                                isCompleted -> NeonGreen
                                isUnlocked -> ImmersiveRed.copy(alpha = 0.7f)
                                else -> Color.White.copy(alpha = 0.12f)
                            },
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF263238))
                                    .border(
                                        1.dp,
                                        if (isUnlocked) ImmersiveRed else Color.Gray,
                                        RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (isUnlocked) Icons.Default.Check else Icons.Default.Lock,
                                    contentDescription = "Status",
                                    tint = if (isUnlocked) ImmersiveRed else Color.Gray,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = item.category,
                                        color = if (isCompleted) NeonGreen else ImmersiveRed,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                    if (isCompleted) {
                                        Text(
                                            text = "RESOLVIDO",
                                            color = NeonGreen,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily.Monospace,
                                            modifier = Modifier
                                                .background(Color(0xFF1B5E20), RoundedCornerShape(4.dp))
                                                .padding(horizontal = 4.dp, vertical = 2.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = "CASO ${item.id}: ${item.title}",
                                    color = if (isUnlocked) Color.White else Color.Gray,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Cliente: ${item.client} | ${item.subtitle}",
                                    color = if (isUnlocked) SubtextGray else Color.DarkGray,
                                    fontSize = 11.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        if (!isUnlocked) {

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .background(Color.Black.copy(alpha = 0.6f))
                                    .padding(16.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    text = "BLOQUEADO",
                                    color = Color.Gray,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BriefingScreen(
    case: CaseDefinition,
    onAccept: () -> Unit,
    onBack: () -> Unit
) {
    var renderedMessages = remember { mutableStateListOf<String>() }
    var isTyping by remember { mutableStateOf(false) }

    LaunchedEffect(case) {
        renderedMessages.clear()
        for (msg in case.clientBriefingMessages) {
            isTyping = true
            delay(1200)
            isTyping = false
            renderedMessages.add(msg)
            delay(500)
        }
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(HackerCardBg)
                    .statusBarsPadding()
                    .border(1.dp, Color.White.copy(alpha = 0.1f))
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.1f))
                        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = case.clientName.first().toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = case.clientName, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text(
                        text = if (isTyping) "Digitando..." else "Seguro • Online",
                        color = Color.White.copy(alpha = 0.6f),
                        fontSize = 11.sp
                    )
                }
            }
        },
        containerColor = HackerBlack
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    Text(
                        text = "🔒 CONVERSA CRIPTOGRAFADA PONTA-A-PONTA",
                        color = SubtextGray,
                        fontSize = 9.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }

                items(renderedMessages) { msg ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = HackerCardBg),
                            shape = RoundedCornerShape(4.dp, 16.dp, 16.dp, 16.dp),
                            modifier = Modifier
                                .widthIn(max = 280.dp)
                                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(4.dp, 16.dp, 16.dp, 16.dp))
                                .shadow(2.dp, RoundedCornerShape(4.dp, 16.dp, 16.dp, 16.dp))
                        ) {
                            Text(
                                text = msg,
                                color = Color(0xFFE2E2E6),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }

                if (isTyping) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Cliente está a digitar...",
                                color = SubtextGray,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(
                visible = renderedMessages.size == case.clientBriefingMessages.size,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 })
            ) {
                Button(
                    onClick = onAccept,
                    colors = ButtonDefaults.buttonColors(containerColor = ImmersiveRed),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Aceitar")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ACEITAR CASO & INVASÃO",
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VirtualOsScreen(
    case: CaseDefinition,
    state: GameState,
    onUpdateState: (GameState) -> Unit
) {
    val currentStep = try {
        case.steps[state.currentStepIndex]
    } catch (e: Exception) {
        case.steps.last()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HackerBlack)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .background(Color(0xFF2E2E3E), RoundedCornerShape(32.dp))
                    .border(6.dp, Color(0xFF1E1E28), RoundedCornerShape(32.dp))
                    .clip(RoundedCornerShape(26.dp))
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = when (case.phoneData.wallpaperType) {
                                        "porsche" -> listOf(Color(0xFF1A1A1A), Color(0xFF333333))
                                        "sunset" -> listOf(Color(0xFFE65100), Color(0xFFF57C00), Color(0xFF263238))
                                        "college" -> listOf(Color(0xFF1B5E20), Color(0xFF4CAF50), Color(0xFF0F1B0F))
                                        "dog" -> listOf(Color(0xFF3E2723), Color(0xFF5D4037), Color(0xFF151010))
                                        else -> listOf(Color(0xFF0D1B2A), Color(0xFF1B263B))
                                    }
                                )
                            )
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp)
                    ) {
                        if (state.activeApp == null) {
                            PhoneHomeScreen(case = case, onOpenApp = { app ->
                                onUpdateState(state.copy(activeApp = app))
                            })
                        } else {
                            AnimatedContent(
                                targetState = state.activeApp,
                                transitionSpec = {
                                    slideInVertically { height -> height } + fadeIn() togetherWith
                                            slideOutVertically { height -> -height } + fadeOut()
                                }, label = "AppTransition"
                            ) { targetApp ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Black)
                                ) {
                                    when (targetApp) {
                                        "whatsapp" -> EmulatedWhatsApp(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "photos" -> EmulatedPhotos(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "wallet" -> EmulatedWallet(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "gmail" -> EmulatedGmail(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "notes" -> EmulatedNotes(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "tinder" -> EmulatedTinder(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "maps" -> EmulatedMaps(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "gemini" -> EmulatedGemini(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "settings" -> EmulatedSettings(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "calculator" -> EmulatedCalculator(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "game2048" -> Emulated2048Game(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "snake" -> EmulatedSnakeGame(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        "brickbreaker" -> EmulatedBrickBreaker(case, onBack = { onUpdateState(state.copy(activeApp = null)) })
                                        else -> Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text("App em desenvolvimento", color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 8.dp)
                            .width(110.dp)
                            .height(24.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF0F0F1A))
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter)
                            .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = case.phoneData.currentNetworkTime,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(text = "📶", fontSize = 11.sp)
                            Text(
                                text = "${case.phoneData.batteryPct}%",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(text = "🔋", fontSize = 11.sp)
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(HackerCardBg.copy(alpha = 0.9f), RoundedCornerShape(28.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(28.dp))
                    .shadow(12.dp, RoundedCornerShape(28.dp))
                    .height(80.dp)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable {
                                onUpdateState(state.copy(currentScreen = "menu", currentCaseId = null))
                            }
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Cases",
                            tint = Color(0xFFC4C6CF),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "HOME",
                            color = Color(0xFFC4C6CF),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(50))
                                .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(50))
                                .padding(horizontal = 10.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "CASO #${String.format("%02d", case.id)}",
                                color = Color(0xFFE2E2E6),
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "PASSO ",
                                color = Color(0xFFA8ABB4),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(
                                text = "${state.currentStepIndex + 1}",
                                color = Color.White,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(
                                text = " / ${case.steps.size}",
                                color = Color(0xFFA8ABB4),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }

                    Button(
                        onClick = {
                            onUpdateState(state.copy(isOverlayOpen = true))
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = ImmersiveRed),
                        shape = CircleShape,
                        border = BorderStroke(4.dp, HackerBlack),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(64.dp)
                            .shadow(8.dp, CircleShape)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Solve",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = "SOLVE",
                                color = Color.White,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 0.5.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .width(120.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White.copy(alpha = 0.3f))
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 16.dp, end = 20.dp)
        ) {
            val infiniteTransition = rememberInfiniteTransition(label = "terminal_pulse")
            val alpha by infiniteTransition.animateFloat(
                initialValue = 0.4f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1200, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ), label = "pulse"
            )
            Box(
                modifier = Modifier
                    .alpha(alpha)
                    .background(ImmersiveRed.copy(alpha = 0.15f), RoundedCornerShape(8.dp))
                    .border(1.dp, ImmersiveRed.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "TERMINAL LINK ACTIVE",
                    color = ImmersiveRed,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        if (state.isOverlayOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f))
                    .clickable { onUpdateState(state.copy(isOverlayOpen = false)) }
            ) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = HackerCardBg),
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .align(Alignment.BottomCenter)
                        .border(2.dp, NeonRed, RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                        .clickable(enabled = false) {}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "MODULO DE RESOLUÇÃO SEGURO",
                                color = NeonRed,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                            IconButton(onClick = { onUpdateState(state.copy(isOverlayOpen = false)) }) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            repeat(20) { idx ->
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(4.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                idx < state.currentStepIndex -> NeonGreen
                                                idx == state.currentStepIndex -> NeonRed
                                                else -> Color.DarkGray
                                            }
                                        )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF1B1B26)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = "PERGUNTA DO PASSO ${state.currentStepIndex + 1}:",
                                    color = SubtextGray,
                                    fontSize = 10.sp,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = currentStep.question,
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Search, contentDescription = "Action", tint = NeonGreen, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = currentStep.actionNeeded,
                                        color = NeonGreen,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "SELECIONE SÁBIAMENTE A SUA EVIDÊNCIA:",
                            color = SubtextGray,
                            fontSize = 10.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            currentStep.options.forEach { opt ->
                                val cleanedAns = currentStep.correctAnswer.lowercase().trim()
                                val isCorrectOption = opt.lowercase().trim() == cleanedAns

                                Card(
                                    onClick = {
                                        if (isCorrectOption) {
                                            if (state.currentStepIndex >= 19) {

                                                onUpdateState(
                                                    state.copy(
                                                        completedCaseIds = state.completedCaseIds + case.id,
                                                        unlockedCaseIds = state.unlockedCaseIds + (case.id + 1),
                                                        currentScreen = "menu",
                                                        currentCaseId = null,
                                                        isOverlayOpen = false,
                                                        activeApp = null
                                                    )
                                                )
                                            } else {
                                                onUpdateState(
                                                    state.copy(
                                                        currentStepIndex = state.currentStepIndex + 1,
                                                        isOverlayOpen = false,
                                                        wrongAttempts = 0
                                                    )
                                                )
                                            }
                                        } else {
                                            onUpdateState(state.copy(wrongAttempts = state.wrongAttempts + 1))
                                        }
                                    },
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFF222230)),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            1.dp,
                                            Color.White.copy(alpha = 0.2f),
                                            RoundedCornerShape(10.dp)
                                        )
                                ) {
                                    Row(
                                        modifier = Modifier.padding(14.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(20.dp)
                                                .border(2.dp, NeonRed, CircleShape)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = opt,
                                            color = Color.White,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                    }
                                }
                            }

                            if (state.wrongAttempts > 0) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(imageVector = Icons.Default.Warning, contentDescription = "Error", tint = NeonRed, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "EVIDÊNCIA INCORRETA. TENTE NOVAMENTE!",
                                        color = NeonRed,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(
                                onClick = {
                                    if (state.scoreHintPennies >= 10) {
                                        onUpdateState(
                                            state.copy(
                                                scoreHintPennies = state.scoreHintPennies - 10,
                                                showCheatConfirm = true
                                            )
                                        )
                                    }
                                }
                            ) {
                                Row {
                                    Icon(imageVector = Icons.Default.Info, contentDescription = "Clue", tint = NeonGreen)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("COMPRAR PISTA (-10 CRÉDITOS)", color = NeonGreen, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                                }
                            }

                            TextButton(
                                onClick = {
                                    if (state.currentStepIndex >= 19) {
                                        onUpdateState(
                                            state.copy(
                                                completedCaseIds = state.completedCaseIds + case.id,
                                                unlockedCaseIds = state.unlockedCaseIds + (case.id + 1),
                                                currentScreen = "menu",
                                                currentCaseId = null,
                                                isOverlayOpen = false,
                                                activeApp = null
                                            )
                                        )
                                    } else {
                                        onUpdateState(
                                            state.copy(
                                                currentStepIndex = state.currentStepIndex + 1,
                                                isOverlayOpen = false
                                            )
                                        )
                                    }
                                }
                            ) {
                                Text("PULAR PASSO 🧪", color = Color.White.copy(alpha = 0.5f), fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                            }
                        }
                    }
                }
            }
        }

        if (state.showCheatConfirm) {
            AlertDialog(
                onDismissRequest = { onUpdateState(state.copy(showCheatConfirm = false)) },
                title = { Text("Pista Comprada") },
                text = { Text(currentStep.hint) },
                confirmButton = {
                    Button(onClick = { onUpdateState(state.copy(showCheatConfirm = false)) }) {
                        Text("Entendido")
                    }
                }
            )
        }
    }
}

@Composable
fun PhoneHomeScreen(case: CaseDefinition, onOpenApp: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                HomeScreenIcon(Icons.Default.Phone, "Telefone", Color(0xFF4CAF50)) { onOpenApp("whatsapp") }
                HomeScreenIcon(Icons.Default.Star, "Fotos", Color(0xFF2196F3)) { onOpenApp("photos") }
                HomeScreenIcon(Icons.Default.Add, "Wallet", Color(0xFFFF9800)) { onOpenApp("wallet") }
                HomeScreenIcon(Icons.Default.Email, "Gmail", Color(0xFFF44336)) { onOpenApp("gmail") }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                HomeScreenIcon(Icons.Default.Create, "Notas", Color(0xFFFFEB3B)) { onOpenApp("notes") }
                HomeScreenIcon(Icons.Default.Favorite, "Hinge", Color(0xFFE91E63)) { onOpenApp("tinder") }
                HomeScreenIcon(Icons.Default.Place, "Maps", Color(0xFF009688)) { onOpenApp("maps") }
                HomeScreenIcon(Icons.Default.Person, "Gemini", Color(0xFF9C27B0)) { onOpenApp("gemini") }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                HomeScreenIcon(Icons.Default.Settings, "Calculadora", Color(0xFF5C6BC0)) { onOpenApp("calculator") }
                HomeScreenIcon(Icons.Default.Menu, "2048", Color(0xFF8D6E63)) { onOpenApp("game2048") }
                HomeScreenIcon(Icons.Default.PlayArrow, "Snake (Cobra)", Color(0xFF33691E)) { onOpenApp("snake") }
                HomeScreenIcon(Icons.Default.PlayArrow, "Breakout", Color(0xFFE65100)) { onOpenApp("brickbreaker") }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                HomeScreenIcon(Icons.Default.Settings, "Ajustes", Color(0xFF78909C)) { onOpenApp("settings") }
            }
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.5f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Briefing",
                    tint = Color.Yellow,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Aviso: Extraindo dados do alvo \"${case.targetName}\".",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}

@Composable
fun HomeScreenIcon(
    icon: ImageVector,
    label: String,
    bg: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .width(68.dp)
    ) {
        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(bg),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 11.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun EmulatedWhatsApp(case: CaseDefinition, onBack: () -> Unit) {
    var inChatContact by remember { mutableStateOf<WhatsAppChat?>(null) }
    var showArchived by remember { mutableStateOf(false) }

    if (inChatContact == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121B22))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1F2C34))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "WhatsApp Clone", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            }

            Card(
                onClick = { showArchived = !showArchived },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2C34)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(14.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Archived", tint = Color(0xFF00A884))
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("Conversas Arquivadas", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Text(
                        text = if (showArchived) "Ocultar" else "Ver",
                        color = Color(0xFF00A884),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            val visibleChats = case.phoneData.whatsappChats.filter { it.isArchived == showArchived }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(visibleChats) { chat ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { inChatContact = chat }
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF00A884)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = chat.contactName.first().toString(),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = chat.contactName, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                    Text(text = chat.lastTime, color = Color.Gray, fontSize = 11.sp)
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = chat.lastMessage,
                                    color = Color.LightGray,
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                        HorizontalDivider(color = Color.Gray.copy(alpha = 0.2f))
                    }
                }
            }
        }
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0B141A))
        ) {
            val contact = inChatContact!!

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1F2C34))
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { inChatContact = null }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = contact.contactName.first().toString(), color = Color.White, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = contact.contactName, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text(text = "Online", color = Color(0xFF00A884), fontSize = 11.sp)
                }
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(contact.messages) { msg ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (msg.isMe) Arrangement.End else Arrangement.Start
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = if (msg.isMe) Color(0xFF005C4B) else Color(0xFF202C33)
                            ),
                            shape = if (msg.isMe) {
                                RoundedCornerShape(12.dp, 12.dp, 0.dp, 12.dp)
                            } else {
                                RoundedCornerShape(12.dp, 12.dp, 12.dp, 0.dp)
                            },
                            modifier = Modifier.widthIn(max = 260.dp)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = msg.text, color = Color.White, fontSize = 14.sp)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = msg.time,
                                    color = Color.White.copy(alpha = 0.6f),
                                    fontSize = 9.sp,
                                    modifier = Modifier.align(Alignment.End)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EmulatedPhotos(case: CaseDefinition, onBack: () -> Unit) {
    var selectedPhoto by remember { mutableStateOf<GalleryPhoto?>(null) }
    var activeTab by remember { mutableStateOf("fototeca") }
    var enteredPin by remember { mutableStateOf("") }
    var pinAccepted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text("Fotos Alvo", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Text("Editar", color = NeonRed, fontSize = 13.sp)
        }

        if (selectedPhoto == null) {
            if (activeTab == "fototeca") {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(case.phoneData.galleryPhotos.filter { !it.isDeleted }) { photo ->
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .background(Color(0xFF263238))
                                .border(1.dp, Color.Black)
                                .clickable { selectedPhoto = photo },
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(2.dp)
                            ) {
                                Text(text = photo.imageDescription, fontSize = 18.sp)
                                Text(
                                    text = photo.details,
                                    color = Color.LightGray,
                                    fontSize = 7.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            } else {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AlbumRow("Itens Deletados (Lixeira)", Icons.Default.Delete, Colors = Color.Red) {

                        selectedPhoto = case.phoneData.galleryPhotos.find { it.isDeleted }
                    }

                    AlbumRow("Compartilhamento Familiar", Icons.Default.Share, Colors = Color.Blue) {}

                    AlbumRow("Pasta Segura 🔒", Icons.Default.Lock, Colors = Color.Yellow) {
                        if (pinAccepted) {
                            selectedPhoto = case.phoneData.galleryPhotos.find { it.requiresPin }
                        } else {

                            activeTab = "pins_required"
                        }
                    }
                }
            }

            if (activeTab == "pins_required") {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Digite o PIN Seguro de 4 dígitos", color = Color.White, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "• ".repeat(enteredPin.length) + "_ ".repeat(4 - enteredPin.length),
                        color = NeonGreen,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    val rows = listOf(
                        listOf("1", "2", "3"),
                        listOf("4", "5", "6"),
                        listOf("7", "8", "9"),
                        listOf("C", "0", "OK")
                    )

                    rows.forEach { row ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            row.forEach { num ->
                                Button(
                                    onClick = {
                                        when (num) {
                                            "C" -> enteredPin = ""
                                            "OK" -> {
                                                if (enteredPin == "1992" || enteredPin == "2016" || enteredPin == "0315") {
                                                    pinAccepted = true
                                                    activeTab = "albuns"
                                                } else {
                                                    enteredPin = ""
                                                }
                                            }
                                            else -> {
                                                if (enteredPin.length < 4) {
                                                    enteredPin += num
                                                }
                                            }
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                                    shape = CircleShape,
                                    modifier = Modifier.size(50.dp)
                                ) {
                                    Text(text = num, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0D0D11))
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Fototeca",
                    color = if (activeTab == "fototeca") NeonRed else Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { activeTab = "fototeca" }
                )
                Text(
                    text = "Álbuns",
                    color = if (activeTab == "albuns") NeonRed else Color.Gray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { activeTab = "albuns" }
                )
            }
        } else {

            val photo = selectedPhoto!!
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { selectedPhoto = null }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color(0xFF1E1E28), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = photo.imageDescription, fontSize = 48.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = photo.details,
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AlbumRow(label: String, icon: ImageVector, Colors: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(Color(0xFF12121A), RoundedCornerShape(8.dp))
            .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = label, tint = Colors, modifier = Modifier.size(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun EmulatedWallet(case: CaseDefinition, onBack: () -> Unit) {
    var selectedCardIndex by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F15))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text("Apple Wallet", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE50914))
                    .padding(16.dp)
                    .clickable { selectedCardIndex = 1 }
            ) {
                Column {
                    Text("GOLD RESERVA", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(40.dp))
                    Text("Visa Platinum •••• 8842", color = Color.White, fontSize = 10.sp)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .height(110.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0D1B2A))
                    .border(1.dp, Color.White.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .padding(16.dp)
                    .clickable { selectedCardIndex = 0 }
            ) {
                Column {
                    Text("FIRMA DIGITAL CORPORATIVA", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(30.dp))
                    Text("Mastercard Black •••• 2016", color = Color.White, fontSize = 10.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "HISTÓRICO DE TRANSAÇÕES RECENTES",
            color = Color.Gray,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(case.phoneData.walletTransactions) { tx ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1B1B26)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = tx.merchant, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(text = tx.date, color = Color.Gray, fontSize = 11.sp)
                        }
                        Text(
                            text = "- ${tx.amount}",
                            color = NeonRed,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmulatedGmail(case: CaseDefinition, onBack: () -> Unit) {
    var openEmail by remember { mutableStateOf<GmailMessage?>(null) }

    if (openEmail == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD44638))
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Text("Gmail Inbox", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(case.phoneData.gmailInboxes) { mail ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { openEmail = mail }
                            .padding(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = mail.sender, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            Text(text = mail.date, color = Color.Gray, fontSize = 11.sp)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = mail.subject, color = Color.DarkGray, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Text(
                            text = mail.snippet,
                            color = Color.Gray,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    HorizontalDivider(color = Color.LightGray)
                }
            }
        }
    } else {
        val mail = openEmail!!
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD44638))
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { openEmail = null }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Text("E-mail Integrado", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = mail.subject, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = mail.sender.first().toString(), color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = mail.sender, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Text(text = "para mim", color = Color.Gray, fontSize = 11.sp)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = mail.body, color = Color.DarkGray, fontSize = 15.sp, lineHeight = 22.sp)
            }
        }
    }
}

@Composable
fun EmulatedNotes(case: CaseDefinition, onBack: () -> Unit) {
    var openNote by remember { mutableStateOf<NoteEntry?>(null) }
    var noteEnteredPin by remember { mutableStateOf("") }
    var inAuthLockFlow by remember { mutableStateOf(false) }

    if (openNote == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFEF9E7))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF39C12))
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
                Text("Notas Amarelas", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(case.phoneData.notes) { note ->
                    Card(
                        onClick = {
                            if (note.isLocked) {
                                openNote = note
                                inAuthLockFlow = true
                            } else {
                                openNote = note
                                inAuthLockFlow = false
                            }
                        },
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(14.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(text = note.title, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                if (!note.isLocked) {
                                    Text(text = note.content, color = Color.Gray, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                }
                            }
                            if (note.isLocked) {
                                Icon(imageVector = Icons.Default.Lock, contentDescription = "Locked Note", tint = Color(0xFFF39C12))
                            }
                        }
                    }
                }
            }
        }
    } else {
        val note = openNote!!
        if (inAuthLockFlow) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1E1E28))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Vault", tint = NeonRed, modifier = Modifier.size(64.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text("Nota Protegida por Blockchain", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("Digite o PIN associado ao irmão/conselheiro:", color = Color.Gray, fontSize = 12.sp)

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "• ".repeat(noteEnteredPin.length) + "_ ".repeat(4 - noteEnteredPin.length),
                    color = NeonGreen,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Monospace
                )

                Spacer(modifier = Modifier.height(20.dp))

                val keys = listOf(
                    listOf("1", "2", "3"),
                    listOf("4", "5", "6"),
                    listOf("7", "8", "9"),
                    listOf("C", "0", "OK")
                )

                keys.forEach { row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                        row.forEach { k ->
                            Button(
                                onClick = {
                                    when (k) {
                                        "C" -> noteEnteredPin = ""
                                        "OK" -> {
                                            if (noteEnteredPin == note.pinCode) {
                                                inAuthLockFlow = false
                                            } else {
                                                noteEnteredPin = ""
                                            }
                                        }
                                        else -> {
                                            if (noteEnteredPin.length < 4) noteEnteredPin += k
                                        }
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                                modifier = Modifier.size(60.dp),
                                shape = CircleShape
                            ) {
                                Text(k, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
        } else {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFEF9E7))
                    .padding(16.dp)
            ) {
                IconButton(onClick = { openNote = null }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = note.title, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = note.content, color = Color.DarkGray, fontSize = 16.sp, lineHeight = 22.sp)
            }
        }
    }
}

@Composable
fun EmulatedTinder(case: CaseDefinition, onBack: () -> Unit) {
    var swipeMatched by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0015))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text("Hinge Match", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Hinge Icon", tint = Color(0xFFE91E63))
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (case.phoneData.matches.isNotEmpty()) {
            val match = case.phoneData.matches.first()

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E2C)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFE91E63), RoundedCornerShape(12.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF37474F)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile", tint = Color.LightGray, modifier = Modifier.size(64.dp))
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("FOTO SECRETA CRIPTOGRAFADA", color = Color.LightGray, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "${match.name}, ${match.age}",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = match.bio,
                            color = Color.LightGray,
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    }

                    Column {
                        Text(
                            text = "DIÁLOGO RECENTE (HINGE DATA ENCRYPT):",
                            color = Color(0xFFE91E63),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                match.chatHistory.takeLast(2).forEach { chat ->
                                    Text(
                                        text = "${if (chat.isMe) "Diego" else match.name}: ${chat.text}",
                                        color = if (chat.isMe) Color.White else Color(0xFFE91E63),
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text("Sem Matches nesta rede local.", color = Color.Gray)
            }
        }
    }
}

@Composable
fun EmulatedMaps(case: CaseDefinition, onBack: () -> Unit) {
    var selectedPin by remember { mutableStateOf<MapPinDefinition?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E2836))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text("Google Maps Alvo", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Default.Place, contentDescription = "Loc", tint = Color.White)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .drawBehind {

                    val gridSpacing = 40.dp.toPx()
                    for (x in 0..size.width.toInt() step gridSpacing.toInt()) {
                        drawLine(
                            color = Color(0xFF2C3E50),
                            start = Offset(x.toFloat(), 0f),
                            end = Offset(x.toFloat(), size.height),
                            strokeWidth = 1f
                        )
                    }
                    for (y in 0..size.height.toInt() step gridSpacing.toInt()) {
                        drawLine(
                            color = Color(0xFF2C3E50),
                            start = Offset(0f, y.toFloat()),
                            end = Offset(size.width, y.toFloat()),
                            strokeWidth = 1f
                        )
                    }
                }
        ) {

            case.phoneData.mapPins.forEachIndexed { index, pin ->
                val xPos = if (index == 0) 100.dp else 220.dp
                val yPos = if (index == 0) 180.dp else 280.dp

                Box(
                    modifier = Modifier
                        .offset(x = xPos, y = yPos)
                        .clickable { selectedPin = pin }
                        .size(36.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Pin Map",
                        tint = NeonRed,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            selectedPin?.let { pin ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = HackerCardBg),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .border(1.dp, NeonGreen, RoundedCornerShape(12.dp))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = pin.title, color = NeonGreen, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            IconButton(onClick = { selectedPin = null }, modifier = Modifier.size(20.dp)) {
                                Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Endereço: ${pin.address}", color = Color.White, fontSize = 13.sp)
                        Text(text = "Coordenadas: ${pin.latLng}", color = Color.Gray, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        Text(text = pin.details, color = Color.LightGray, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun EmulatedGemini(case: CaseDefinition, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0E17))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text("Gemini AI Prompt Link", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF231B42)),
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color(0xFF9C27B0), RoundedCornerShape(12.dp))
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("HISTÓRICO DA CONTA CENTRAL", color = Color(0xFF9C27B0), fontWeight = FontWeight.Bold, fontSize = 9.sp, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Dúvidas enviadas e guardadas em blockchain do alvo:", color = Color.White, fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(case.phoneData.geminiQueries) { q ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF16151F))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "User", tint = Color.White, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "Prompt:", color = Color.LightGray, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        }
                        Text(text = q.prompt, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.Person, contentDescription = "Gemini", tint = Color(0xFF9C27B0), modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "Gemini Respondeu:", color = Color(0xFF9C27B0), fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                        }
                        Text(text = q.response, color = Color.LightGray, fontSize = 12.sp, lineHeight = 16.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun EmulatedSettings(case: CaseDefinition, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E24))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ajustes Gerais", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            HorizontalSettingRow("Conexão Wi-Fi", case.phoneData.wifiNetwork, Icons.Default.Settings)
            HorizontalSettingRow("Bateria e Saúde", "${case.phoneData.batteryPct}% nível", Icons.Default.Info)
            HorizontalSettingRow("Código Pessoal Empregado", case.phoneData.employeeCode, Icons.Default.Person)
            HorizontalSettingRow("Sistema Operacional", "v19.5 (StalkOS)", Icons.Default.Info)
        }
    }
}

@Composable
fun HorizontalSettingRow(label: String, valuel: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2E2E38), RoundedCornerShape(8.dp))
            .padding(14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = label, tint = NeonRed, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = label, color = Color.White, fontWeight = FontWeight.Bold)
        }
        Text(text = valuel, color = SubtextGray, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
    }
}

@Composable
fun EmulatedCalculator(case: CaseDefinition, onBack: () -> Unit) {
    var calcInput by remember { mutableStateOf("") }
    var cofreAberto by remember { mutableStateOf(false) }

    if (cofreAberto) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(HackerBlack)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("COFRE CRIPTOGRÁFICO DE MARCOS / CARLOS", color = NeonRed, fontWeight = FontWeight.Bold, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                IconButton(onClick = { cofreAberto = false }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Icon(imageVector = Icons.Default.Lock, contentDescription = "Unlocked", tint = NeonGreen, modifier = Modifier.size(80.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text("VAULT INTERNO DESBLOQUEADO", color = NeonGreen, fontWeight = FontWeight.Bold, fontSize = 18.sp, fontFamily = FontFamily.Monospace)

            Spacer(modifier = Modifier.height(20.dp))

            if (case.id == 2) {
                Card(colors = CardDefaults.cardColors(containerColor = HackerCardBg), modifier = Modifier.fillMaxWidth().border(1.dp, NeonRed)) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text("EVIDÊNCIA #1: PRINT DE CHANTAGEM DE MORTE", color = NeonRed, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("\"Se você não pagar amanhã o débito de R$ 120.000,00 do cassino da firma, vamos fazer uma cobrança física...\"", color = Color.White)
                    }
                }
            } else if (case.id == 9) {
                Card(colors = CardDefaults.cardColors(containerColor = HackerCardBg), modifier = Modifier.fillMaxWidth().border(1.dp, NeonRed)) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text("EVIDÊNCIA COMPROMETEDORA DE CARLOS #1:", color = NeonRed, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("FOTO DOS PROTÓTIPOS DO MOTOR X-7 (CÓDIGOS ENCRIPTADOS NO SPOTIFY COMPARTILHADO)", color = Color.White)
                    }
                }
            } else {
                Text("Nenhuma evidência extra armazenada no cofre deste caso.", color = Color.LightGray)
            }
        }
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = if (calcInput.isEmpty()) "0" else calcInput,
                color = Color.White,
                fontSize = 36.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            val rows = listOf(
                listOf("7", "8", "9", "/"),
                listOf("4", "5", "6", "*"),
                listOf("1", "2", "3", "-"),
                listOf("C", "0", "=", "+")
            )

            rows.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    row.forEach { char ->
                        Button(
                            onClick = {
                                when (char) {
                                    "C" -> calcInput = ""
                                    "=" -> {

                                        if (calcInput.contains("8192") || calcInput.contains("4099")) {
                                            cofreAberto = true
                                        } else {
                                            calcInput = "Operação Completa"
                                        }
                                    }
                                    else -> {
                                        if (calcInput.length < 15) {
                                            calcInput += char
                                        }
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (char == "=" || char == "+" || char == "-" || char == "*" || char == "/") Color(0xFFFF9800) else Color.DarkGray
                            ),
                            shape = CircleShape,
                            modifier = Modifier
                                .size(64.dp)
                                .padding(vertical = 4.dp)
                        ) {
                            Text(text = char, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Emulated2048Game(case: CaseDefinition, onBack: () -> Unit) {
    var score by remember { mutableStateOf(0) }
    var showEasterEggMsg by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF8EF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.DarkGray)
                }
                Text("2048 STALKIE", fontSize = 24.sp, fontWeight = FontWeight.Black, color = Color(0xFF776E65))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFBBADA0))) {
                    Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("SCORE", color = Color(0xFFEEE4DA), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Text("$score", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFFBBADA0))) {
                    Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("RECORD", color = Color(0xFFEEE4DA), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Text("8192", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .size(260.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFBBADA0))
                    .padding(6.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    repeat(4) { r ->
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            repeat(4) { c ->
                                val tileVal = if (r == 0 && c == 0) "2" else if (r == 1 && c == 2) "4" else ""
                                Box(
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFFCDC1B4)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = tileVal, color = Color(0xFF776E65), fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
        }

        showEasterEggMsg?.let { msg ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF8D6E63)),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.White)
            ) {
                Column(modifier = Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("EASTER EGG DETECTADO!", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = msg, color = Color.Yellow, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    score += 32
                    if (score >= 64 && case.id == 7) {
                        showEasterEggMsg = "CÓDIGO SECRETO REVELADO: \"Backup_GPS_Ativado_Abrigo2\""
                    }
                    if (score >= 128 && case.id == 11) {
                        showEasterEggMsg = "SINAL DO ECLIPSE: \"Faltam exatamente 10 minutos!\""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBADA0))
            ) {
                Text("CORTAR BLOCO / RECORDE (+32 PONTOS)", color = Color.White)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun EmulatedSnakeGame(case: CaseDefinition, onBack: () -> Unit) {
    var score by remember { mutableStateOf(0) }
    var gameCompletedStatus by remember { mutableStateOf<String?>(null) }
    var failCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text("SNAKE COBRA VAULT", color = Color.Green, fontWeight = FontWeight.Bold, fontSize = 16.sp, fontFamily = FontFamily.Monospace)
        }

        Box(
            modifier = Modifier
                .size(220.dp)
                .border(2.dp, Color.Green)
                .background(Color(0xFF0F260D)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("🟢 • • • • •", color = Color.Green, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("🍏 (Maçã Secreta)", color = NeonRed, fontSize = 14.sp)
            }
        }

        gameCompletedStatus?.let { status ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1B5E20)),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.White)
            ) {
                Text(
                    text = status,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(14.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = {

                        failCount++
                        score = 0
                        if (failCount >= 3 && case.id == 4) {
                            gameCompletedStatus = "LIXEIRA PROTEGIDA DA NUVEM DESBLOQUEADA!\nRascunhos originais com nome de Sofia salvos em cache!"
                        } else {
                            gameCompletedStatus = "Você falhou a corrida! Tentativa $failCount/3"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = NeonRed)
                ) {
                    Text("BATER NA PAREDE COM ZERO", color = Color.White)
                }

                Button(
                    onClick = {

                        score = 3
                        if (case.id == 8) {
                            gameCompletedStatus = "CERTIDÃO REVELADA:\nCópias das certidões de nascimento do Júnior com nome do Roberto como pai!"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("COMER 3 MAÇÃS E BATER DIREITA", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun EmulatedBrickBreaker(case: CaseDefinition, onBack: () -> Unit) {
    var ballStatus by remember { mutableStateOf("Em jogo") }
    var resultText by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Text("BRICKBREAKER STALKIE", color = NeonBlue, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .border(2.dp, NeonBlue)
                .background(Color(0xFF0C1021)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("🔴 Bola caindo...", color = Color.White)
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .width(80.dp)
                        .height(8.dp)
                        .background(NeonBlue, RoundedCornerShape(4.dp))
                ) {}
            }
        }

        resultText?.let { txt ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, NeonBlue)
            ) {
                Text(text = txt, color = Color.White, modifier = Modifier.padding(14.dp), textAlign = TextAlign.Center)
            }
        }

        Button(
            onClick = {

                ballStatus = "Perdeu a bola imediato"
                if (case.id == 6) {
                    resultText = "CONTATO DE EMERGÊNCIA OCULTO REVELADO:\nInspetor Torres - Proteção a Testemunhas"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = NeonRed),
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text("SOLTAR BOLA E PERDER DE PROPÓSITO", color = Color.White)
        }
    }
}
