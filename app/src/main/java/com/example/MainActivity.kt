package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.MainViewModel
import com.example.ui.Screen
import com.example.ui.components.AppBottomBar
import com.example.ui.components.AppTopBar
import com.example.ui.screens.ExamIntroScreen
import com.example.ui.screens.ExamPlayScreen
import com.example.ui.screens.ExamResultScreen
import com.example.ui.screens.HistoryScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearningScreen
import com.example.ui.screens.SignsScreen
import com.example.ui.screens.StatsScreen
import com.example.ui.screens.TipsScreen
import com.example.ui.screens.WrongQuestionsScreen
import com.example.ui.theme.IvoryBackground
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp(viewModel: MainViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val examResults by viewModel.examResults.collectAsStateWithLifecycle()
    val questionProgress by viewModel.questionProgress.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    // Display snackbar / toast notifications
    LaunchedEffect(uiState.snackbarMessage) {
        uiState.snackbarMessage?.let { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            viewModel.clearSnackbar()
        }
    }

    // System Back Button Handling
    BackHandler(enabled = uiState.currentScreen != Screen.HOME) {
        when (uiState.currentScreen) {
            Screen.EXAM_PLAYING -> {
                viewModel.cancelExam()
            }
            Screen.EXAM_RESULT -> {
                viewModel.navigateTo(Screen.HOME)
            }
            else -> {
                viewModel.navigateTo(Screen.HOME)
            }
        }
    }

    val screenTitle = when (uiState.currentScreen) {
        Screen.HOME -> "Ôn Thi GPLX A1"
        Screen.LEARNING -> "Luyện tập 250 câu"
        Screen.EXAM_INTRO -> "Thi thử sát hạch"
        Screen.EXAM_PLAYING -> "Đang làm bài thi"
        Screen.EXAM_RESULT -> "Kết quả thi"
        Screen.HISTORY -> "Lịch sử thi thử"
        Screen.WRONG_QUESTIONS -> "Câu trả lời sai"
        Screen.SIGNS -> "Tất cả biển báo"
        Screen.TIPS -> "Mẹo ghi nhớ nhanh"
        Screen.STATS -> "Thống kê học tập"
    }

    val screenSubtitle = when (uiState.currentScreen) {
        Screen.HOME -> "BẰNG LÁI XE MÁY A1 · A"
        Screen.LEARNING -> "${uiState.learningQuestions.size} CÂU HỎI CHUẨN"
        Screen.EXAM_INTRO -> "25 CÂU · 19 PHÚT"
        Screen.EXAM_PLAYING -> "TỰ ĐỘNG CHẤM ĐIỂM"
        Screen.EXAM_RESULT -> "CHI TIẾT ĐÁP ÁN"
        Screen.HISTORY -> "LƯU TRỮ TRÊN THIẾT BỊ"
        Screen.WRONG_QUESTIONS -> "ÔN TẬP MỤC TIÊU"
        Screen.SIGNS -> "185 BIỂN BÁO & VẠCH KẺ ĐẦY ĐỦ"
        Screen.TIPS -> "BÍ QUYẾT 100% ĐỖ"
        Screen.STATS -> "TIẾN ĐỘ & TỶ LỆ ĐỖ"
    }

    val canGoBack = uiState.currentScreen != Screen.HOME

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(IvoryBackground),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AppTopBar(
                title = screenTitle,
                subtitle = screenSubtitle,
                canNavigateBack = canGoBack,
                onNavigateBack = {
                    if (uiState.currentScreen == Screen.EXAM_PLAYING) {
                        viewModel.cancelExam()
                    } else {
                        viewModel.navigateTo(Screen.HOME)
                    }
                }
            )
        },
        bottomBar = {
            // Show bottom bar on primary tabs
            if (uiState.currentScreen != Screen.EXAM_PLAYING) {
                AppBottomBar(
                    currentScreen = uiState.currentScreen,
                    onNavigate = { screen ->
                        if (screen == Screen.LEARNING) {
                            viewModel.setLearningCategory(com.example.data.model.QuestionCategory.ALL)
                        }
                        viewModel.navigateTo(screen)
                    }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(IvoryBackground)
                .padding(innerPadding)
        ) {
            when (uiState.currentScreen) {
                Screen.HOME -> HomeScreen(
                    progressList = questionProgress,
                    onNavigate = { viewModel.navigateTo(it) },
                    onSelectCategory = { cat ->
                        viewModel.setLearningCategory(cat)
                    },
                    onStartWrongPractice = { wrongIds ->
                        viewModel.startWrongQuestionsPractice(wrongIds)
                    }
                )

                Screen.LEARNING -> LearningScreen(
                    questions = uiState.learningQuestions,
                    currentIndex = uiState.learningIndex,
                    selectedAnswer = uiState.learningSelectedAnswer,
                    isChecked = uiState.learningIsChecked,
                    selectedCategory = uiState.selectedCategory,
                    progressList = questionProgress,
                    onSelectCategory = { viewModel.setLearningCategory(it) },
                    onSelectAnswer = { viewModel.selectLearningAnswer(it) },
                    onCheckAnswer = { viewModel.checkLearningAnswer() },
                    onNextQuestion = { viewModel.nextLearningQuestion() },
                    onPrevQuestion = { viewModel.prevLearningQuestion() },
                    onJumpToQuestion = { viewModel.jumpToLearningQuestion(it) },
                    onToggleBookmark = { viewModel.toggleBookmark(it) }
                )

                Screen.EXAM_INTRO -> ExamIntroScreen(
                    onStartExam = { viewModel.startExam() }
                )

                Screen.EXAM_PLAYING -> ExamPlayScreen(
                    questions = uiState.examQuestions,
                    currentIndex = uiState.currentExamIndex,
                    answers = uiState.examAnswers,
                    markedQuestions = uiState.markedExamQuestions,
                    secondsRemaining = uiState.examSecondsRemaining,
                    onSelectAnswer = { viewModel.selectExamAnswer(it) },
                    onNextQuestion = { viewModel.nextExamQuestion() },
                    onPrevQuestion = { viewModel.prevExamQuestion() },
                    onJumpToQuestion = { viewModel.jumpToExamQuestion(it) },
                    onToggleMark = { viewModel.toggleMarkExamQuestion() },
                    onSubmitExam = { viewModel.submitExam() },
                    onCancelExam = { viewModel.cancelExam() }
                )

                Screen.EXAM_RESULT -> ExamResultScreen(
                    result = uiState.lastResultEntity,
                    reviewItems = uiState.lastReviewItems,
                    onRetakeExam = { viewModel.startExam() },
                    onGoHome = { viewModel.navigateTo(Screen.HOME) }
                )

                Screen.HISTORY -> HistoryScreen(
                    examResults = examResults,
                    onViewExam = { viewModel.viewPastExam(it) },
                    onDeleteExam = { viewModel.deleteHistoryExam(it) },
                    onClearAllHistory = { viewModel.clearAllHistory() },
                    onStartExam = { viewModel.startExam() }
                )

                Screen.WRONG_QUESTIONS -> WrongQuestionsScreen(
                    progressList = questionProgress,
                    onStartPractice = { wrongIds ->
                        viewModel.startWrongQuestionsPractice(wrongIds)
                    }
                )

                Screen.SIGNS -> SignsScreen()

                Screen.TIPS -> TipsScreen()

                Screen.STATS -> StatsScreen(
                    progressList = questionProgress,
                    examResults = examResults,
                    onResetProgress = { viewModel.resetProgress() }
                )
            }
        }
    }
}
